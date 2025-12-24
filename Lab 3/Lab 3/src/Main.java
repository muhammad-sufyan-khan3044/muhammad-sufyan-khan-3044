import java.util.Scanner;

public class Main {

    // Main method: program execution starts here
    public static void main(String[] args) {

        /* Lab Task No 1 ===================== */
        // Creating Address and Person objects
        System.out.println("Lab3 task No 1");

        Address aliAddress =
                new Address("samoungali road ", "mp_5566", "Quetta", "2137");

        Person p1 = new Person("sufyan", aliAddress);
        new Person("khan", aliAddress);
        new Person("ali", aliAddress);

        System.out.println(p1);
        System.out.println();


        /* Second way to create object ---------- */
        // second method of creating object
        System.out.println("Second method to create an Object");

        Person p2 = new Person(
                " sufyan",
                new Address(
                        "samoungali road",
                        "mp_5566",
                        "Quetta",
                        "8" + "7300"
                )
        );

        System.out.println(p2);
        System.out.println();


        /*  Lab Task No 2 ===================== */
        // Working with Employee and Date classes
        System.out.println("Lab3 task No 2");

        Date khanDob = new Date(10, 3, 1975);
        Date khanDoj = new Date(31, 2, 2001);

        Employee khan = new Employee("kakar", khanDob, khanDoj);

        System.out.println("Joined within last 5 years: "
                + khan.joinedWithinLastFiveYears());
        System.out.println("Age less than 40: "
                + khan.isYoungerThan40());

        System.out.println();


        /* Lab Task No 3 ===================== */
        // Taking input for Book and AudioCassette
        System.out.println("Lab3 task No 3");

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter details for Book:");
        Book book = new Book();
        book.getdata(sc);
        book.putdata();

        System.out.println("\nEnter details for Tape:");
        AudioCassette tape = new AudioCassette();
        tape.getdata(sc);
        tape.putdata();


        /* Lab Task No 4 ===================== */
        // Student data input and display
        System.out.println();
        System.out.println("Lab3 task No 4");

        Student s1 = new Student();
        s1.getdata(sc);
        s1.display();


        /* Lab Task No 5 ===================== */
        // Displaying Laptop details
        System.out.println();
        System.out.println("Lab task No 5");

        Laptop defaultLaptop = new Laptop();
        defaultLaptop.display();

        System.out.println();

        Laptop myLaptop = new Laptop(
                75, 1800027, 500027728, 600000,
                40.45, 29.67, 4.0, 2.56
        );
        myLaptop.display();


        /* Home Task No 1 ===================== */
        // Student test result processing
        System.out.println();
        System.out.println("Home task No 1");

        Test t = new Test();
        t.getdata();
        t.getmarks();
        t.Finalresult();

        System.out.println("\n--- Student Result ---");
        t.putdata();
        t.putmarks();


        /*  Home Task No 2 ===================== */
        System.out.println();
        System.out.println("Home task No 2:");

        Simple s = new Simple(14, 8);
        s.add();
        s.sub();
        s.mul();
        s.div();

        System.out.println();

        Complex c1 = new Complex(20, 6);
        c1.add();
        c1.sub();
        c1.mul();
        c1.div();

        System.out.println();

        Complex c2 = new Complex(-8, 12);
        c2.add();
        c2.sub();
        c2.mul();
        c2.div();


        /*  Home Task No 3 ===================== */
        // Calculating electricity bill
        System.out.println();
        System.out.println("Home task No 3:");

        More_Electricity electricity = new More_Electricity(450);
        System.out.println("Total Bill = Rs. " + electricity.Bill());


        /*  Home Task No 4 ===================== */
        // Package cost calculation
        System.out.println();
        System.out.println();
        System.out.println("Home task No 4:");

        Package normal = new Package(
                "Sufyan", "Street 1", "Lahore", "Punjab", "54000",
                "Zain", "Street 2", "Karachi", "Sindh", "74000",
                12, 5
        );

        TwoDayPackage twoDay = new TwoDayPackage(
                "Sufyan", "Street 1", "Lahore", "Punjab", "54000",
                "Zain", "Street 2", "Karachi", "Sindh", "74000",
                12, 5, 20
        );

        OvernightPackage overnight = new OvernightPackage(
                "Sufyan", "Street 1", "Lahore", "Punjab", "54000",
                "Zain", "Street 2", "Karachi", "Sindh", "74000",
                12, 5, 2
        );

        System.out.println("Normal Package Cost: " + normal.calculateCost());
        System.out.println("Two Day Package Cost: " + twoDay.calculateCost());
        System.out.println("Overnight Package Cost: " + overnight.calculateCost());

        // Closing scanner
        sc.close();
    }
}
