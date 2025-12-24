import java.util.Scanner;

public class AudioCassette extends Publication {
    private int playingTime;

    @Override
    public void getdata(Scanner sc) {
        super.getdata(sc); // get title and price
        System.out.print("Enter playing time (minutes): ");
        playingTime = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void putdata() {
        super.putdata(); // display title and price
        System.out.println("Playing Time (minutes): " + playingTime);
    }
}
