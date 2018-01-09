package SM;

public class SalesLineItem {
    ProductSpecification ps = new ProductSpecification();
    private int quantity;
    
    private boolean validId = true;
    
    public SalesLineItem(){

    }
    public SalesLineItem(int id, int quantity) {
        SaleFactory sf = new SaleFactory();
        ps = sf.getProductSpecification(id);
        this.quantity = quantity;
    }
    public ProductSpecification getPs() {
        return ps;
    }
    public void setPs(ProductSpecification ps) {
        this.ps = ps;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getValidId(){
        if(ps == null)
            validId = false;
        else
            validId = true;
        return validId;
    }
    
    public int getSubTotal(){
        return quantity * ps.getPrice();
    }
}
