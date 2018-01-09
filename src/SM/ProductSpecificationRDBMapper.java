package SM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductSpecificationRDBMapper extends AbstractRDBMapper{

    public ProductSpecificationRDBMapper(String tableName) {
        super(tableName);
    }
    @Override
    protected Object getObjectFromRecord(int oid, ResultSet dbRec) {
        ProductSpecification ps = new ProductSpecification();
        try {
            ps.setId(oid);
            while (dbRec.next()){
                ps.setName(dbRec.getString("NAME"));
                ps.setPrice(dbRec.getInt("PRICE"));
                ps.setDescription(dbRec.getString("DESCRIPTION"));
                ps.setManufacturer(new ManufacturerProxy(dbRec.getInt("MANUFACTURER_ID")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductSpecificationRDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps ;
    }
    @Override
    public void put(int oid, Object oj) {  
    }
}
