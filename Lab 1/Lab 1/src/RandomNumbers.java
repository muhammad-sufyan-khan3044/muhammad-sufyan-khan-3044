import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {
        // Step 1: Create Random object with seed 1000
        Random random = new Random(1000);

        // Step 2: Generate and display 50 random integers between 0 and 99
        for (int i = 0; i < 50; i++) {
            int number = random.nextInt(100);
            System.out.print(number + " ");
        }
    }
}
