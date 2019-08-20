package stepdefs;

import whois.afrinic.billingcategory.BillingCategory;
import whois.afrinic.query.WhoisQuery;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;


import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;


public class StepDefinition {
    WhoisQuery whoisQuery = new WhoisQuery();
    static BillingCategory billingCategory;
    private String category;
    private String query;
    private String queryString = "-T inetnum -T inet6num -T aut-num -i org -K ";

    @Then("^All resources of ORG-HDL with Billing Category should be within range$")
    public void all_resources_should_be_within_range_for_with_category
            (DataTable dataTable) throws Exception {
        String arg1 = "ORG-HDL";
        String arg2 = "Billing Category";

        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {

            category = list.get(i).get(arg2);
            query = list.get(i).get(arg1);

            billingCategory = whoisQuery.run(queryString + query);
        }

        assertTrue(confirmed());
    }


    public boolean confirmed() {
        if (billingCategory.getDescription().equals(category)) {
            return true;
        }
        return false;
    }


}







