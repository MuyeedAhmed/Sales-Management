package SM;

import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleFactory {
    static SaleFactory instance;
    IVATCalculator vatCalculator;
    
    public SaleFactory(){
        
    }
    public ProductSpecification getProductSpecification(int id){
        ProductSpecification ps = new ProductSpecification();
        try {
            PersistenceFacade pf = new PersistenceFacade();
            Class c = Class.forName("SM.ProductSpecification");
            ps = (ProductSpecification) pf.get(id, c);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaleFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }
    public static synchronized SaleFactory getInstance(){
        if(instance == null)
            instance = new SaleFactory();
        return instance;
    }
    public IVATCalculator getVatCalculator() throws Exception{
        if(vatCalculator == null){

            String className = new Scanner(new File("vatcalculator.txt")).useDelimiter("\\Z").next();
            className = "SM." + className;
            vatCalculator = (IVATCalculator)Class.forName(className).newInstance();
        }
        return vatCalculator;
    }
}
