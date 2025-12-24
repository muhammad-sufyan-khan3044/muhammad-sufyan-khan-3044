import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Lab Task 1: Creating objects of CounterClass
        System.out.println("Lab task No 1");

        for (int i = 0; i < 9; i++) {
            new CounterClass();   // object created
        }
        System.out.println();


        // Lab Task 2: Showing total number of objects
        System.out.println("Lab task No 2");

        int count = CounterClass.getCount();
        System.out.println("The total Objects in this class are: " + count);
        System.out.println();


        // Lab Task 3: Now Using Int class
        System.out.println("Lab task No 3");

        Int numA = new Int();        // default value
        Int numB = new Int(100);     // value set to 100

        System.out.println("Before initialization:");
        numA.display();

        System.out.println("After initialization:");
        numB.display();

        numB.setValue(50);           // changing value
        System.out.println("After changing:");
        numB.display();
        System.out.println();


        // Lab Task 4: Taking Time input and display
        System.out.println("Lab task No 4");

        Time time = new Time();
        time.input();                // taking input
        time.display12Hour();        // showing 12 hour format
        time.display24Hour();        // showing 24 hour format
        System.out.println();


        // Lab Task 5: Marks calculation
        System.out.println("Lab task No 5");

        Marks sufyan = new Marks(98, 88, 76);
        sufyan.sum();               // calculating sum
        sufyan.average();           // calculating average
        System.out.println();


        // Home Task 1: Rectangle calculations
        System.out.println("Home task No 1");

        Rectangle r1 = new Rectangle(4, 40);
        r1.getArea();
        r1.getPerimeter();

        Rectangle r2 = new Rectangle(3.5, 35.9);
        r2.getArea();
        r2.getPerimeter();
        System.out.println();


        // Home Task 2: Stock price change
        System.out.println("Home task No 2");

        Stock ORCL = new Stock(
                "orcl",
                "oracle corporation.",
                34.5,
                34.35
        );
        ORCL.getChangePercent();
        System.out.println();


        // Home Task 3 information  {Due to an issue in the main file, the objects were corrected in the Datelib file. So, if you want to check it, please check it in its own file.}
        System.out.println("Home task No 3 in DateLib file");
        System.out.println();


        // Home Task 4 information  {Due to an issue in the main file, the objects were corrected in the RandomNumbers file. So, if you want to check it, please check it in its own file.}

        System.out.println("Home task No 4 in RandomNumber file");
        System.out.println();


        // Home Task 5: Account operations
        System.out.println("Home task No 5");
        System.out.println();

        Account sufyankhan= new Account(
                1122,
                20000,
                new Date(15, 7, 2025)
        );

        System.out.println(sufyankhan);
        System.out.println();

        sufyankhan.withdraw(2500);         // withdrawing amount
        System.out.println();

        sufyankhan.deposit(3000);          // depositing amount
    }
}
