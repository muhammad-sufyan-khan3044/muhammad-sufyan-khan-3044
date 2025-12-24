import java.util.Scanner;

public class Person4 {
    private int id;
    private String name;
    private String address;

    public Person4() {}

    public Person4(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void getdata(Scanner sc) {
        System.out.print("Enter your id: ");
        id = sc.nextInt();
        sc.nextLine();   // clear buffer

        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.print("Enter your Address: ");
        address = sc.nextLine();
    }

    public void display() {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("address: " + address);
    }
}
