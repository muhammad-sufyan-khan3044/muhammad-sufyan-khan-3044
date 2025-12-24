public class Laptop extends Computer{
    private double length;
    private double width;
    private double height;
    private double weight;

    public Laptop() {
        this.length = 0;
        this.width = 0;
        this.height = 0;
        this.weight = 0;
    }

    public Laptop (int wordSize, int memorySize, int storageSize, int speed, double length, double width, double height, double weight) {
        super(wordSize, memorySize, storageSize, speed);
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    // Display function
    @Override
    public void display() {
        super.display(); // Display Computer specs
        System.out.println("Laptop Dimensions:");
        System.out.println("Length: " + length + " cm");
        System.out.println("Width: " + width + " cm");
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
    }



}

