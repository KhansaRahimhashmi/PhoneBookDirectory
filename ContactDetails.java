package PhoneBook;

import java.io.Serializable;

public class ContactDetails implements Serializable {
       private String phoneNo;
       private String cityCode;
       private String countryCode;
       Address[]addresses;

    public void setPhoneNo(String phoneNo) {
        if(phoneNo.length()!=11){
            throw new InvalidPhoneNoException("Invalid Phone Number Exception!\nEnter a valid Phone No(11 digits only).");
        }
        else
        this.phoneNo = phoneNo;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public ContactDetails(String phoneNo, String cityCode, String countryCode, Address[] addresses) {
        this.phoneNo = phoneNo;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.addresses = addresses;
    }
}
