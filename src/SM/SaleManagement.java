package SM;

import java.util.Vector;

public class SaleManagement {
    public static void main(String[] args) {
        /*
        ProcessSaleContraller psc = new ProcessSaleContraller();
        //ProductSpecification ps = new ProductSpecification();
        Vector <SalesLineItem> sli = new Vector <SalesLineItem>(10);

        psc.addItem(2, 3);
        psc.addItem(1, 5);

        //ps = psc.getProductSpecification(3);
        sli = psc.getSalesLineItemList();
        for(int i = 0; i < sli.size(); i++)
        {
                ProductSpecification ps = new ProductSpecification();
                ps = sli.get(i).getPs();
                System.out.println(ps.getName() + " Price : " + sli.get(i).getSubTotal());
        }
        System.out.println("Tot : " + psc.getTotalPrice());
        psc.makeNewSale();
        psc.addItem(4, 10);
        for(int i = 0; i < sli.size(); i++)
        {
                ProductSpecification ps = new ProductSpecification();
                ps = sli.get(i).getPs();
                System.out.println(ps.getName() + " Price : " + sli.get(i).getSubTotal());
        }
        System.out.println("Tot : " + psc.getTotalPrice());
        */
        
        SaleJFrame sjf = new SaleJFrame();
        sjf.gui();
        
        //sjf.login();

        //Sale s = new Sale();
        //SalesLineItem sli = new SalesLineItem(1, 15);
        //SaleFactory sf = new SaleFactory();
        //ps = sf.getProductSpecification(1);
        //System.out.println("Hue " + ps.getName());
        //System.out.println("Tot pRice : " + sli.getSubTotal());
    }
}
