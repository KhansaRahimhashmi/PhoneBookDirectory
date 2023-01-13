package PhoneBook;

import java.io.Serializable;

public class Address implements Serializable {
    private String city;
    private String country;


    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
}
