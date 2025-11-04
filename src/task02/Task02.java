package task02;

public class Task02 {
    public static void main(String[] args) {
        Programmer p1 = new Programmer("Mike", Status.BUSY);
        try {
            System.out.println(p1.doWork("write code"));
        } catch (ProgrammerBusyException | ProgrammerUnavailableNowException e) {
            System.out.println(e.getMessage());
        }
    }
}
