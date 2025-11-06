package task02.exception;

public class TeamLeadBusyException extends RuntimeException {
    public TeamLeadBusyException(String message) {
        super(message);
    }
}
