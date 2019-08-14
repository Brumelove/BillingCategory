package net.telnet.afrinic.bee;

import net.afrinic.myafrinic.commons.whois.Ipv6Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ipv6ResourcesCompute implements InternetResourceComputable {
    private final String REGEX = "(inet6num:) (.+)";
    @Override
    public int compute(String whoisResponse) {
        List<Ipv6Resource> ipv6Resources = new ArrayList<>();

        Pattern resourcePattern = Pattern.compile(REGEX);
        Matcher matcher = resourcePattern.matcher(whoisResponse);
        while (matcher.find()) {
            String ipv6Key = matcher.group(2).trim();
            Ipv6Resource ipv6Resource = Ipv6Resource.parse(ipv6Key);
            addToListIfNecessary(ipv6Resources, ipv6Resource);
        }
        int totalIps = computeTotalNbOfIpv6Addresses(ipv6Resources);
        int finalCidr = computeCidr(totalIps);
        return finalCidr;
    }
    private int computeCidr(int totalIps) {
        return Double.valueOf(Math.floor(Math.log(totalIps)/Math.log(2))).intValue();
    }

    private int computeTotalNbOfIpv6Addresses(List<Ipv6Resource> ipv6Resources) {
        int total = 0;
        for (Ipv6Resource ipv6Resource : ipv6Resources) {
            total += ipv6Resource.end().intValue() - ipv6Resource.begin().intValue() + 1;
        }
        return total;
    }

    private void addToListIfNecessary(List<Ipv6Resource> ipv6Resources, Ipv6Resource ipv6Resource) {
        boolean contains = checkIfContains(ipv6Resources, ipv6Resource);
        if (!contains) {
            ipv6Resources.add(ipv6Resource);
        }
    }

    private boolean checkIfContains(List<Ipv6Resource> ipv6Resources, Ipv6Resource candidateIpv6Resource) {
        for (Ipv6Resource ipv6Resource : ipv6Resources) {
            if (ipv6Resource.contains(candidateIpv6Resource)) {
                return true;
            }
        }

        // no ipv6 resource in the list contains the candidate
        return false;
    }
}
