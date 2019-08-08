package stepdefs;

import cidr.BillingCategory;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import net.telnet.afrinic.Whois;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class StepDefinition {
    Whois whois = new Whois();
    BillingCategory billingCategory = new BillingCategory();
    private BillingCategory.IPv4AllocationSizeCategory ipv4BillingCategory;
    private BillingCategory.IPv4AllocationSizeCategory ipv4allocationSize;
    private String category;
    private String query;
    private String cidrSize;

    @Then("^All resources of ORG-HDL with Billing Category should be within range$")
    public void all_resources_should_be_within_range_for_with_category
            (DataTable dataTable) throws IOException {
        String arg1 = "ORG-HDL";
        String arg2 = "Billing Category";

        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {

            category = list.get(i).get(arg2);
            query = list.get(i).get(arg1);


            System.out.println(query);
            whois.performWhoisQuery("-T inetnum -T inet6num -T aut-num -i org -K " + query);
            cidrSize = whois.getFinalresult();
            // This line determines the billing category of all the (list.get(i).get(arg2)) values
            ipv4BillingCategory = billingCategory.determineBillingCategoryString(category);
            ipv4allocationSize = billingCategory.bc(cidrSize);


        }
        assertTrue(billingCategory.testAllocationSize(cidrSize, getIpv4BillingCategory()));
        assertEquals(ipv4allocationSize, ipv4BillingCategory);
        assertTrue(confirmed());


    }


    public BillingCategory.IPv4AllocationSizeCategory getIpv4BillingCategory() {
        return ipv4BillingCategory;
    }


    public boolean confirmed() {
        if (ipv4allocationSize.equals(ipv4BillingCategory)) {
            return true;
        }
        return false;
    }
}







