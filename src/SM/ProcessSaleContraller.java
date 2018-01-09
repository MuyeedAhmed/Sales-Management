package SM;

import java.util.*;

public class ProcessSaleContraller {
    Sale sale;
    public ProcessSaleContraller(){
        sale = new Sale();
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
        return sale.getGrandTotal();
    }
    public void setSaleTotal(){
        sale.setSaleTotal(getTotalPrice());
    }
    public void setPricingStrategy(String s){
        sale.setStrategy(s);
    }
}
