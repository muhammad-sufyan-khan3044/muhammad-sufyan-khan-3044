//Lab Tasks
public class CounterClass {
    private static int count;
    public CounterClass(){
        count++;
        System.out.println("I am Object no____" + count);
    }
    public static int getCount(){
        return count;
    }
}
