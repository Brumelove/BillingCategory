package net.telnet.afrinic;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class WhoisObject {

    public enum Key {

        ORGANISATION("organisation", "organisation"),
        PERSON("person", "nic-hdl"),
        INETNUM("inetnum","inetnum"),
        INETNUM6("inet6num","inet6num"),
        AUTNUM("aut-num","aut-num");

        private String objectNameAttribute;
        private String keyAttribute;

        Key(String objectNameAttribute, String keyAttribute) {
            this.objectNameAttribute = objectNameAttribute;
            this.keyAttribute = keyAttribute;
        }



        public String getObjectNameAttribute() {
            return objectNameAttribute;
        }

        public String getKeyAttribute() {
            return keyAttribute;
        }
    }

    private Key key;

    public WhoisObject() {
    }

    private Map<String, List<String>> attributes = new HashMap<String, List<String>>();

    public Map<String, List<String>> getAttributes() {
        return attributes;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void add(String key, String value) {

        List<String> list = attributes.get(key);

        if (list == null) {
            list = new ArrayList<>();
            attributes.put("", list);
        }

        list.add(value);
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(WhoisObject.this).
                appendAsObjectToString(attributes).toString();

    }
}
