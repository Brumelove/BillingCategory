package net.telnet.afrinic;

import inet.ipaddr.AddressStringException;

import java.net.UnknownHostException;

public interface Resource {
    void ipv4contains() throws UnknownHostException, AddressStringException;

    void  ipv6contains();

    void autNumcontains();
}



