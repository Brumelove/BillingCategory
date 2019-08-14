package net.telnet.afrinic.bee;

import cidr.BillingCategory;
import org.apache.commons.net.whois.WhoisClient;
import org.springframework.stereotype.Component;

@Component
public class MsBee {
    private static final String WHOIS_SERVER = "whois.afrinic.net";
    private static final int WHOIS_PORT = 43;
    private String queryString = "-T inetnum -T inet6num -T aut-num -i org -K ORG-AFNC1-AFRINIC";

    private Ipv4ResourcesCompute ipv4ResourcesCompute = new Ipv4ResourcesCompute();
    private Ipv6ResourcesCompute ipv6ResourcesCompute = new Ipv6ResourcesCompute();
    private ASNResourcesCompute asnResourcesCompute = new ASNResourcesCompute();


    public BillingCategory run() throws Exception {
        WhoisClient whoisClient = new WhoisClient();
        whoisClient.connect(WHOIS_SERVER, WHOIS_PORT);
        String whoisResponse = whoisClient.query(queryString);

        int v4Cidr = ipv4ResourcesCompute.compute(whoisResponse);
        int v6Cidr = ipv6ResourcesCompute.compute(whoisResponse);
        int nbAsn = asnResourcesCompute.compute(whoisResponse);

        BillingCategory billingCategory = computeBillingCategory(v4Cidr, v6Cidr, nbAsn);
        return billingCategory;
    }

    private BillingCategory computeBillingCategory(int v4Cidr, int v6Cidr, int nbAsn) {
        return null;
    }

}
