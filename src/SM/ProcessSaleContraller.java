package SM;

import java.util.*;

public class ProcessSaleContraller {
    Sale sale= new Sale();
    public ProcessSaleContraller(){
        
    }
    public void makeNewSale(){
        sale.emptySalesLineItems();
    }
    public void addItem(int id, int quantity){
        sale.addSaleLineItem(id, quantity);
    }
    public Vector <SalesLineItem> getSalesLineItemList(){
        return sale.getSli();
    }
    public ProductSpecification getProductSpecification(int id){
        SaleFactory sf = new SaleFactory();
        return sf.getProductSpecification(id);
    }
    public int getVAT(){
        return sale.getVATAmount();
    }
    public int getDiscount(){
        return sale.getPreDiscountTotal() - sale.getTotal();
    }
    public int getTotalPrice(){
        new SaleFrame1().initialize(sale);
        sale.setTotal(sale.getGrandTotal()); 
        return sale.getGrandTotal();
    }
    
    public void setPricingStrategy(String s){
        sale.setStrategy(s);
    }
}
