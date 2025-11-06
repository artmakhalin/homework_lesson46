package task02.exception;

public class TaskNotDoneException extends RuntimeException{
    public TaskNotDoneException(String message) {
        super(message);
    }
}
