package PhoneBook;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        ArrayList<PhoneBook> phoneBook = new ArrayList<>();
        File file = new File("Phonebook.ser");
        ObjectOutputStream oos=null;
        ObjectInputStream ois = null;
        Address add[];
        ContactDetails c = null;
        boolean quit;
        Directory d = new Directory();
        do {
            System.out.println("|----------------------------------------|");
            System.out.println("|  PhoneBook Directory Management System |");
            System.out.println("|----------------------------------------|");
            System.out.println("| 1. Create new contact                  |");
            System.out.println("| 2. List all contacts                   |");
            System.out.println("| 3. Search Contact                      |");
            System.out.println("| 4. Update Contact                      |");
            System.out.println("| 5. Delete Contact                      |");
            System.out.println("| 6. Emergency Contact                   |");
            System.out.println("| 7. Exit                                |");
            System.out.println("|----------------------------------------|");
            quit = false;
            System.out.print("Please enter your choice : ");
            int choice = input.nextInt();

            switch (choice) {
                    case 1:
                        d.createNewContact();
                        break;
                    case 2:
                        d.showAllContact();
                        break;
                    case 3:
                        d.searchContact();
                        break;
                    case 4:
                        d.updateContact();
                        break;
                    case 5:
                        d.deleteContact();
                        break;
                    case 6:
                        d.exit();
                        break;
                    default:
                        System.out.println("Invalid Entry!");
                }
            } while (!quit);
        }


}





