package SM;

import java.util.*;

public class Sale {
    Vector <SalesLineItem> sli = new Vector <SalesLineItem>(10);
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
    public void addSaleLineItem(int id, int quantity){
        SalesLineItem item = new SalesLineItem(id, quantity);
        sli.add(item);
    }
    public int getTotal(){
        int total = 0;
        for(int i = 0; i < sli.size(); i++){
            total += sli.get(i).getSubTotal();
        }
        return total;
    }
    public int getGrandTotal()throws Exception{
        return this.getTotal() + this.getVATAmount();
    }
    public int getVATAmount() throws Exception{
        IVATCalculator ivac = SaleFactory.getInstance().getVatCalculator();
        return ivac.getVATAmount(this.getTotal());
    }
}

