import java.util.Scanner;
public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Hour");
        this.hours = input.nextInt();
        System.out.println("Enter Minute");
        this.minutes = input.nextInt();
        System.out.println("Enter Second");
        this.seconds = input.nextInt();
    }
    // Method to display time in 24-hour format
    public void display24Hour() {
        System.out.println("This is 24 Hour Format");
        System.out.printf("24-Hour Format: %02d:%02d:%02d\n", hours, minutes, seconds);
    }

    // Method to display time in 12-hour format
    public void display12Hour() {
        String period = "AM";
        int displayHour = hours;

        if (hours == 0) {
            displayHour = 12;
        } else if (hours == 12) {
            period = "PM";
        } else if (hours > 12) {
            displayHour = hours - 12;
            period = "PM";
        }
        System.out.println("This is 12 Hour Format");
        System.out.printf("12-Hour Format: %02d:%02d:%02d %s\n", displayHour, minutes, seconds, period);
    }
}