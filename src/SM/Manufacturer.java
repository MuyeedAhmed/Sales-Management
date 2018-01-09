package SM;

public class Manufacturer implements IManufacturer{
    private int manufacturer_id;
    private String name;
    private String address;
    
    public int getManufacturer_id() {
        return manufacturer_id;
    }
    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }      
}
