package SM;
import java.util.*;

public abstract class CompositePricingStrategy implements ISalePricingStrategy{
    ArrayList pricingStrategy = new ArrayList();
    public void add(ISalePricingStrategy isp){
        pricingStrategy.add(isp);
    }
    @Override
    public int getTotal(Sale sale){
        throw new UnsupportedOperationException();
    }
}
