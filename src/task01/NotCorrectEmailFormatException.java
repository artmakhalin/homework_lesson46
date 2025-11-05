package task01;

import java.util.ArrayList;
import java.util.List;

public class NotCorrectEmailFormatException extends RuntimeException {
    private List<String> errors = new ArrayList<>();

    public void addError(String error) {
        errors.add(error);
    }

    public boolean isError() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }

    public void clearErrors() {
        errors.clear();
    }
}
