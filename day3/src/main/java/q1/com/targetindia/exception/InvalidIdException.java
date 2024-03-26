package q1.com.targetindia.exception;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException() {
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(Throwable cause) {
        super(cause);
    }
}