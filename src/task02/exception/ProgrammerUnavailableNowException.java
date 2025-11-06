package task02.exception;

public class ProgrammerUnavailableNowException extends RuntimeException {
    public ProgrammerUnavailableNowException(String message) {
        super(message);
    }
}
