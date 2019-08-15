package cidr;

public class BillingCategory {

    public enum IPv4AllocationSizeCategory {

        LIR_EXTRASMALL,
        LIR_VERYSMALL,
        LIR_SMALL,
        LIR_MEDIUM,
        LIR_LARGE,
        LIR_VERYLARGE,
        LIR_EXTRALARGE,
        ENDSITES_MICRO,
        ENDSITES_MINI
    }

    public IPv4AllocationSizeCategory bc(int intValue) {
        if (intValue > 23 && intValue <= 24)
            return IPv4AllocationSizeCategory.ENDSITES_MICRO;
        else if (intValue > 22 && intValue <= 23)
            return IPv4AllocationSizeCategory.ENDSITES_MINI;
        else if (intValue > 20 && intValue == 22)
            return IPv4AllocationSizeCategory.LIR_EXTRASMALL;

        else if (intValue > 18 && intValue <= 20)
            return IPv4AllocationSizeCategory.LIR_VERYSMALL;

        else if (intValue > 16 && intValue <= 18)
            return IPv4AllocationSizeCategory.LIR_SMALL;

        else if (intValue > 14 && intValue <= 16)
            return IPv4AllocationSizeCategory.LIR_MEDIUM;

        else if (intValue > 12 && intValue <= 14)
            return IPv4AllocationSizeCategory.LIR_LARGE;

        else if (intValue > 10 && intValue <= 12)
            return IPv4AllocationSizeCategory.LIR_VERYLARGE;

        else if (intValue > 1 && intValue <= 10)
            return IPv4AllocationSizeCategory.LIR_EXTRALARGE;


        return null;
    }

    public boolean testAllocationSize(int allocationSize, IPv4AllocationSizeCategory billingCategory) {
        IPv4AllocationSizeCategory realBillingCategory = this.bc(allocationSize);
        if (realBillingCategory.equals(billingCategory)) {
            return true;
        }

        return false;
    }

    public IPv4AllocationSizeCategory determineBillingCategoryString(String value) {
        switch (value) {
            case "LIR extra small":
                return IPv4AllocationSizeCategory.LIR_EXTRASMALL;
            case "LIR very small":
                return IPv4AllocationSizeCategory.LIR_VERYSMALL;
            case "LIR small":
                return IPv4AllocationSizeCategory.LIR_SMALL;
            case "LIR medium":
                return IPv4AllocationSizeCategory.LIR_MEDIUM;
            case "LIR large":
                return IPv4AllocationSizeCategory.LIR_LARGE;
            case "LIR very large":
                return IPv4AllocationSizeCategory.LIR_VERYLARGE;
            case "LIR extra large":
                return IPv4AllocationSizeCategory.LIR_EXTRALARGE;
        }
        return null;
    }
}







