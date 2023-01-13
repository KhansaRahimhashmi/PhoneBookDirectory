package PhoneBook;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Directory implements Phone, Serializable {
    ArrayList<PhoneBook> phoneBook = new ArrayList<>();
    Address add[];
    ContactDetails c = null;
    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    File file = new File("Phonebook.ser");
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ListIterator li=null;

        public void createNewContact() throws IOException {
            try {
                if (file.isFile()) {
                    ois = new ObjectInputStream(new FileInputStream(file));
                    phoneBook = (ArrayList<PhoneBook>) ois.readObject();
                    ois.close();
                }
            }
            catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            oos = new ObjectOutputStream(new FileOutputStream(file, true));
           System.out.println("                ");
           System.out.println("THANK YOU FOR USING PHONEBOOK MANAGEMENT SYSTEM");
           System.out.println("Let's start adding contacts...");
            System.out.println("------------------------------------------------");
            PhoneBook objectPhone = null;
            System.out.println("ADD PERSON'S DETAILS...");
           int num = 0;
            while (true) {
               try {
                    System.out.print("How many contacts do you want to save : ");
                    num = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
            for (int i = 0; i < num; i++) {
                int no = 0;
                String phoneNo;
                boolean status = false;
                System.out.print("Enter Id of Contact " + (i + 1) + " : ");
               int id = input.nextInt();
                System.out.print("Enter Name of Contact " + (i + 1) + " : ");
                String name = inputString.nextLine();
               while (true) {
                   try {
                        System.out.print("Enter Contact status (i.e True=Active, False=Blocked) : ");
                       status = input.nextBoolean();
                       break;
                    } catch (InputMismatchException e) {
                        System.out.println("Enter Valid Choice!");
                        System.out.println(e.getMessage());
                    }
                }
                System.out.print("Enter Email Address of Contact " + (i + 1) + " : ");
                String email = inputString.nextLine();
                while (true) {
                    try {
                        System.out.println("-------------------------------------------");
                       System.out.print("How many contact numbers do the contact have : ");
                        no = input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                }
                for (int j = 0; j < no; j++) {
                    System.out.println("ADD CONTACT DETAILS...");
                    while (true) {
                        try {
                            System.out.print("Enter Phone Number of Contact " + (j + 1) + " : ");
                            phoneNo = inputString.nextLine();
                            break;
                       } catch (InvalidPhoneNoException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.print("Enter Country Code of Contact " + (j + 1) + " : ");
                    String countryCode = inputString.nextLine();
                    System.out.print("Enter City Code of Contact " + (j + 1) + " : ");
                    String cityCode = inputString.nextLine();
                   ArrayList<ContactDetails> contact = new ArrayList<>();
                    System.out.println("ADD ADDRESS DETAILS...");
                    System.out.print("How many address do the contact have : ");
                    int ad = input.nextInt();
                    add = new Address[ad];
                    for (int k = 0; k < add.length; k++) {
                        System.out.print("Enter City Name of Contact " + (k + 1) + " : ");
                        String city = inputString.nextLine();
                        System.out.print("Enter Country Name of Contact " + (k + 1) + " : ");
                        String country = inputString.nextLine();
                        add[k] = new Address(city, country);
                    }
                    c = new ContactDetails(phoneNo, cityCode, countryCode, add);
                    contact.add(c);
                    System.out.print("Please Enter/Specify the contact type (i.e 1 for Personal, 2 for Business) : ");
                    int contactType = input.nextInt();
                    if (contactType == 1) {
                       System.out.println("-----------------------------------------");
                        System.out.print("ADD PERSONAL DETAILS...");
                        System.out.print("Enter date of birth of Contact " + (j + 1) + " (i.e DD/MM/YY) : ");
                        String dob = inputString.nextLine();
                        objectPhone = new PersonalContact(id, name, status, email, contact, dob);

                    }
                    if (contactType == 2) {
                        System.out.print("ADD BUSINESS DETAILS...");
                        System.out.print("Enter Job Title : ");
                        String jobTitle = inputString.nextLine();
                        System.out.print("Enter Organization : ");
                        String org = inputString.nextLine();
                        objectPhone = new BusinessContact(id, name, status, email, contact, jobTitle, org);
                    }
                }

            }
        phoneBook.add(objectPhone);
        oos.writeObject(objectPhone);
        oos.close();


    }
     public void showAllContact() throws IOException, ClassNotFoundException {
             if (file.isFile()) {
                 ois = new ObjectInputStream(new FileInputStream(file));
                 phoneBook = (ArrayList<PhoneBook>) ois.readObject();
                 ois.close();

                 System.out.println("-----------------------------------------------");
                 li = phoneBook.listIterator();
                 while (li.hasNext()) {
                     System.out.println(li.next());

                     System.out.println("-----------------------------------------------");
                 }
             } else
                 System.out.println("File not found!");
         }
//            for (PhoneBook p:phoneBook ) {
//             System.out.println("------------------------------------------");
//             System.out.println("List of all Contacts...");
//             System.out.println("Id : " + p.getId() + "\nName : " + p.getName() + "\nEmail Address : "+p.getEmailAddress()+"\nCity Code : "+c.getCityCode()+"\nCountry Code : " +c.getCountryCode()+"\nAddress : "+c.getAddresses());
//
//
//             if(p instanceof PersonalContact){
//                 System.out.println("Date of Birth: "+((PersonalContact) p).getDateOfBirth());
//             }
//             else if(p instanceof  BusinessContact){
//                 System.out.println("Job Title: "+((BusinessContact) p).getJobTitle()+"\nOrganization: "+((BusinessContact) p).getOrganization());
//             }
//         }



    public void searchContact () throws IOException, ClassNotFoundException {
        boolean found = false;
        if (file.isFile()) {
            ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
            phoneBook = (ArrayList<PhoneBook>) ois.readObject();
            ois.close();

            found = false;
            System.out.print("Enter id to search : ");
            int id = input.nextInt();
            System.out.println("--------------------------------------- ");
            li = phoneBook.listIterator();
            while (li.hasNext()) {
                PhoneBook phoneBook = (PhoneBook) li.next();
                if (phoneBook.getId() == id) {
                    System.out.println(phoneBook);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Contact Not Found!");
        }
        else
            System.out.println("File doesn't exist.");
    }

    @Override
    public void updateContact() throws IOException, ClassNotFoundException {

    }

    public void deleteContact() throws ClassNotFoundException, IOException {
        boolean found = false;
        if (file.isFile()) {
            ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
            phoneBook = (ArrayList<PhoneBook>) ois.readObject();
            ois.close();

            found = false;
            System.out.print("Enter id to delete contact : ");
            int id = input.nextInt();
            System.out.println("--------------------------------------- ");
            li = phoneBook.listIterator();
            while (li.hasNext()) {
                PhoneBook phoneBook = (PhoneBook) li.next();
                if (phoneBook.getId() == id) {
                    li.remove();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Contact Not Found!");
        }

        else if(found)
        {
            ois = new ObjectInputStream(new ObjectInputStream(file));
            phoneBook=(ArrayList<PhoneBook>)ois.readObject();
            oos.close();
            System.out.println("Contact Deleted Successfully...!");
        }

        else
            System.out.println("File doesn't exist.");
        }
    public void UpdateContact(){

    }


    public void emergencyContactList(){
        System.out.println("-------------------------------------------");
        System.out.println(" Sr. Organization            Helpline      ");
        System.out.println(" 1-  Edhi Ambulance          115           ");
        System.out.println(" 2-  Chipa Ambulance         1020          ");
        System.out.println(" 3-  Rescue                  1122          ");
        System.out.println(" 4-  Police Madadgar         15            ");
        System.out.println(" 5-  Rangers                 1101          ");
        System.out.println(" 6-  Medical Assistance      1166          ");
        System.out.println(" 7-  Aman Ambulance          1021          ");
        System.out.println(" 8-  Fire Brigade            16            ");
        System.out.println("-------------------------------------------");

    }

    public void exit () {
        System.out.println("Good Bye!");
        System.exit(0);

    }


}
