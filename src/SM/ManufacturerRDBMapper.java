package SM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManufacturerRDBMapper extends AbstractRDBMapper{
    public ManufacturerRDBMapper(String tableName){
        super(tableName);
    }

    @Override
    protected Object getObjectFromRecord(int oid, ResultSet dbRec) {
        Manufacturer m = new Manufacturer();
        try {            
            m.setManufacturer_id(oid);
            while (dbRec.next()){
                m.setName(dbRec.getString("MANUFACTURER_NAME"));
                m.setAddress(dbRec.getString("ADDRESS"));
            }
        } catch (SQLException ex) { Logger.getLogger(ManufacturerRDBMapper.class.getName()).log(Level.SEVERE, null, ex);}
        return m;
    }
}
