package SM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleRDBMapper extends AbstractRDBMapper{
    public SaleRDBMapper(String tableName) {
        super(tableName);
    }
    @Override
    protected Object getObjectFromRecord(int oid, ResultSet dbRec) {
        return null;     
    }

    @Override
    public void put(int oid, Object oj) {
        try {
            Sale sale = (Sale)oj;
            int saleTotal = sale.getSaleTotal();
            Statement stmt = con.createStatement();
            //String sql = "INSERT INTO Sale VALUES (" + oid + ", " + saleTotal + ", " + sale.getVATAmount() +", " + (sale.getPreDiscountTotal() - sale.getTotal())+ ")";
            String sql = "INSERT INTO Sale VALUES (" + oid +  ", " + false +", " + true + ", " + saleTotal +")";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SaleRDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
