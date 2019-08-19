//package cidr;
//
//public class refactoring {
//
//    public enum AllocationSizeCategory {
//        LIR_EXTRASMALL,
//        LIR_VERYSMALL,
//        LIR_SMALL,
//        LIR_MEDIUM,
//        LIR_LARGE,
//        LIR_VERYLARGE,
//        LIR_EXTRALARGE,
//        ENDSITES_MICRO,
//        ENDSITES_MINI
//
//
//    }
//
//
//    public AllocationSizeCategory allocationSizeCategory(int intValue) {
//
//        if (intValue > 23 && intValue <= 24)
//            return AllocationSizeCategory.ENDSITES_MICRO;
//        else if (intValue > 22 && intValue <= 23)
//            return AllocationSizeCategory.ENDSITES_MINI;
//        else if (intValue > 20 && intValue <= 22)
//            return AllocationSizeCategory.LIR_EXTRASMALL;
//
//        else if (intValue > 18 && intValue <= 20)
//            return AllocationSizeCategory.LIR_VERYSMALL;
//
//        else if (intValue > 16 && intValue <= 18)
//            return AllocationSizeCategory.LIR_SMALL;
//
//        else if (intValue > 14 && intValue <= 16)
//            return AllocationSizeCategory.LIR_MEDIUM;
//
//        else if (intValue > 12 && intValue <= 14)
//            return AllocationSizeCategory.LIR_LARGE;
//
//        else if (intValue > 10 && intValue <= 12)
//            return AllocationSizeCategory.LIR_VERYLARGE;
//
//        else if (intValue > 1 && intValue <= 10)
//            return AllocationSizeCategory.LIR_EXTRALARGE;
//
//
//        return null;
//    }
//
//
//    private static BillingCategory determineBCV4(int v4Cidr) {
//        if (v4Cidr > 23 && v4Cidr <= 24)
//            return BillingCategory.ENDSITES_MICRO;
//        else if (v4Cidr > 22 && v4Cidr <= 23)
//            return BillingCategory.ENDSITES_MINI;
//        else if (v4Cidr > 20 && v4Cidr <= 22)
//            return BillingCategory.LIR_EXTRASMALL;
//
//        else if (v4Cidr > 18 && v4Cidr <= 20)
//            return BillingCategory.LIR_VERYSMALL;
//
//        else if (v4Cidr > 16 && v4Cidr <= 18)
//            return BillingCategory.LIR_SMALL;
//
//        else if (v4Cidr > 14 && v4Cidr <= 16)
//            return BillingCategory.LIR_MEDIUM;
//
//        else if (v4Cidr > 12 && v4Cidr <= 14)
//            return BillingCategory.LIR_LARGE;
//
//        else if (v4Cidr > 10 && v4Cidr <= 12)
//            return BillingCategory.LIR_VERYLARGE;
//
//        else if (v4Cidr > 1 && v4Cidr <= 10)
//            return BillingCategory.LIR_EXTRALARGE;
//
//        return null;
//    }
//    public boolean testAllocationSize(int v4Cidr, BillingCategory billingCategory) {
//        BillingCategory realBillingCategory = getBC()m;
//        if (realBillingCategory.equals(billingCategory)) {
//            return true;
//        }
//
//        return false;
//    }
//
//    public BillingCategory determineBillingCategoryString(String value) {
//        switch (value) {
//            case "LIR extra small":
//                return LIR_EXTRASMALL;
//            case "LIR very small":
//                return LIR_VERYSMALL;
//            case "LIR small":
//                return LIR_SMALL;
//            case "LIR medium":
//                return LIR_MEDIUM;
//            case "LIR large":
//                return LIR_LARGE;
//            case "LIR very large":
//                return LIR_VERYLARGE;
//            case "LIR extra large":
//                return LIR_EXTRALARGE;
//        }
//        return null;
//    }
//
//
//}
//
//
//
//
//
//
//
