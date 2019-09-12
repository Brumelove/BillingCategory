//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.junit.Assert;
import org.junit.Test;
import whois.afrinic.billingcategory.BillingCategory;
import whois.afrinic.resource.ASNResourcesCompute;
import whois.afrinic.resource.Ipv4ResourcesCompute;
import whois.afrinic.resource.Ipv6ResourcesCompute;

import static whois.afrinic.query.WhoisQuery.determineBC;

public class WhoisQueryTest {

    private Ipv4ResourcesCompute ipv4ResourcesCompute = new Ipv4ResourcesCompute();
    private Ipv6ResourcesCompute ipv6ResourcesCompute = new Ipv6ResourcesCompute();
    private ASNResourcesCompute asnResourcesCompute = new ASNResourcesCompute();

    public BillingCategory response(String whoisResponse) {

        Integer v4Cidr = ipv4ResourcesCompute.compute(whoisResponse);
        Integer v6Cidr = ipv6ResourcesCompute.compute(whoisResponse);
        Integer nbAsn = asnResourcesCompute.compute(whoisResponse);
        BillingCategory billingCategory = determineBC(v4Cidr, v6Cidr, nbAsn);

        return billingCategory;
    }


    @Test
    public void eisl2() {
        Assert.assertEquals(BillingCategory.LIR_EXTRA_SMALL, response("inetnum:       169.239.188.0 - 169.239.191.255"));
    }

    @Test
    public void is33() {
        Assert.assertEquals(BillingCategory.LIR_EXTRA_SMALL, response("inetnum:        41.223.236.0 - 41.223.239.255"));
    }

    @Test
    public void uocl1() {
        Assert.assertEquals(BillingCategory.LIR_EXTRA_SMALL, response("inetnum:        41.57.116.0 - 41.57.119.255\n\n% No abuse contact registered for AS37507\n\naut-num:        AS37507"));
    }

    @Test
    public void gdid1() {
        Assert.assertEquals(BillingCategory.LIR_VERY_SMALL, response("inetnum:        197.214.64.0 - 197.214.79.255\n\n% No abuse contact registered for 2c0f:f8c0::/32\n\ninet6num:       2c0f:f8c0::/32\n\n% No abuse contact registered for AS37529\n\naut-num:        AS37529"));
    }

    @Test
    public void sctl1() {
        Assert.assertEquals(BillingCategory.LIR_VERY_SMALL, response("inetnum:        41.222.144.0 - 41.222.151.255\n\n% No abuse contact registered for 80.248.0.0 - 80.248.15.255\n\ninetnum:        80.248.0.0 - 80.248.15.255\n\n% No abuse contact registered for 2c0f:eec0::/32\n\ninet6num:       2c0f:eec0::/32\n\n% No abuse contact registered for AS25163\n\naut-num:        AS25163"));
    }

    @Test
    public void aol2() {
        Assert.assertEquals(BillingCategory.LIR_VERY_SMALL, response("% No abuse contact registered for 196.45.184.0 - 196.45.187.255\n\ninetnum:        196.45.184.0 - 196.45.187.255\n\n% No abuse contact registered for 196.46.128.0 - 196.46.135.255\n\ninetnum:        196.46.128.0 - 196.46.135.255\n\n% No abuse contact registered for 41.220.176.0 - 41.220.191.255\n\ninetnum:        41.220.176.0 - 41.220.191.255\n\n% No abuse contact registered for 2c0f:fd30::/32\n\ninet6num:       2c0f:fd30::/32\n\n% No abuse contact registered for AS31810\n\naut-num:        AS31810"));
    }

    @Test
    public void ecn1() {
        Assert.assertEquals(BillingCategory.LIR_SMALL, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 154.119.160.0 - 154.119.191.255\n\ninetnum:        154.119.160.0 - 154.119.191.255\n\n% No abuse contact registered for 41.203.32.0 - 41.203.63.255\n\ninetnum:        41.203.32.0 - 41.203.63.255\n\n% No abuse contact registered for 41.221.0.0 - 41.221.15.255\n\ninetnum:        41.221.0.0 - 41.221.15.255\n\n% No abuse contact registered for 41.223.36.0 - 41.223.39.255\n\ninetnum:        41.223.36.0 - 41.223.39.255\n\n% No abuse contact registered for 41.75.128.0 - 41.75.143.255\n\ninetnum:        41.75.128.0 - 41.75.143.255\n\n% No abuse contact registered for 2001:4330::/32\n\ninet6num:       2001:4330::/32\n\n% No abuse contact registered for 2c0f:ffd0::/32\n\ninet6num:       2c0f:ffd0::/32\n\n% No abuse contact registered for AS36910\n\naut-num:        AS36910\n\n% No abuse contact registered for AS36968\n\naut-num:        AS36968\n\n\n\n"));
    }

    @Test
    public void ailc1() {
        Assert.assertEquals(BillingCategory.LIR_SMALL, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 196.223.64.0 - 196.223.95.255\n\ninetnum:        196.223.64.0 - 196.223.95.255\n\n% No abuse contact registered for 196.44.32.0 - 196.44.47.255\n\ninetnum:        196.44.32.0 - 196.44.47.255\n\n% No abuse contact registered for 197.255.144.0 - 197.255.159.255\n\ninetnum:        197.255.144.0 - 197.255.159.255\n\n% No abuse contact registered for 2001:43d8::/32\n\ninet6num:       2001:43d8::/32\n\n% No abuse contact registered for AS15022\n\naut-num:        AS15022\n\n% No abuse contact registered for AS327703\n\naut-num:        AS327703\n\n\n\n"));
    }

    @Test
    public void aa21() {
        Assert.assertEquals(BillingCategory.LIR_SMALL, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 41.218.128.0 - 41.218.191.255\n\ninetnum:        41.218.128.0 - 41.218.191.255\n\n% No abuse contact registered for 62.117.32.0 - 62.117.63.255\n\ninetnum:        62.117.32.0 - 62.117.63.255\n\n% No abuse contact registered for AS24987\n\naut-num:        AS24987\n\n% No abuse contact registered for AS25576\n\naut-num:        AS25576\n\n\n\n"));
    }

    @Test
    public void vm1() {
        Assert.assertEquals(BillingCategory.LIR_MEDIUM, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 197.235.0.0 - 197.235.255.255\n\ninetnum:        197.235.0.0 - 197.235.255.255\n\n% No abuse contact registered for 41.76.144.0 - 41.76.151.255\n\ninetnum:        41.76.144.0 - 41.76.151.255\n\n% No abuse contact registered for 2c0f:f308::/32\n\ninet6num:       2c0f:f308::/32\n\n% No abuse contact registered for AS37223\n\naut-num:        AS37223\n\n\n\n"));
    }

    @Test
    public void au2() {
        Assert.assertEquals(BillingCategory.LIR_MEDIUM, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 154.73.12.0 - 154.73.15.255\n\ninetnum:        154.73.12.0 - 154.73.15.255\n\n% No abuse contact registered for 155.255.0.0 - 155.255.255.255\n\ninetnum:        155.255.0.0 - 155.255.255.255\n\n% No abuse contact registered for AS327744\n\naut-num:        AS327744\n\n\n\n"));
    }

    @Test
    public void ckl1() {
        Assert.assertEquals(BillingCategory.LIR_LARGE, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 105.230.0.0 - 105.231.255.255\n\ninetnum:        105.230.0.0 - 105.231.255.255\n\n% No abuse contact registered for 154.152.0.0 - 154.159.255.255\n\ninetnum:        154.152.0.0 - 154.159.255.255\n\n% No abuse contact registered for 154.76.0.0 - 154.79.255.255\n\ninetnum:        154.76.0.0 - 154.79.255.255\n\n% No abuse contact registered for 41.223.56.0 - 41.223.59.255\n\ninetnum:        41.223.56.0 - 41.223.59.255\n\n% No abuse contact registered for AS36926\n\naut-num:        AS36926\n\n\n\n"));
    }

    @Test
    public void ta39() {
        Assert.assertEquals(BillingCategory.LIR_EXTRA_SMALL, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 169.255.24.0 - 169.255.27.255\n\ninetnum:        169.255.24.0 - 169.255.27.255\n\n% No abuse contact registered for AS327786\n\naut-num:        AS327786\n\n\n\n"));
    }

    @Test
    public void aptc1() {
        Assert.assertEquals(BillingCategory.LIR_EXTRA_SMALL, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 154.73.4.0 - 154.73.7.255\n\ninetnum:        154.73.4.0 - 154.73.7.255\n\n% No abuse contact registered for 196.6.104.0 - 196.6.111.255\n\ninetnum:        196.6.104.0 - 196.6.111.255\n\n% No abuse contact registered for AS327761\n\naut-num:        AS327761\n\n\n\n"));
    }

    @Test
    public void al8() {
        Assert.assertEquals(BillingCategory.LIR_EXTRA_SMALL, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 154.118.232.0 - 154.118.239.255\n\ninetnum:        154.118.232.0 - 154.118.239.255\n\n% No abuse contact registered for 2c0f:f580::/32\n\ninet6num:       2c0f:f580::/32\n\n% No abuse contact registered for AS327970\n\naut-num:        AS327970\n\n\n\n"));
    }

    @Test
    public void am2() {
        Assert.assertEquals(BillingCategory.LIR_SMALL, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 197.148.128.0 - 197.148.191.255\n\ninetnum:        197.148.128.0 - 197.148.191.255\n\n% No abuse contact registered for 41.77.16.0 - 41.77.23.255\n\ninetnum:        41.77.16.0 - 41.77.23.255\n\n% No abuse contact registered for AS327699\n\naut-num:        AS327699\n\n% No abuse contact registered for AS37303\n\naut-num:        AS37303\n\n\n\n"));
    }

    @Test
    public void vnl1() {
        Assert.assertEquals(BillingCategory.LIR_VERY_LARGE, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 105.112.0.0 - 105.127.255.255\n\ninetnum:        105.112.0.0 - 105.127.255.255\n\n% No abuse contact registered for 196.46.240.0 - 196.46.247.255\n\ninetnum:        196.46.240.0 - 196.46.247.255\n\n% No abuse contact registered for AS36873\n\naut-num:        AS36873\n\n\n\n"));
    }

    @Test
    public void adn1() {
        Assert.assertEquals(BillingCategory.LIR_VERY_SMALL, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 197.159.112.0 - 197.159.127.255\n\ninetnum:        197.159.112.0 - 197.159.127.255\n\n% No abuse contact registered for AS37423\n\naut-num:        AS37423\n\n\n\n"));
    }

    @Test
    public void cil1() {
        Assert.assertEquals(BillingCategory.LIR_EXTRA_LARGE, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 154.192.0.0 - 154.223.255.255\n\ninetnum:        154.192.0.0 - 154.223.255.255\n\n% No abuse contact registered for 154.80.0.0 - 154.95.255.255\n\ninetnum:        154.80.0.0 - 154.95.255.255\n\n% No abuse contact registered for 156.224.0.0 - 156.255.255.255\n\ninetnum:        156.224.0.0 - 156.255.255.255\n\n% No abuse contact registered for 45.192.0.0 - 45.207.255.255\n\ninetnum:        45.192.0.0 - 45.207.255.255\n\n\n\n"));
    }

    @Test
    public void ea20() {
        Assert.assertEquals(BillingCategory.LIR_LARGE, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 102.160.0.0 - 102.163.255.255\n\ninetnum:        102.160.0.0 - 102.163.255.255\n\n% No abuse contact registered for 105.235.144.0 - 105.235.159.255\n\ninetnum:        105.235.144.0 - 105.235.159.255\n\n% No abuse contact registered for 154.71.0.0 - 154.71.31.255\n\ninetnum:        154.71.0.0 - 154.71.31.255\n\n% No abuse contact registered for 196.192.80.0 - 196.192.83.255\n\ninetnum:        196.192.80.0 - 196.192.83.255\n\n% No abuse contact registered for 41.76.40.0 - 41.76.47.255\n\ninetnum:        41.76.40.0 - 41.76.47.255\n\n% No abuse contact registered for 2001:4248::/32\n\ninet6num:       2001:4248::/32\n\n% No abuse contact registered for AS30999\n\naut-num:        AS30999\n\n\n\n"));
    }

    @Test
    public void em1() {
        Assert.assertEquals(BillingCategory.LIR_EXTRA_LARGE, response("% This is the AfriNIC Whois server.\n\n% Note: this output has been filtered.\n% Only primary keys and abuse contacts will be visible.\n% No other contact information will be shown.\n\n% No abuse contact registered for 102.56.0.0 - 102.63.255.255\n\ninetnum:        102.56.0.0 - 102.63.255.255\n\n% No abuse contact registered for 105.200.0.0 - 105.200.127.255\n\ninetnum:        105.200.0.0 - 105.200.127.255\n\n% No abuse contact registered for 105.200.0.0 - 105.207.255.255\n\ninetnum:        105.200.0.0 - 105.207.255.255\n\n% No abuse contact registered for 105.200.128.0 - 105.200.255.255\n\ninetnum:        105.200.128.0 - 105.200.255.255\n\n% No abuse contact registered for 105.205.0.0 - 105.205.127.255\n\ninetnum:        105.205.0.0 - 105.205.127.255\n\n% No abuse contact registered for 105.205.128.0 - 105.205.255.255\n\ninetnum:        105.205.128.0 - 105.205.255.255\n\n% No abuse contact registered for 105.206.128.0 - 105.206.255.255\n\ninetnum:        105.206.128.0 - 105.206.255.255\n\n% No abuse contact registered for 105.207.0.0 - 105.207.127.255\n\ninetnum:        105.207.0.0 - 105.207.127.255\n\n% No abuse contact registered for 105.80.0.0 - 105.95.255.255\n\ninetnum:        105.80.0.0 - 105.95.255.255\n\n% No abuse contact registered for 105.92.0.0 - 105.92.63.255\n\ninetnum:        105.92.0.0 - 105.92.63.255\n\n% No abuse contact registered for 105.92.128.0 - 105.92.191.255\n\ninetnum:        105.92.128.0 - 105.92.191.255\n\n% No abuse contact registered for 105.92.192.0 - 105.92.255.255\n\ninetnum:        105.92.192.0 - 105.92.255.255\n\n% No abuse contact registered for 105.92.64.0 - 105.92.127.255\n\ninetnum:        105.92.64.0 - 105.92.127.255\n\n% No abuse contact registered for 156.160.0.0 - 156.160.63.255\n\ninetnum:        156.160.0.0 - 156.160.63.255\n\n% No abuse contact registered for 156.160.0.0 - 156.191.255.255\n\ninetnum:        156.160.0.0 - 156.191.255.255\n\n% No abuse contact registered for 156.160.128.0 - 156.160.191.255\n\ninetnum:        156.160.128.0 - 156.160.191.255\n\n% No abuse contact registered for 156.160.192.0 - 156.160.255.255\n\ninetnum:        156.160.192.0 - 156.160.255.255\n\n% No abuse contact registered for 156.160.64.0 - 156.160.127.255\n\ninetnum:        156.160.64.0 - 156.160.127.255\n\n% No abuse contact registered for 156.161.0.0 - 156.161.63.255\n\ninetnum:        156.161.0.0 - 156.161.63.255\n\n% No abuse contact registered for 156.161.128.0 - 156.161.191.255\n\ninetnum:        156.161.128.0 - 156.161.191.255\n\n% No abuse contact registered for 156.161.192.0 - 156.161.255.255\n\ninetnum:        156.161.192.0 - 156.161.255.255\n\n% No abuse contact registered for 156.161.64.0 - 156.161.127.255\n\ninetnum:        156.161.64.0 - 156.161.127.255\n\n% No abuse contact registered for 156.162.0.0 - 156.162.63.255\n\ninetnum:        156.162.0.0 - 156.162.63.255\n\n% No abuse contact registered for 156.162.128.0 - 156.162.191.255\n\ninetnum:        156.162.128.0 - 156.162.191.255\n\n% No abuse contact registered for 156.162.192.0 - 156.162.255.255\n\ninetnum:        156.162.192.0 - 156.162.255.255\n\n% No abuse contact registered for 156.162.64.0 - 156.162.127.255\n\ninetnum:        156.162.64.0 - 156.162.127.255\n\n% No abuse contact registered for 156.163.0.0 - 156.163.63.255\n\ninetnum:        156.163.0.0 - 156.163.63.255\n\n% No abuse contact registered for 156.163.128.0 - 156.163.191.255\n\ninetnum:        156.163.128.0 - 156.163.191.255\n\n% No abuse contact registered for 156.163.192.0 - 156.163.255.255\n\ninetnum:        156.163.192.0 - 156.163.255.255\n\n% No abuse contact registered for 156.163.64.0 - 156.163.127.255\n\ninetnum:        156.163.64.0 - 156.163.127.255\n\n% No abuse contact registered for 156.168.0.0 - 156.168.63.255\n\ninetnum:        156.168.0.0 - 156.168.63.255\n\n% No abuse contact registered for 156.168.128.0 - 156.168.191.255\n\ninetnum:        156.168.128.0 - 156.168.191.255\n\n% No abuse contact registered for 156.168.192.0 - 156.168.255.255\n\ninetnum:        156.168.192.0 - 156.168.255.255\n\n% No abuse contact registered for 156.168.64.0 - 156.168.127.255\n\ninetnum:        156.168.64.0 - 156.168.127.255\n\n% No abuse contact registered for 156.169.0.0 - 156.169.63.255\n\ninetnum:        156.169.0.0 - 156.169.63.255\n\n% No abuse contact registered for 156.169.128.0 - 156.169.191.255\n\ninetnum:        156.169.128.0 - 156.169.191.255\n\n% No abuse contact registered for 156.169.192.0 - 156.169.255.255\n\ninetnum:        156.169.192.0 - 156.169.255.255\n\n% No abuse contact registered for 156.169.64.0 - 156.169.127.255\n\ninetnum:        156.169.64.0 - 156.169.127.255\n\n% No abuse contact registered for 156.170.0.0 - 156.170.63.255\n\ninetnum:        156.170.0.0 - 156.170.63.255\n\n% No abuse contact registered for 156.170.128.0 - 156.170.191.255\n\ninetnum:        156.170.128.0 - 156.170.191.255\n\n% No abuse contact registered for 156.170.192.0 - 156.170.255.255\n\ninetnum:        156.170.192.0 - 156.170.255.255\n\n% No abuse contact registered for 156.170.64.0 - 156.170.127.255\n\ninetnum:        156.170.64.0 - 156.170.127.255\n\n% No abuse contact registered for 156.171.0.0 - 156.171.63.255\n\ninetnum:        156.171.0.0 - 156.171.63.255\n\n% No abuse contact registered for 156.171.128.0 - 156.171.191.255\n\ninetnum:        156.171.128.0 - 156.171.191.255\n\n% No abuse contact registered for 156.171.192.0 - 156.171.255.255\n\ninetnum:        156.171.192.0 - 156.171.255.255\n\n% No abuse contact registered for 156.171.64.0 - 156.171.127.255\n\ninetnum:        156.171.64.0 - 156.171.127.255\n\n% No abuse contact registered for 197.120.0.0 - 197.120.31.255\n\ninetnum:        197.120.0.0 - 197.120.31.255\n\n% No abuse contact registered for 197.120.0.0 - 197.127.255.255\n\ninetnum:        197.120.0.0 - 197.127.255.255\n\n% No abuse contact registered for 197.120.128.0 - 197.120.159.255\n\ninetnum:        197.120.128.0 - 197.120.159.255\n\n% No abuse contact registered for 197.120.160.0 - 197.120.191.255\n\ninetnum:        197.120.160.0 - 197.120.191.255\n\n% No abuse contact registered for 197.120.192.0 - 197.120.223.255\n\ninetnum:        197.120.192.0 - 197.120.223.255\n\n% No abuse contact registered for 197.120.224.0 - 197.120.255.255\n\ninetnum:        197.120.224.0 - 197.120.255.255\n\n% No abuse contact registered for 197.120.32.0 - 197.120.63.255\n\ninetnum:        197.120.32.0 - 197.120.63.255\n\n% No abuse contact registered for 197.120.64.0 - 197.120.95.255\n\ninetnum:        197.120.64.0 - 197.120.95.255\n\n% No abuse contact registered for 197.120.96.0 - 197.120.127.255\n\ninetnum:        197.120.96.0 - 197.120.127.255\n\n% No abuse contact registered for 197.121.0.0 - 197.121.31.255\n\ninetnum:        197.121.0.0 - 197.121.31.255\n\n% No abuse contact registered for 197.121.128.0 - 197.121.159.255\n\ninetnum:        197.121.128.0 - 197.121.159.255\n\n% No abuse contact registered for 197.121.160.0 - 197.121.191.255\n\ninetnum:        197.121.160.0 - 197.121.191.255\n\n% No abuse contact registered for 197.121.192.0 - 197.121.223.255\n\ninetnum:        197.121.192.0 - 197.121.223.255\n\n% No abuse contact registered for 197.121.224.0 - 197.121.255.255\n\ninetnum:        197.121.224.0 - 197.121.255.255\n\n% No abuse contact registered for 197.121.32.0 - 197.121.63.255\n\ninetnum:        197.121.32.0 - 197.121.63.255\n\n% No abuse contact registered for 197.121.64.0 - 197.121.95.255\n\ninetnum:        197.121.64.0 - 197.121.95.255\n\n% No abuse contact registered for 197.121.96.0 - 197.121.127.255\n\ninetnum:        197.121.96.0 - 197.121.127.255\n\n% No abuse contact registered for 197.122.0.0 - 197.122.31.255\n\ninetnum:        197.122.0.0 - 197.122.31.255\n\n% No abuse contact registered for 197.122.128.0 - 197.122.159.255\n\ninetnum:        197.122.128.0 - 197.122.159.255\n\n% No abuse contact registered for 197.122.160.0 - 197.122.191.255\n\ninetnum:        197.122.160.0 - 197.122.191.255\n\n% No abuse contact registered for 197.122.192.0 - 197.122.223.255\n\ninetnum:        197.122.192.0 - 197.122.223.255\n\n% No abuse contact registered for 197.122.224.0 - 197.122.255.255\n\ninetnum:        197.122.224.0 - 197.122.255.255\n\n% No abuse contact registered for 197.122.32.0 - 197.122.63.255\n\ninetnum:        197.122.32.0 - 197.122.63.255\n\n% No abuse contact registered for 197.122.64.0 - 197.122.95.255\n\ninetnum:        197.122.64.0 - 197.122.95.255\n\n% No abuse contact registered for 197.122.96.0 - 197.122.127.255\n\ninetnum:        197.122.96.0 - 197.122.127.255\n\n% No abuse contact registered for 197.123.0.0 - 197.123.31.255\n\ninetnum:        197.123.0.0 - 197.123.31.255\n\n% No abuse contact registered for 197.123.128.0 - 197.123.159.255\n\ninetnum:        197.123.128.0 - 197.123.159.255\n\n% No abuse contact registered for 197.123.160.0 - 197.123.191.255\n\ninetnum:        197.123.160.0 - 197.123.191.255\n\n% No abuse contact registered for 197.123.192.0 - 197.123.223.255\n\ninetnum:        197.123.192.0 - 197.123.223.255\n\n% No abuse contact registered for 197.123.224.0 - 197.123.255.255\n\ninetnum:        197.123.224.0 - 197.123.255.255\n\n% No abuse contact registered for 197.123.32.0 - 197.123.63.255\n\ninetnum:        197.123.32.0 - 197.123.63.255\n\n% No abuse contact registered for 197.123.64.0 - 197.123.95.255\n\ninetnum:        197.123.64.0 - 197.123.95.255\n\n% No abuse contact registered for 197.123.96.0 - 197.123.127.255\n\ninetnum:        197.123.96.0 - 197.123.127.255\n\n% No abuse contact registered for 197.124.0.0 - 197.124.31.255\n\ninetnum:        197.124.0.0 - 197.124.31.255\n\n% No abuse contact registered for 197.124.128.0 - 197.124.159.255\n\ninetnum:        197.124.128.0 - 197.124.159.255\n\n% No abuse contact registered for 197.124.160.0 - 197.124.191.255\n\ninetnum:        197.124.160.0 - 197.124.191.255\n\n% No abuse contact registered for 197.124.192.0 - 197.124.223.255\n\ninetnum:        197.124.192.0 - 197.124.223.255\n\n% No abuse contact registered for 197.124.224.0 - 197.124.255.255\n\ninetnum:        197.124.224.0 - 197.124.255.255\n\n% No abuse contact registered for 197.124.32.0 - 197.124.63.255\n\ninetnum:        197.124.32.0 - 197.124.63.255\n\n% No abuse contact registered for 197.124.64.0 - 197.124.95.255\n\ninetnum:        197.124.64.0 - 197.124.95.255\n\n% No abuse contact registered for 197.124.96.0 - 197.124.127.255\n\ninetnum:        197.124.96.0 - 197.124.127.255\n\n% No abuse contact registered for 197.125.0.0 - 197.125.31.255\n\ninetnum:        197.125.0.0 - 197.125.31.255\n\n% No abuse contact registered for 197.125.128.0 - 197.125.159.255\n\ninetnum:        197.125.128.0 - 197.125.159.255\n\n% No abuse contact registered for 197.125.160.0 - 197.125.191.255\n\ninetnum:        197.125.160.0 - 197.125.191.255\n\n% No abuse contact registered for 197.125.192.0 - 197.125.223.255\n\ninetnum:        197.125.192.0 - 197.125.223.255\n\n% No abuse contact registered for 197.125.224.0 - 197.125.255.255\n\ninetnum:        197.125.224.0 - 197.125.255.255\n\n% No abuse contact registered for 197.125.32.0 - 197.125.63.255\n\ninetnum:        197.125.32.0 - 197.125.63.255\n\n% No abuse contact registered for 197.125.64.0 - 197.125.95.255\n\ninetnum:        197.125.64.0 - 197.125.95.255\n\n% No abuse contact registered for 197.125.96.0 - 197.125.127.255\n\ninetnum:        197.125.96.0 - 197.125.127.255\n\n% No abuse contact registered for 197.126.0.0 - 197.126.31.255\n\ninetnum:        197.126.0.0 - 197.126.31.255\n\n% No abuse contact registered for 197.126.128.0 - 197.126.159.255\n\ninetnum:        197.126.128.0 - 197.126.159.255\n\n% No abuse contact registered for 197.126.160.0 - 197.126.191.255\n\ninetnum:        197.126.160.0 - 197.126.191.255\n\n% No abuse contact registered for 197.126.192.0 - 197.126.223.255\n\ninetnum:        197.126.192.0 - 197.126.223.255\n\n% No abuse contact registered for 197.126.224.0 - 197.126.255.255\n\ninetnum:        197.126.224.0 - 197.126.255.255\n\n% No abuse contact registered for 197.126.32.0 - 197.126.63.255\n\ninetnum:        197.126.32.0 - 197.126.63.255\n\n% No abuse contact registered for 197.126.64.0 - 197.126.95.255\n\ninetnum:        197.126.64.0 - 197.126.95.255\n\n% No abuse contact registered for 197.126.96.0 - 197.126.127.255\n\ninetnum:        197.126.96.0 - 197.126.127.255\n\n% No abuse contact registered for 197.127.0.0 - 197.127.31.255\n\ninetnum:        197.127.0.0 - 197.127.31.255\n\n% No abuse contact registered for 197.127.128.0 - 197.127.159.255\n\ninetnum:        197.127.128.0 - 197.127.159.255\n\n% No abuse contact registered for 197.127.160.0 - 197.127.191.255\n\ninetnum:        197.127.160.0 - 197.127.191.255\n\n% No abuse contact registered for 197.127.32.0 - 197.127.63.255\n\ninetnum:        197.127.32.0 - 197.127.63.255\n\n% No abuse contact registered for 197.127.64.0 - 197.127.95.255\n\ninetnum:        197.127.64.0 - 197.127.95.255\n\n% No abuse contact registered for 197.127.96.0 - 197.127.127.255\n\ninetnum:        197.127.96.0 - 197.127.127.255\n\n% No abuse contact registered for 197.192.0.0 - 197.192.127.255\n\ninetnum:        197.192.0.0 - 197.192.127.255\n\n% No abuse contact registered for 197.192.0.0 - 197.199.255.255\n\ninetnum:        197.192.0.0 - 197.199.255.255\n\n% No abuse contact registered for 197.192.128.0 - 197.192.255.255\n\ninetnum:        197.192.128.0 - 197.192.255.255\n\n% No abuse contact registered for 197.193.0.0 - 197.193.127.255\n\ninetnum:        197.193.0.0 - 197.193.127.255\n\n% No abuse contact registered for 197.193.128.0 - 197.193.255.255\n\ninetnum:        197.193.128.0 - 197.193.255.255\n\n% No abuse contact registered for 197.196.0.0 - 197.196.127.255\n\ninetnum:        197.196.0.0 - 197.196.127.255\n\n% No abuse contact registered for 197.196.128.0 - 197.196.255.255\n\ninetnum:        197.196.128.0 - 197.196.255.255\n\n% No abuse contact registered for 197.197.0.0 - 197.197.127.255\n\ninetnum:        197.197.0.0 - 197.197.127.255\n\n% No abuse contact registered for 197.197.128.0 - 197.197.255.255\n\ninetnum:        197.197.128.0 - 197.197.255.255\n\n% No abuse contact registered for 197.198.0.0 - 197.198.127.255\n\ninetnum:        197.198.0.0 - 197.198.127.255\n\n% No abuse contact registered for 197.198.128.0 - 197.198.255.255\n\ninetnum:        197.198.128.0 - 197.198.255.255\n\n% No abuse contact registered for 197.199.0.0 - 197.199.127.255\n\ninetnum:        197.199.0.0 - 197.199.127.255\n\n% No abuse contact registered for 197.199.128.0 - 197.199.159.255\n\ninetnum:        197.199.128.0 - 197.199.159.255\n\n% No abuse contact registered for 197.199.160.0 - 197.199.191.255\n\ninetnum:        197.199.160.0 - 197.199.191.255\n\n% No abuse contact registered for 197.199.192.0 - 197.199.223.255\n\ninetnum:        197.199.192.0 - 197.199.223.255\n\n% No abuse contact registered for 197.199.253.0 - 197.199.253.255\n\ninetnum:        197.199.253.0 - 197.199.253.255\n\n% No abuse contact registered for 197.199.254.0 - 197.199.254.255\n\ninetnum:        197.199.254.0 - 197.199.254.255\n\n% No abuse contact registered for 197.199.255.0 - 197.199.255.255\n\ninetnum:        197.199.255.0 - 197.199.255.255\n\n% No abuse contact registered for 41.152.0.0 - 41.153.255.255\n\ninetnum:        41.152.0.0 - 41.153.255.255\n\n% No abuse contact registered for 41.222.128.0 - 41.222.135.255\n\ninetnum:        41.222.128.0 - 41.222.135.255\n\n% No abuse contact registered for 2c0f:fc88::/31\n\ninet6num:       2c0f:fc88::/31\n\n% No abuse contact registered for AS36992\n\naut-num:        AS36992\n\n\n\n"));
    }
    @Test
    public void de1() {
        Assert.assertEquals(BillingCategory.EU_AS, response(" aut-num:        AS36893"));

    }
    @Test
    public void asrl1() {
        Assert.assertEquals(BillingCategory.EU_AS, response(" aut-num:        AS37006"));

    }
    @Test
    public void acl6() {
        Assert.assertEquals(BillingCategory.IPV6_SMALL, response("% This is the AfriNIC Whois server.\n" +
                "\n" +
                "% Note: this output has been filtered.\n" +
                "% Only primary keys and abuse contacts will be visible.\n" +
                "% No other contact information will be shown.\n" +
                "\n" +
                "% No abuse contact registered for 2001:43f8:b40::/48\n" +
                "\n" +
                "inet6num:       2001:43f8:b40::/48"));
    }
}
