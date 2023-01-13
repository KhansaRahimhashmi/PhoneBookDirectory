package PhoneBook;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class BusinessContact extends PhoneBook implements Phone, Serializable {
    private String jobTitle;
    private String organization;

    public BusinessContact(int id, String name, boolean status, String emailAddress, ArrayList<ContactDetails> contact, String jobTitle, String organization) {
        super(id, name, status, emailAddress, contact);
        this.jobTitle = jobTitle;
        this.organization = organization;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    public String getOrganization() {
        return organization;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public void createNewContact() throws IOException {

    }

    @Override
    public void showAllContact() {

    }

    @Override
    public void searchContact() {

    }

    @Override
    public void updateContact() {

    }

    @Override
    public void deleteContact() {

    }



    @Override
    public void emergencyContactList() {

    }

    @Override
    public void exit() {

    }
}
