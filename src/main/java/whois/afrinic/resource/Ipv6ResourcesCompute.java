package whois.afrinic.resource;

import net.afrinic.myafrinic.commons.whois.Ipv6Resource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ipv6ResourcesCompute implements InternetResourceComputable {
    private static final String REGEX = "(inet6num:) (.+)";

    @Override
    public Integer compute(String whoisResponse) {
        List<Ipv6Resource> ipv6Resources = new ArrayList<>();

        Pattern resourcePattern = Pattern.compile(REGEX);
        Matcher matcher = resourcePattern.matcher(whoisResponse);
        while (matcher.find()) {
            String ipv6Key = matcher.group(2).trim();
            Ipv6Resource ipv6Resource = Ipv6Resource.parse(ipv6Key);
            addToListIfNecessary(ipv6Resources, ipv6Resource);
        }
        BigInteger totalIps = computeTotalNbOfIpv6Addresses(ipv6Resources);
        return computeCidr(totalIps);
    }

    private Integer computeCidr(BigInteger totalIps) {
        return !BigInteger.ZERO.equals(totalIps) ? 128 - (totalIps.toString(2).length()) : null;
    }

    private BigInteger computeTotalNbOfIpv6Addresses(List<Ipv6Resource> ipv6Resources) {
        BigInteger total = BigInteger.ZERO;
        for (Ipv6Resource ipv6Resource : ipv6Resources) {
            total = total.add(ipv6Resource.end().subtract(ipv6Resource.begin())).add(BigInteger.ONE);
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
