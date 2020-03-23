package koviiv.json.jackson;

public class Building {
    private String street;
    private int building;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Building{" +
                "street='" + street + '\'' +
                ", building=" + building +
                '}';
    }
}
