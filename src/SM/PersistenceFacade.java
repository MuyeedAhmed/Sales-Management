package SM;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceFacade {
    static PersistenceFacade instance;
    HashMap mappers = new HashMap <Class, IMapper>();
    public PersistenceFacade(){    
        try {
            mappers.put(Class.forName("SM.ProductSpecification"), new ProductSpecificationRDBMapper("ProductSpecification"));
            mappers.put(Class.forName("SM.Sale"), new SaleRDBMapper("Sale"));
            mappers.put(Class.forName("SM.Manufacturer"), new ManufacturerRDBMapper("Manufacturer"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static synchronized PersistenceFacade getInstance(){
        if(instance == null)
            instance = new PersistenceFacade();
        return instance;
    }
    public Object get(int oid, Class persistenceClass){
        IMapper mapper = (IMapper) mappers.get(persistenceClass);     
        return  mapper.get(oid);
    }
    public void put(int oid, Object obj){
        IMapper mapper = (IMapper) mappers.get(obj.getClass());
        mapper.put(oid, obj);
    }

}
