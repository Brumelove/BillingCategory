package net.telnet.afrinic.bee;

import net.afrinic.myafrinic.commons.whois.Ipv4Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ipv4ResourcesCompute implements InternetResourceComputable {
    private static final String REGEX = "(inetnum:) (.+)";

    @Override
    public Integer compute(String whoisResponse) {
        List<Ipv4Resource> ipv4Resources = new ArrayList<>();

        Pattern resourcePattern = Pattern.compile(REGEX);
        Matcher matcher = resourcePattern.matcher(whoisResponse);
        while (matcher.find()) {
            String ipv4Key = matcher.group(2).trim();
            Ipv4Resource ipv4Resource = Ipv4Resource.parse(ipv4Key);
            addToListIfNecessary(ipv4Resources, ipv4Resource);
        }

        // at this stage, we have all the top level ipv4 blocks
        int totalIps = computeTotalNbOfIpv4Addresses(ipv4Resources);
        return computeCidr(totalIps);
    }

    private Integer computeCidr(int totalIps) {
        return totalIps > 0 ? 32 - Integer.toString(totalIps,2).length() : null;
    }

    private int computeTotalNbOfIpv4Addresses(List<Ipv4Resource> ipv4Resources) {
        int total = 0;
        for (Ipv4Resource ipv4Resource : ipv4Resources) {
            total += ipv4Resource.end().intValue() - ipv4Resource.begin().intValue() + 1;
        }
        return total;
    }

    private void addToListIfNecessary(List<Ipv4Resource> ipv4Resources, Ipv4Resource ipv4Resource) {
        boolean contains = checkIfContains(ipv4Resources, ipv4Resource);
        if (!contains  ) {
            ipv4Resources.add(ipv4Resource);
        }
    }

    private boolean checkIfContains(List<Ipv4Resource> ipv4Resources, Ipv4Resource candidateIpv4Resource) {
        for (Ipv4Resource ipv4Resource : ipv4Resources) {
            if (ipv4Resource.contains(candidateIpv4Resource)) {
                return true;
            }
        }

        // no ipv4 resource in the list contains the candidate
        return false;
    }
}
