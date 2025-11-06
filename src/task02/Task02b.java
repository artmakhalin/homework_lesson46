package task02;

import java.util.List;

public class Task02b {
    public static void main(String[] args) {
        Programmer jack = new Programmer("Jack", Status.AVAILABLE);
        Programmer john = new Programmer("John", Status.AVAILABLE);
        Programmer mike = new Programmer("Mike", Status.AVAILABLE);

        TeamLead teamLead = new TeamLead("Lena", List.of(
                jack,
                john,
                mike
        ), Status.AVAILABLE);
//        teamLead.setStatus(Status.AVAILABLE);
//        jack.setStatus(Status.BUSY);
//        john.setStatus(Status.AVAILABLE);
//        mike.setStatus(Status.BUSY);

        try {
            System.out.println(teamLead.doTask("do task"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
