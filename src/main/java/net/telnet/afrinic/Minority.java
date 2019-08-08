package net.telnet.afrinic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Minority {
    private static final Logger LOGGER = LoggerFactory.getLogger(Minority.class);

    private static final String DELIMITER = "\\|";
    private static final String COMMENT_PREFIX = "#";

    private static final int RESOURCE_TYPE_INDEX = 2;
    private static final int RESOURCE_INDEX = 3;
    private static final int RESOURCE_LENGTH_INDEX = 4;
    private static final int RESOURCE_STATUS_INDEX = 6;

    private static final String SUMMARY = "summary";
    private static final String RESOURCE_TYPE_IPV4 = "ipv4";
    private static final String RESOURCE_TYPE_IPV6 = "ipv6";
    private static final String RESOURCE_TYPE_ASN = "asn";

    private static final Map<String, Integer> powerOfTwoMap;

    static {
        powerOfTwoMap = new HashMap<>();
        for (int i = 0; i < 32; i++) {
            Integer power2 = Double.valueOf(Math.pow(2, i)).intValue();
            powerOfTwoMap.put(power2.toString(), i);
        }
    }


    public void readFile(File path) throws IOException {
        Scanner scanner = new Scanner(path);
        ArrayList<String> coll = new ArrayList<>();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            coll.add(line);
        }

        scanner.close();

        FileWriter writer = new FileWriter(path);
        for (String line : coll) {
            writer.write(line);
        }
        System.out.println(writer);

        writer.close();


    }

    public static void main(String args[]) throws IOException {
        Minority minority = new Minority();
        File file = new File("/src/main/java/net/telnet/afrinic/delegated-afrinic-extended-latestnet/telnet/afrinic");
        minority.readFile(file);
    }
}
