package task02;

import task02.exception.ProgrammerBusyException;
import task02.exception.ProgrammerUnavailableNowException;

public class Task02 {
    public static void main(String[] args) {
        Programmer p1 = new Programmer("Mike", Status.AVAILABLE);
        try {
            System.out.println(p1.doWork("write code"));
        } catch (ProgrammerBusyException | ProgrammerUnavailableNowException e) {
            System.out.println(e.getMessage());
        }
    }
}
