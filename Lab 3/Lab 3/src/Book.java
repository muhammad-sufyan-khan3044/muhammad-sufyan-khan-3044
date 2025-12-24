import java.util.Scanner;

public class Book extends Publication {
    private int pageCount;

    @Override
    public void getdata(Scanner sc) {
        super.getdata(sc); // get title and price
        System.out.print("Enter page count: ");
        pageCount = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void putdata() {
        super.putdata(); // display title and price
        System.out.println("Page Count: " + pageCount);
    }
}
