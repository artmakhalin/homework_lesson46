package task02;

import task02.exception.ProgrammerBusyException;
import task02.exception.ProgrammerUnavailableNowException;

public class Programmer {
    private String name;
    private Status status;

    public Programmer(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String doWork(String taskMsg) {
        if (status == Status.BUSY) {
            throw new ProgrammerBusyException(String.format("%s is busy with other task", name));
        }
        if (status == Status.UNAVAILABLE) {
            throw new ProgrammerUnavailableNowException(String.format("%s is unavailable", name));
        }
        return String.format("%s is doing task: %s", name, taskMsg.toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("Programmer %s (%s)", name, status.toString());
    }
}
