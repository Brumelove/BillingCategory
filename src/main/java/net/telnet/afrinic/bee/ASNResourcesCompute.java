package net.telnet.afrinic.bee;

import net.afrinic.myafrinic.commons.model.resources.asnum.ASNType;
import net.afrinic.myafrinic.commons.model.resources.asnum.ASNumber;
import net.afrinic.myafrinic.commons.whois.Ipv6Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ASNResourcesCompute implements InternetResourceComputable{
    private final String REGEX = "(aut-num:) (.+)";
    @Override
    public int compute(String whoisResponse) {
        List<ASNType> asnTypes = new ArrayList<>();

        Pattern resourcePattern = Pattern.compile(REGEX);
        Matcher matcher = resourcePattern.matcher(whoisResponse);
        while (matcher.find()) {
            Long asnKey = Long.valueOf(matcher.group(2).trim());
            ASNType asnType = ASNType.forASN(asnKey);
            addToListIfNecessary(asnTypes, asnType);
        }
    }

    private void addToListIfNecessary(List<ASNType> asnTypes, ASNType asnType) {
        boolean contains = checkIfContains(asnTypes, asnType);
        if (!contains) {
            asnTypes.add(asnType);
        }
    }
}
