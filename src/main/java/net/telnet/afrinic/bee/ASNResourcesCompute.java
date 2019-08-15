package net.telnet.afrinic.bee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ASNResourcesCompute implements InternetResourceComputable {
    private static final String REGEX = "(aut-num:) (.+)";

    @Override
    public int compute(String whoisResponse) {

        int count = 0;
        Pattern resourcePattern = Pattern.compile(REGEX);
        Matcher matcher = resourcePattern.matcher(whoisResponse);

        while (matcher.find()) {
            count++;
        }
        return count;
    }





}
