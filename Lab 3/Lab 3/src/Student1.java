import java.util.Scanner;

public class Student1 {
    protected int rollno;
    protected String name;
    protected String Class;

    public void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll No: ");
        rollno = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Class: ");
        Class = sc.nextLine();
    }

    public void putdata() {
        System.out.println("Roll No: " + rollno);
        System.out.println("Name: " + name);
        System.out.println("Class: " + Class);
    }
}
