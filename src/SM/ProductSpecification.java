package SM;

public class ProductSpecification {
    private int id;
    private String name;
    private String description;
    private int price;
    IManufacturer manufacturer;

    public ProductSpecification(int id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    ProductSpecification() {
        
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    public IManufacturer getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(IManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getManufacturerName(){
        return manufacturer.getName();
    }
    public String getManufacturerAddress(){
        return manufacturer.getAddress();
    }
}
