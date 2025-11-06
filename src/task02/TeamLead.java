package task02;

import task02.exception.*;

import java.util.ArrayList;
import java.util.List;

public class TeamLead {
    private String name;
    private List<Programmer> list;
    private Status status;

    public TeamLead(String name, List<Programmer> list, Status status) {
        this.name = name;
        this.list = new ArrayList<>(list);
        this.status = status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String doTask(String taskMsg) {
        if (status == Status.BUSY) {
            throw new TeamLeadBusyException(String.format("%s is busy with other task", name));
        }
        if (status == Status.UNAVAILABLE) {
            throw new TeamLeadUnavailableNowException(String.format("%s is unavailable", name));
        }
        for (Programmer programmer : list) {
            try {
                String result = programmer.doWork(taskMsg);
                System.out.println(programmer + " solved task");
                return result;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        throw new TaskNotDoneException("All programmers are busy or unavailable");
    }

    @Override
    public String toString() {
        return String.format("TeamLead %s (%s) has programmers: [%s]", name, status, list);
    }
}
