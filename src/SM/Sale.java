package SM;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sale {
    Vector <SalesLineItem> sli = new Vector <SalesLineItem>(10);
    private String strategy;
   
    public Sale(){
        
    }
    public Vector<SalesLineItem> getSli() {
        return sli;
    }
    public void setSli(Vector<SalesLineItem> sli) {
        this.sli = sli;
    }
    public void emptySalesLineItems(){
        sli.removeAllElements();
    }
    public String getStrategy() {
        return strategy;
    }
    public void setStrategy(String strategy) {
        this.strategy = "SM." + strategy;
    }
    public void addSaleLineItem(int id, int quantity){
        SalesLineItem item = new SalesLineItem(id, quantity);
        sli.add(item);
    }
    public int getPreDiscountTotal(){
        int total = 0;
        for(int i = 0; i < sli.size(); i++){
            total += sli.get(i).getSubTotal();
        }
        return total;
    }
    
    public int getTotal(){
        try {
            //System.out.println("strategy " + this.strategy);
            ISalePricingStrategy isps = (ISalePricingStrategy)Class.forName(this.strategy).newInstance();
            return isps.getTotal(this);           
        } catch (Exception ex) { Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);}
        return 0;
    }
    
    
    
    public int getGrandTotal() {
        return this.getTotal() + this.getVATAmount();
    }
    public int getVATAmount() {
        try {
            IVATCalculator ivac = SaleFactory.getInstance().getVatCalculator();
            return ivac.getVATAmount(this.getPreDiscountTotal());
        } catch (Exception ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}

