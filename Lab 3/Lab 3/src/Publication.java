import java.util.Scanner;
// Base class
public class Publication {
    private String title;
    private double price;

    public void getdata(Scanner sc) {
        System.out.print("Enter title: ");
        title = sc.nextLine();
        System.out.print("Enter price: ");
        price = sc.nextDouble();
        sc.nextLine(); // clear newline
    }

    public void putdata() {
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
    }
}