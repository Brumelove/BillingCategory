package net.telnet.afrinic;

import cidr.BillingCategory;
import cidr.Calculator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.whois.WhoisClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Whois {


    private String part1;
    private String part2;
    private static String inetnum = "inetnum";
    private static String inet6num = "inet6num";
    private static String autnum = "aut-num";
    private int inetnumcount;
    private int inet6numcount;
    private int autnumcount;

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    private String results;

    public String getFinalresult() {
        return finalresult;
    }

    public void setFinalresult(String finalresult) {
        this.finalresult = finalresult;
    }

    private String finalresult;
    Calculator calculator = new Calculator();


//    public static void main(String[] args) throws Exception {
//        Whois whois = new Whois();
//        whois.performWhoisQuery("-T inetnum -T inet6num -T aut-num -i org -K" +
//                " ORG-AFNC1-AFRINIC");
////                " ORG-Eool1-AFRINIC");
//
//
//    }

    public List<WhoisObject> performWhoisQuery(String nameToQuery) throws IOException {
        List<WhoisObject> whoisObjects = new ArrayList();
        List<List<String>> whoisObjectList = new ArrayList<>();
        Scanner scanner = new Scanner(performWhoisQuery(nameToQuery, "whois.afrinic.net", 43));
        while (scanner.hasNextLine()) {
            List<String> lineTokenList = new ArrayList<>();
            WhoisObject wo = new WhoisObject();
            Scanner lineScanner = new Scanner(scanner.nextLine());

 lineScanner.useDelimiter(":");
            while (lineScanner.hasNext()) {
                String token = lineScanner.next();
                if (!token.startsWith("%")) {
                    lineTokenList.add(token.trim());
                }
            }
            lineScanner.close();
            if (lineTokenList.size() == 0) {
                whoisObjects.add(convert(whoisObjectList));
            } else if (lineTokenList.size() == 2) {
                whoisObjectList.add(lineTokenList);
                wo.add(lineTokenList.get(0), lineTokenList.get(1));
            }

        }


        String listString = whoisObjectList.stream().map(Object::toString).collect(Collectors.joining(","));


        setInetnumcount(StringUtils.countMatches(listString, inetnum));
        setInet6numcount(StringUtils.countMatches(listString, inet6num));
        setAutnumcount(StringUtils.countMatches(listString, autnum));

        System.out.println("inetnum: " + getInetnumcount() + " " +
                "inet6num: " + getInet6numcount() + " " +
                "autnum: " + getAutnumcount());

        HashMap<String, List<String>> keyval = new HashMap<>();

        for (int i = 0; i < whoisObjectList.size(); i++) {
            if (keyval.containsKey(whoisObjectList.get(i).get(0)) == false) {
                List<String> list = new ArrayList<>();
                keyval.put(whoisObjectList.get(i).get(0), list);
            }
            List<String> newlist = keyval.get(whoisObjectList.get(i).get(0));
            newlist.add(whoisObjectList.get(i).get(1));
        }
        List<String> inetList = keyval.get(inetnum);
        List<String> prefixBlockList = new ArrayList<>();
        for (String value : inetList) {
            String split[] = value.split("-", 2);
            part1 = split[0];
            part2 = split[1];
            prefixBlockList.add(calculator.toPrefixBlocks(part1, part2));

        }


        if (prefixBlockList.size() == 1) {
            finalresult = prefixBlockList.get(0);
        } else if (prefixBlockList.size() > 1) {
            finalresult = prefixBlockList.get(0);
            for (int i = 1; i < prefixBlockList.size(); i++) {
                finalresult = Calculator.performCalculation(finalresult, prefixBlockList.get(i), "+");
            }
        }
        BillingCategory billingCategory = new BillingCategory();


        System.out.println("CIDRSize: " + finalresult + " --> " + billingCategory.bc(finalresult) + "\n" +
                billingCategory.testAllocationSize(finalresult,
                        billingCategory.determineBillingCategoryString(finalresult))
                + billingCategory.determineBillingCategoryString(finalresult));


        scanner.close();
        return whoisObjects;
    }

    private WhoisObject convert(List<List<String>> whoisObjectList) {
        WhoisObject whoisObject = new WhoisObject();

        //System.out.println(whoisObjectList);
        for (List<String> attribute : whoisObjectList) {
            if (attribute.size() > 1) {

                String attributeName = attribute.get(0);
                String attributeValue = attribute.get(1);

                for (WhoisObject.Key key : WhoisObject.Key.values()) {
                    if (key.getKeyAttribute().equalsIgnoreCase(attributeName)) {
                        whoisObject.setKey(key);
                    }
                }
                whoisObject.add(attributeName, attributeValue);

            }
        }
        return whoisObject;

    }


    private String performWhoisQuery(String nameToQuery, String WHOIS_SERVER, int WHOIS_PORT) throws IOException {
        WhoisClient whoisClient = new WhoisClient();
        whoisClient.connect(WHOIS_SERVER, WHOIS_PORT);
        results = whoisClient.query(nameToQuery);
        System.out.println(results);
        return results;


    }


    public int getInetnumcount() {
        return inetnumcount;
    }

    public void setInetnumcount(int inetnumcount) {
        this.inetnumcount = inetnumcount;
    }

    public int getInet6numcount() {
        return inet6numcount;
    }

    public void setInet6numcount(int inet6numcount) {
        this.inet6numcount = inet6numcount;
    }

    public int getAutnumcount() {
        return autnumcount;
    }

    public void setAutnumcount(int autnumcount) {
        this.autnumcount = autnumcount;
    }
}
