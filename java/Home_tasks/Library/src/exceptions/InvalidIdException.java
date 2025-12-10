package exceptions;

public class InvalidIdException extends BookRepositoryException {

    public InvalidIdException(String message){
        super(message);
    }
}