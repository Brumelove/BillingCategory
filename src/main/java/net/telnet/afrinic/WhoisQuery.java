package net.telnet.afrinic;

import org.apache.commons.net.whois.WhoisClient;

import java.io.IOException;


public class WhoisQuery {
    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    private String results;


    public static void main(String args[]) throws IOException {
        WhoisQuery whoisQuery = new WhoisQuery();
        whoisQuery.performWhoisQuery("-T inetnum -T inet6num -T aut-num -i org -K " +
                " ORG-AFNC1-AFRINIC");
        IPv4ResourceType iPv4ResourceType = new IPv4ResourceType();
        iPv4ResourceType.ipv4contains(whoisQuery.results);

    }


    private String performWhoisQuery(String nameToQuery) throws IOException {
        WhoisClient whoisClient = new WhoisClient();
        whoisClient.connect("whois.afrinic.net", 43);
        results = whoisClient.query(nameToQuery);
        setResults(results);
        //System.out.println(results);
        return results;


    }

}


