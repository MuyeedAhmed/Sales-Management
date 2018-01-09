package SM;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sale {
    Vector <SalesLineItem> sli;
    private String strategy;
    private int saleTotal;
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    Vector <PropertyListener> propertyListener = new Vector<>(2);
    public Sale(){
        sli = new Vector <SalesLineItem>(10);
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
    public int getSaleTotal(){
        return this.saleTotal;
    }
    //Assignment 3 2
    public void setSaleTotal(int newTotal){
        this.saleTotal = newTotal;
        PersistenceFacade pf = new PersistenceFacade();
        int customerID = ID_GENERATOR.getAndIncrement();
        pf.put(customerID, this);
        publishPropertyEvent("sale.total", saleTotal);
    }
    public void addPropertyListener(PropertyListener lis){
        propertyListener.add(lis);
    }
    public void publishPropertyEvent(String name, int value){
        for(int i = 0; i < propertyListener.size(); i++)
            propertyListener.get(i).onPropertyEvent(this, name, value); 
    }
}

