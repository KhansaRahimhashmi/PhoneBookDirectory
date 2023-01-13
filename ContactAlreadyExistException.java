package PhoneBook;

public class ContactAlreadyExistException extends RuntimeException{

    public ContactAlreadyExistException(String s) {
        super(s);
    }

}
