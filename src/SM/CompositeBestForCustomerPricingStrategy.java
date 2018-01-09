package SM;

import static java.lang.Integer.*;
import java.util.Iterator;

public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy{
    
    @Override
    public int getTotal(Sale sale) {
        int lowestTotal = Integer.MAX_VALUE;
        ISalePricingStrategy pdp = new PercentageDiscountPricingStrategy();
        add(pdp);
        ISalePricingStrategy adt = new AbsoluteDiscountOverThresholdPricingStrategy();
        add(adt);
        
        Iterator strategyIterator = pricingStrategy.iterator();

        while(strategyIterator.hasNext()) {
            ISalePricingStrategy strat = (ISalePricingStrategy) strategyIterator.next();
            int total = strat.getTotal(sale);
            lowestTotal = min(lowestTotal, total);
        }
        return lowestTotal;
    }    
}
