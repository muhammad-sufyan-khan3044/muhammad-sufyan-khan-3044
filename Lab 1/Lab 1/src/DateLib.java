import java.util.Date;

public class DateLib {
    public static void main(String[] args) {
        long[] times = {
                10000L,
                100000L,
                1000000L,
                10000000L,
                100000000L,
                1000000000L,
                10000000000L,
                100000000000L
        };

        for (long t : times) {
            Date date = new Date(t); // create Date with elapsed time
            System.out.println("Elapsed time: " + t + " -> " + date.toString());
        }
    }
}