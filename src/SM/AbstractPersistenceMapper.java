package SM;

public abstract class AbstractPersistenceMapper implements IMapper{
    @Override
    public final Object get(int oid){
        Object obj = getObjectFromStorage(oid);
        return obj;
    }
    protected abstract Object getObjectFromStorage(int oid);
    @Override
    public abstract void  put(int oid, Object oj);
  
}
