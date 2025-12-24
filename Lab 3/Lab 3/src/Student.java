import java.util.Scanner;

public class Student extends Person4 {
    private int rollno;
    private int marks;

    public Student() {}

    public Student(int rollno, int marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public void getdata(Scanner sc) {
        super.getdata(sc);
        System.out.print("Enter your roll no: ");
        rollno = sc.nextInt();
        System.out.print("Enter your marks: ");
        marks = sc.nextInt();
    }

    @Override
    public void display() {
        super.display();   // displays id, name, address
        System.out.println("Roll no: " + rollno);
        System.out.println("Marks: " + marks);
    }
}
