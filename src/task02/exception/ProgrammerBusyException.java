package task02.exception;

public class ProgrammerBusyException extends RuntimeException {
    public ProgrammerBusyException(String message) {
        super(message);
    }
}
