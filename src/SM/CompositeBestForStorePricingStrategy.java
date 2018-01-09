package SM;

import static java.lang.Integer.*;
import java.util.Iterator;

public class CompositeBestForStorePricingStrategy extends CompositePricingStrategy{

    @Override
    public int getTotal(Sale sale) {
        int highestTotal = Integer.MIN_VALUE;
        ISalePricingStrategy pdp = new PercentageDiscountPricingStrategy();
        add(pdp);
        ISalePricingStrategy adt = new AbsoluteDiscountOverThresholdPricingStrategy();
        add(adt);
        Iterator strategyIterator = pricingStrategy.iterator();

        while(strategyIterator.hasNext()) {
            ISalePricingStrategy strat = (ISalePricingStrategy) strategyIterator.next();
            int total = strat.getTotal(sale);
            highestTotal = max(highestTotal, total);
        }  
        return highestTotal;
    }

}
