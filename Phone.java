package PhoneBook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Phone extends Serializable {
    public void createNewContact() throws IOException;
    public void showAllContact() throws IOException, ClassNotFoundException;
    public void searchContact () throws IOException, ClassNotFoundException;
    public void updateContact() throws IOException, ClassNotFoundException;
    public void deleteContact() throws IOException;
    public void emergencyContactList();
    public void exit ();
}
