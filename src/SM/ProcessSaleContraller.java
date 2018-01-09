package SM;

import java.util.*;

public class ProcessSaleContraller {
    Sale sale = new Sale();
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

    public int getTotalPrice(){
        return sale.getTotal();
    }
}
