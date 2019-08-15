package net.telnet.afrinic.bee;

import cidr.BillingCategory;
import org.apache.commons.net.whois.WhoisClient;
import org.springframework.stereotype.Component;

@Component
public class WhoisQuery {
    private static final String WHOIS_SERVER = "whois.afrinic.net";
    private static final int WHOIS_PORT = 43;

    public int getFinalcidr() {
        return finalcidr;
    }

    public void setFinalcidr(int finalcidr) {
        this.finalcidr = finalcidr;
    }

    private int finalcidr;



    private String queryString = "-T inetnum -T inet6num -T aut-num -i org -K ORG-EISL2-AFRINIC";

    private Ipv4ResourcesCompute ipv4ResourcesCompute = new Ipv4ResourcesCompute();
    private Ipv6ResourcesCompute ipv6ResourcesCompute = new Ipv6ResourcesCompute();
    private ASNResourcesCompute asnResourcesCompute = new ASNResourcesCompute();


    public int run( String query) throws Exception {
        WhoisClient whoisClient = new WhoisClient();
        whoisClient.connect(WHOIS_SERVER, WHOIS_PORT);
        String whoisResponse = whoisClient.query(query);

        int v4Cidr = ipv4ResourcesCompute.compute(whoisResponse);
        int v6Cidr = ipv6ResourcesCompute.compute(whoisResponse);
        int nbAsn = asnResourcesCompute.compute(whoisResponse);

        finalcidr = computeBillingCategory(v4Cidr, v6Cidr, nbAsn);

        return finalcidr;
    }

    private int computeBillingCategory(int v4Cidr, int v6Cidr, int nbAsn) {
        if (v4Cidr != 0 && v6Cidr != 0)
            return v4Cidr;

        else if (v4Cidr == 0 && v6Cidr != 0)
            return v6Cidr;

        else return nbAsn;

    }

    public static void main(String args[]) throws Exception {
        WhoisQuery whoisQuery = new WhoisQuery();
        whoisQuery.run(whoisQuery.queryString);
        BillingCategory billingCategory = new BillingCategory();
        billingCategory.bc(whoisQuery.getFinalcidr());



    }


}
