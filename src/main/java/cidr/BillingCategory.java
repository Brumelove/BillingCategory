package cidr;

public class BillingCategory {

    public enum IPv4AllocationSizeCategory {

        EXTRASMALL,
        VERYSMALL,
        SMALL,
        MEDIUM,
        LARGE,
        VERYLARGE,
        EXTRALARGE
    }

    public IPv4AllocationSizeCategory bc(String allocationSize) {
        String value = allocationSize.replace("/", "");
        int intValue = Integer.valueOf(value);
        if (intValue > 20 && intValue <= 22)
            return IPv4AllocationSizeCategory.EXTRASMALL;

        else if (intValue > 18 && intValue <= 20)
            return IPv4AllocationSizeCategory.VERYSMALL;

        else if (intValue > 16 && intValue <= 18)
            return IPv4AllocationSizeCategory.SMALL;

        else if (intValue > 14 && intValue <= 16)
            return IPv4AllocationSizeCategory.MEDIUM;

        else if (intValue > 12 && intValue <= 14)
            return IPv4AllocationSizeCategory.LARGE;

        else if (intValue > 10 && intValue <= 12)
            return IPv4AllocationSizeCategory.VERYLARGE;

        else if (intValue > 1 && intValue <= 10)
            return IPv4AllocationSizeCategory.EXTRALARGE;


        return null;
    }

    public boolean testAllocationSize(String allocationSize, IPv4AllocationSizeCategory billingCategory) {
        IPv4AllocationSizeCategory realBillingCategory = this.bc(allocationSize);
        if (realBillingCategory.equals(billingCategory)) {
            return true;
        }

        return false;
    }

    public IPv4AllocationSizeCategory determineBillingCategoryString(String value) {
        switch (value) {
            case "LIR extra small":
                return BillingCategory.IPv4AllocationSizeCategory.EXTRASMALL;
            case "LIR very small":
                return IPv4AllocationSizeCategory.VERYSMALL;
            case "LIR small":
                return IPv4AllocationSizeCategory.SMALL;
            case "LIR medium":
                return IPv4AllocationSizeCategory.MEDIUM;
            case "LIR large":
                return IPv4AllocationSizeCategory.LARGE;
            case "LIR very large":
                return IPv4AllocationSizeCategory.VERYLARGE;
            case "LIR extra large":
                return IPv4AllocationSizeCategory.EXTRALARGE;
        }
        return null;
    }
}







