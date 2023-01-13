package PhoneBook;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class PersonalContact extends PhoneBook implements Phone, Serializable {
    private String dateOfBirth;
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PersonalContact(int id, String name, boolean status, String emailAddress, ArrayList<ContactDetails> contact, String dateOfBirth) {
        super(id, name, status,emailAddress, contact);
        this.dateOfBirth = dateOfBirth;
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

