public class Address {
    private String street;
    private String house;
    private String city;
    private String code;


    public Address(String street, String house, String city, String code) {
        this.street = street;
        this.house = house;
        this.city = city;
        this.code = code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", city='" + city + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

}
