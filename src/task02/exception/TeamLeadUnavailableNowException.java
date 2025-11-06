package task02.exception;

public class TeamLeadUnavailableNowException extends RuntimeException {
    public TeamLeadUnavailableNowException(String message) {
        super(message);
    }
}
