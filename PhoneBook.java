package PhoneBook;
import java.io.Serializable;
import java.util.ArrayList;
  public class PhoneBook implements Serializable {
    private int id;
    private String name;
    private Boolean status;
    private String emailAddress;
    private ArrayList<ContactDetails> contact;

      public Boolean getStatus() {
          return status;
      }

      public void setStatus(Boolean status) {
          if(status==false){
              throw new ContactBlockedException("Contact is Blocked.");
          }
          else if(status==true) {
              this.status = status;
          }
      }

      public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {
            if(name.length()>20)
            {
                this.name = name;
            }
            else if(name == "")
            {
                System.out.println("Invalid Name!\nName cannot be blank!");
            }
                                      }

    public String getEmailAddress() {
        return emailAddress;
    }

    public ArrayList<ContactDetails> getContact() {
        return contact;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setContact(ArrayList<ContactDetails> contact) {
        this.contact = contact;
    }

    public PhoneBook(int id, String name, boolean status, String emailAddress, ArrayList<ContactDetails> contact) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.emailAddress = emailAddress;
        this.contact = contact;

    }
}
