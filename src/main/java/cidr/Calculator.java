package cidr;

import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressSeqRange;
import inet.ipaddr.IPAddressString;

import java.util.Arrays;

public class Calculator {
    private String cidrsize;


    public String toPrefixBlocks(String str1, String str2) {

        IPAddressString string1 = new IPAddressString(str1);
        IPAddressString string2 = new IPAddressString(str2);
        IPAddress one = string1.getAddress(), two = string2.getAddress();

        IPAddressSeqRange range = one.toSequentialRange(two);
        //System.out.println("starting with range " + range);
        IPAddress blocks[] = range.spanWithPrefixBlocks();
        String fresult = Arrays.toString(blocks);
        IPAddressString result = new IPAddressString(fresult);
       // result.toNormalizedString().contains("/");
        if (result.toNormalizedString().contains("/") ) {
                int index = result.toNormalizedString().indexOf("/");
                String networkPart = result.toNormalizedString().substring(index + 1);
            if (networkPart.endsWith("]")) {
                String endwith = networkPart.replace("]", "");
                cidrsize = "/"+endwith;
               // System.out.println(cidrsize);
            }

            }
        else {
                throw new IllegalArgumentException("not an valid CIDR format!");
            }

        return cidrsize;
    }

    public static String performCalculation(String firstValue, String secondValue, String operator) {
        int firstValueTransformed = decodeValue(firstValue);
        int secondValueTransformed = decodeValue(secondValue);

        int result;
        if ("+".equals(operator.trim())) {
            result = firstValueTransformed + secondValueTransformed;
        } else if ("-".equals(operator.trim())) {
            result = firstValueTransformed - secondValueTransformed;
        } else if ("*".equals(operator.trim())) {
            result = firstValueTransformed * secondValueTransformed;
        } else if ("/".equals(operator.trim())) {
            result = firstValueTransformed / secondValueTransformed;
        } else if ("%".equals(operator.trim())) {
            result = firstValueTransformed % secondValueTransformed;
        } else {
            System.out.println("Invalid operator");
            return "";
        }

        int base2Power = returnBase2PowerOfValue(result);
        String powerShortHand = returnPowerShortHand(35 - base2Power);

        return powerShortHand;
    }

    private static int decodeValue(String value) {
        if (value.trim().startsWith("/")) {
            value = value.replace("/", "");
            int intValue = Integer.valueOf(value);
            int power = 35  - intValue;

            int evaluated = (int) Math.pow(2, power);

            return evaluated;
        } else {
            return Integer.valueOf(value);
        }
    }


    private static int returnBase2PowerOfValue(int value) {
        return (int) (Math.log(value) / Math.log(2));
    }


    private static String returnPowerShortHand(int value) {
        return "/" + value;
    }
}