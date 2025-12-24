// Class that imitates int
public class Int {
    private int value; // only data member

    // Default constructor (initialize to zero)
    public Int() {
        value = 0;
    }
    // Parameterized constructor (initialize to a specific value)
    public Int(int value) {
        this.value = value;
    }

    // Method to set the value
    public void setValue(int value) {
        this.value = value;
    }

    // Method to display the value
    public void display() {
        System.out.println("Value: " + value);
    }
}
