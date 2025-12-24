import java.util.Scanner;

public class Test extends Student1 {
    private int T1marks, T2marks, T3marks;
    private int Sessional1, Sessional2;
    private int Assignment;
    private double Final;

    public void getmarks() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Test 1 Marks: ");
        T1marks = sc.nextInt();

        System.out.print("Enter Test 2 Marks: ");
        T2marks = sc.nextInt();

        System.out.print("Enter Test 3 Marks: ");
        T3marks = sc.nextInt();

        System.out.print("Enter Sessional 1 Marks: ");
        Sessional1 = sc.nextInt();

        System.out.print("Enter Sessional 2 Marks: ");
        Sessional2 = sc.nextInt();

        System.out.print("Enter Assignment Marks: ");
        Assignment = sc.nextInt();
    }

    public void Finalresult() {
        Final = T1marks + T2marks + T3marks + Sessional1 + Sessional2 + Assignment;
    }

    public void putmarks() {
        System.out.println("\n--- Marks Details ---");
        System.out.println("Test 1: " + T1marks);
        System.out.println("Test 2: " + T2marks);
        System.out.println("Test 3: " + T3marks);
        System.out.println("Sessional 1: " + Sessional1);
        System.out.println("Sessional 2: " + Sessional2);
        System.out.println("Assignment: " + Assignment);
        System.out.println("Final Result: " + Final);
    }
}
