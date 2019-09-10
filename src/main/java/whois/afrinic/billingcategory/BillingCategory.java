package whois.afrinic.billingcategory;

import net.afrinic.myafrinic.commons.model.resources.ResourceType;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public enum BillingCategory {
    END_SITES_MICRO("End sites micro", 23, 24, ResourceType.IPv4),
    END_SITES_MINI("End sites mini", 22, 23, ResourceType.IPv4),
    LIR_EXTRA_SMALL("LIR extra small", 20, 22, ResourceType.IPv4),
    LIR_VERY_SMALL("LIR very small", 18, 20, ResourceType.IPv4),
    LIR_SMALL("LIR small", 16, 18, ResourceType.IPv4),
    LIR_MEDIUM("LIR medium", 14, 16, ResourceType.IPv4),
    LIR_LARGE("LIR large", 12, 14, ResourceType.IPv4),
    LIR_VERY_LARGE("LIR very large", 10, 12, ResourceType.IPv4),
    LIR_EXTRA_LARGE("LIR extra large", 1, 10, ResourceType.IPv4),
    IPV6_SMALL("IPv6 small", 32, 47, ResourceType.IPv6),
    IPV6_LARGE("IPv6 large", 0, 31, ResourceType.IPv6),
    IPV6_PI_EU("IPv6 pi eu", 48, 128, ResourceType.IPv6),
    EU_AS("EU AS", 0, Integer.MAX_VALUE, ResourceType.ASN);


    private final static Map<ResourceType, Set<BillingCategory>> BY_RESOURCE_TYPE;

    static {
        BY_RESOURCE_TYPE = new TreeMap<>();
        for (BillingCategory billingCategory : BillingCategory.values()) {
            ResourceType thisBillingCategoryResourceType = billingCategory.resourceType;

            Set<BillingCategory> set = byResourceType(thisBillingCategoryResourceType);
            if (set == null) {
                set = new TreeSet();
                BY_RESOURCE_TYPE.put(thisBillingCategoryResourceType, set);
            }
            set.add(billingCategory);
        }
    }


    private final String description;
    private final int maxCidr;
    private final int minCidr;
    private final ResourceType resourceType;


    BillingCategory(String description, int maxCidr, int minCidr, ResourceType resourceType) {
        this.description = description;
        this.resourceType = resourceType;
        this.maxCidr = maxCidr;
        this.minCidr = minCidr;
    }

    public static Set<BillingCategory> byResourceType(ResourceType resourceType) {
        return BY_RESOURCE_TYPE.get(resourceType);
    }

    public String getDescription() {
        return description;
    }

    public int getMaxCidr() {
        return maxCidr;
    }

    public int getMinCidr() {
        return minCidr;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public static BillingCategory getBC(ResourceType resourceType, Integer vCidr) {
        Set<BillingCategory> billingCategories = byResourceType(resourceType);
        for (BillingCategory bCategory : billingCategories) {
            if (bCategory.getMaxCidr() <= vCidr && bCategory.getMinCidr() >= vCidr) {
                return bCategory;

            }

        }

        throw new IllegalArgumentException("Invalid billing category for " + resourceType + " corresponding to " + vCidr);


    }




}
