package SM;

public class OID {
// OID oid = newOID("xyz123");
    public String id;
    public OID(String str){
        this.id = str;
    }
    public OID(int i){
        this.id = Integer.toString(i);
    }
}
