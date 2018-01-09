package SM;

public class PercentageDiscountPricingStrategy implements ISalePricingStrategy{
    private final float persentage = (float) 0.9; 
    @Override
    public int getTotal(Sale sale) {
        return (int) (sale.getPreDiscountTotal() * persentage);
    }
    
}
