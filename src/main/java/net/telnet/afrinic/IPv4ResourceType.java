package net.telnet.afrinic;

import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressSeqRange;
import inet.ipaddr.IPAddressString;
import net.afrinic.myafrinic.commons.whois.Ipv4Resource;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPv4ResourceType {

    public void ipv4contains(String whoisquery) {
        String REGEX = "(inetnum:) (.+)";
        Pattern RESOURCE_PATTERN = Pattern.compile(REGEX);

        Matcher matcher = RESOURCE_PATTERN.matcher(whoisquery);

        while (matcher.find()) {
            String ipv4Key = matcher.group(2);
            String split[] = ipv4Key.split("-", 2);
            String str1 = split[0];
            String str2 = split[1];


            IPAddressString string1 = new IPAddressString(str1);
            IPAddressString string2 = new IPAddressString(str2);
            IPAddress one = string1.getAddress(), two = string2.getAddress();

            IPAddressSeqRange range = one.toSequentialRange(two);
            IPAddress blocks[] = range.spanWithPrefixBlocks();

            String fresult = Arrays.toString(blocks);
            Ipv4Resource.parse(ipv4Key).getPrefixLength();
            Ipv4Resource.parse(ipv4Key).toRangeString();


            System.out.println(Ipv4Resource.parse(ipv4Key).getPrefixLength() + "\n" +
                    Ipv4Resource.parse(ipv4Key).toRangeString());

        }
    }
    public void isinRange() {

    }
}
