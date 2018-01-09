package SM;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ManufacturerProxy implements IManufacturer{
    IManufacturer realSubject;
    int oid;
    public ManufacturerProxy(int manufacturer_id){
        this.oid = manufacturer_id;
    }
    @Override
    public String getName() {
        return getRealSubject().getName();
    }

    @Override
    public String getAddress() {
        return getRealSubject().getAddress();
    }
    private IManufacturer getRealSubject(){
        try {
            PersistenceFacade pf = new PersistenceFacade(); 
            if(realSubject == null)
                realSubject = (IManufacturer) pf.get(oid, Class.forName("SM.Manufacturer"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManufacturerProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return realSubject;
    }
    
}
