package whois.afrinic.query;

import whois.afrinic.billingcategory.BillingCategory;
import net.afrinic.myafrinic.commons.model.resources.ResourceType;
import org.apache.commons.net.whois.WhoisClient;
import org.springframework.stereotype.Component;
import whois.afrinic.resource.ASNResourcesCompute;
import whois.afrinic.resource.Ipv4ResourcesCompute;
import whois.afrinic.resource.Ipv6ResourcesCompute;

@Component
public class WhoisQuery {
    private static final String WHOIS_SERVER = "whois.afrinic.net";
    private static final int WHOIS_PORT = 43;


    private String queryString = "-T inetnum -T inet6num -T aut-num -i org -K" +
            " ORG-DE1-AFRINIC";

    private Ipv4ResourcesCompute ipv4ResourcesCompute = new Ipv4ResourcesCompute();
    private Ipv6ResourcesCompute ipv6ResourcesCompute = new Ipv6ResourcesCompute();
    private ASNResourcesCompute asnResourcesCompute = new ASNResourcesCompute();


    public BillingCategory run(String query) throws Exception {
        WhoisClient whoisClient = new WhoisClient();
        whoisClient.connect(WHOIS_SERVER, WHOIS_PORT);
        String whoisResponse = whoisClient.query(query);

        Integer v4Cidr = ipv4ResourcesCompute.compute(whoisResponse);
        Integer v6Cidr = ipv6ResourcesCompute.compute(whoisResponse);
        Integer nbAsn = asnResourcesCompute.compute(whoisResponse);
        BillingCategory billingCategory = determineBC(v4Cidr, v6Cidr, nbAsn);


        return billingCategory;
    }

    public static BillingCategory determineBC(Integer v4Cidr, Integer v6Cidr, Integer nbAsn) {
        if (v4Cidr != null) {
            return BillingCategory.getBC(ResourceType.IPv4, v4Cidr);
        } else if (v6Cidr != null) {
            return BillingCategory.getBC(ResourceType.IPv6, v6Cidr);
        } else if (nbAsn != null) {
            return BillingCategory.getBC(ResourceType.ASN, nbAsn);
        } else {
            throw new IllegalArgumentException("No suitable value to compute the billing category");
        }

    }



    public static void main(String args[]) throws Exception {
        WhoisQuery whoisQuery = new WhoisQuery();
        System.out.println(whoisQuery.run(whoisQuery.queryString));


    }


}
