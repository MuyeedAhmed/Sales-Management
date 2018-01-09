package SM;

public class AbsoluteDiscountOverThresholdPricingStrategy implements ISalePricingStrategy{
    private final int discount = 100;
    private final int threshold = 1000;
    @Override
    public int getTotal(Sale sale) {
        if(sale.getPreDiscountTotal() > threshold)
            return sale.getPreDiscountTotal() - discount;
        else
            return sale.getPreDiscountTotal();
    }
    
}
