package SM;

import java.util.*;

public class SaleFactory {
    static SaleFactory instance;
    IVATCalculator vatCalculator;
    Vector <ProductSpecification> psList = new Vector<ProductSpecification>(10);
    
    public SaleFactory(){
        
        ProductSpecification ps1 = new ProductSpecification();
        ps1.setId(1);
        ps1.setName("Rice");
        ps1.setDescription("");
        ps1.setPrice(40);
        psList.add(ps1);
        ProductSpecification ps2 = new ProductSpecification();
        ps2.setId(2);
        ps2.setName("Potato");
        ps2.setDescription("");
        ps2.setPrice(30);
        psList.add(ps2);
        ProductSpecification ps3 = new ProductSpecification();
        ps3.setId(3);
        ps3.setName("Onion");
        ps3.setDescription("");
        ps3.setPrice(80);
        psList.add(ps3);
        ProductSpecification ps4 = new ProductSpecification();
        ps4.setId(4);
        ps4.setName("Wheat");
        ps4.setDescription("");
        ps4.setPrice(50);
        psList.add(ps4);
        ProductSpecification ps5 = new ProductSpecification();
        ps5.setId(5);
        ps5.setName("Suger");
        ps5.setDescription("");
        ps5.setPrice(70);
        psList.add(ps5);
        ProductSpecification ps6 = new ProductSpecification();
        ps6.setId(6);
        ps6.setName("Salt");
        ps6.setDescription("");
        ps6.setPrice(45);
        psList.add(ps6);
        ProductSpecification ps7 = new ProductSpecification();
        ps7.setId(7);
        ps7.setName("Garlic");
        ps7.setDescription("");
        ps7.setPrice(65);
        psList.add(ps7);

    }
    public ProductSpecification getProductSpecification(int id){

        for(int i = 0; i < psList.size(); i++){
            if(psList.get(i).getId() == id){
                return psList.get(i);
            }
        }
        return null;
    }
    public static synchronized SaleFactory getInstance(){
        if(instance == null)
            instance = new SaleFactory();
        return instance;
    }
    public IVATCalculator getVatCalculator() throws Exception{
        if(vatCalculator == null){
            //String className = System.getProperty(vatCalculator.class.name);
            //String className = System.getProperty("SM.MyVATCalculator");
            
            //vatCalculator = (IVATCalculator)Class.forName(className).newInstance();
            
            
            vatCalculator = (IVATCalculator)Class.forName("SM.BDVATAdapter").newInstance();
        }
        return vatCalculator;
    }
}
