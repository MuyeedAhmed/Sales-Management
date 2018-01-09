package SM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractRDBMapper extends AbstractPersistenceMapper{
    public String tableName;
    private String host = "jdbc:derby://localhost:1527/DBRecord";
    private String uName = "akib";
    private String uPass= "130636";
    Connection con;
    public AbstractRDBMapper(String tableName){
        try {
            this.tableName = tableName;
            con = DriverManager.getConnection( host, uName, uPass );
        } catch (SQLException ex) {
            System.out.print("nein");
            Logger.getLogger(AbstractRDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }

    @Override
    protected Object getObjectFromStorage(int oid) {
     ResultSet dbRec = getDBRecord(oid);
     return getObjectFromRecord(oid, dbRec);
    }
    protected abstract Object getObjectFromRecord(int oid, ResultSet dbRec);
 
    private ResultSet getDBRecord (int oid){
        try {
            String key = Integer.toString(oid);
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM APP." + tableName + " WHERE ID = " + key;
            ResultSet dbRec = stmt.executeQuery(SQL);
            return dbRec;
        } catch (SQLException ex) {
            Logger.getLogger(AbstractRDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public void put(int oid, Object oj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
