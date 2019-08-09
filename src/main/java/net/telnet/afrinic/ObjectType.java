package net.telnet.afrinic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectType implements Resource {
    private int count;
    Pattern RESOURCE_PATTERN;

    @Override
    public void ipv4contains(String ipv4Resource) {
       RESOURCE_PATTERN = Pattern.compile("^(?:[0-9]|[1-9][0-9]+)(?:-(?:[0-9]|[1-9][0-9]+)+)?$");
        final Matcher matcher = RESOURCE_PATTERN.matcher(ipv4Resource);
        while(matcher.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher.start() + " - " + matcher.end());
        }
    }

    @Override
    public void ipv6contains(String ipv6Resource) {
        RESOURCE_PATTERN = Pattern.compile("(?i)^[0-9a-f](?:[.][0-9a-f]){0,31}$");
        final Matcher matcher = RESOURCE_PATTERN.matcher(ipv6Resource);
        while(matcher.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher.start() + " - " + matcher.end());
        }

    }

    @Override
    public void autNumcontains(String autNumKey) {
        RESOURCE_PATTERN =  Pattern.compile("(?i)^AS([0-9]+)$");
        final Matcher matcher = RESOURCE_PATTERN.matcher(autNumKey);
        while(matcher.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher.start() + " - " + matcher.end());
        }

    }
}

/***
 * class ObjectTyoe implements Resource {
 *     public int getCountResourceMatches() {
 *         return countResourceMatches;
 *     }
 *
 *     public void setCountResourceMatches(int countResourceMatches) {
 *         this.countResourceMatches = countResourceMatches;
 *     }
 *
 *     private int countResourceMatches;
 *
 *     @Override
 *     public void IPv4(String inetnum) {
 *         final Pattern OCTET_PATTERN = Pattern.compile("^(?:[0-9]|[1-9][0-9]+)(?:-(?:[0-9]|[1-9][0-9]+)+)?$");
 *         final Matcher matcher = OCTET_PATTERN.matcher(inetnum);
 *
 *         if (matcher.matches()) {
 *             setCountResourceMatches(StringUtils.countMatches(inetnum, ""));
 *         }
 *         System.out.println("inetnum: " + getCountResourceMatches());
 *
 *     }
 *
 *     @Override
 *     public void IPv6(String inet6num) {
 *         final Pattern REVERSE_PATTERN = Pattern.compile("(?i)^[0-9a-f](?:[.][0-9a-f]){0,31}$");
 *         final Matcher matcher = REVERSE_PATTERN.matcher(inet6num);
 *         if (matcher.matches()) {
 *             setCountResourceMatches(StringUtils.countMatches(inet6num, ""));
 *         }
 *         System.out.println("inet6num: " + getCountResourceMatches());    }
 *
 *     @Override
 *     public void AUTNUM(String autnum) {
 *         final Pattern AUTNUM_PATTERN = Pattern.compile("(?i)^AS([0-9]+)$");
 *         final Matcher matcher = AUTNUM_PATTERN.matcher(autnum);
 *         if (matcher.matches()) {
 *             setCountResourceMatches(StringUtils.countMatches(autnum, ""));
 *         }
 *         System.out.println("autnum: " + getCountResourceMatches());
 *     }*/
