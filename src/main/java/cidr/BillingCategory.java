package cidr;

import net.afrinic.myafrinic.commons.model.resources.ResourceType;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public enum BillingCategory {
    END_SITES_MICRO(23, 24, ResourceType.IPv4),
    END_SITES_MINI(22, 23, ResourceType.IPv4),
    LIR_EXTRA_SMALL(20, 22, ResourceType.IPv4),
    LIR_VERY_SMALL(18, 20, ResourceType.IPv4),
    LIR_SMALL(16, 18, ResourceType.IPv4),
    LIR_MEDIUM(14, 16, ResourceType.IPv4),
    LIR_LARGE(12, 14, ResourceType.IPv4),
    LIR_VERY_LARGE(10, 12, ResourceType.IPv4),
    LIR_EXTRA_LARGE(1, 10, ResourceType.IPv4),
    IPV6_SMALL(32, 47, ResourceType.IPv6),
    IPV6_LARGE(0, 31, ResourceType.IPv6),
    IPV6_PI_EU(48, 128, ResourceType.IPv6),
    EU_AS(0, Integer.MAX_VALUE, ResourceType.ASN);


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


    private final ResourceType resourceType;
    private final int maxCidr;
    private final int minCidr;


    BillingCategory(int maxCidr, int minCidr, ResourceType resourceType) {
        this.resourceType = resourceType;
        this.maxCidr = maxCidr;
        this.minCidr = minCidr;
    }

    public static Set<BillingCategory> byResourceType(ResourceType resourceType) {
        return BY_RESOURCE_TYPE.get(resourceType);
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


//
//    public static BillingCategory determineBC(Integer v4Cidr, Integer v6Cidr, Integer nbAsn) {
//        final BillingCategory myBillingCategory;
//        if (v4Cidr > 0) {
//            myBillingCategory = determineBCV4(v4Cidr);
//        } else if (v6Cidr > 0) {
//            myBillingCategory = determineBCV6(v6Cidr);
//        } else if (nbAsn > 0) {
//            myBillingCategory = determineBCAsn(nbAsn);
//        } else {
//            throw new IllegalArgumentException("No suitable value to compute the billing category");
//        }
//        return myBillingCategory;
//    }
//
////    private static BillingCategory determineBCAsn(int nbAsn) {
////        if (nbAsn > 0)
////            return BillingCategory.EU_AS;
////
////        return null;
////    }
////
////    private static BillingCategory determineBCV6(int v6Cidr) {
////        if (v6Cidr == 32)
////            return BillingCategory.IPV6_SMALL;
////        if (v6Cidr > 32 && v6Cidr <= 128)
////            if (v6Cidr == 48)
////                return BillingCategory.IPV6_PI_EU;
////        return BillingCategory.IPV6_LARGE;
////
////
////    }
////
////    private static BillingCategory determineBCV4(int v4Cidr) {
////        if (v4Cidr > 23 && v4Cidr <= 24)
////            return BillingCategory.END_SITES_MICRO;
////        else if (v4Cidr > 22 && v4Cidr <= 23)
////            return BillingCategory.END_SITES_MINI;
////        else if (v4Cidr > 20 && v4Cidr <= 22)
////            return BillingCategory.LIR_EXTRA_SMALL;
////
////        else if (v4Cidr > 18 && v4Cidr <= 20)
////            return BillingCategory.LIR_VERY_SMALL;
////
////        else if (v4Cidr > 16 && v4Cidr <= 18)
////            return BillingCategory.LIR_SMALL;
////
////        else if (v4Cidr > 14 && v4Cidr <= 16)
////            return BillingCategory.LIR_MEDIUM;
////
////        else if (v4Cidr > 12 && v4Cidr <= 14)
////            return BillingCategory.LIR_LARGE;
////
////        else if (v4Cidr > 10 && v4Cidr <= 12)
////            return BillingCategory.LIR_VERY_LARGE;
////
////        else if (v4Cidr > 1 && v4Cidr <= 10)
////            return BillingCategory.LIR_EXTRA_LARGE;
////
////        return null;
////    }

}
