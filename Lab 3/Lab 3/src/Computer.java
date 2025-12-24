public class Computer {
    private int wordsize;
    private int memorysize;
    private int storagesize;
    private int speed;

    public Computer() {
        this.wordsize = 0;
        this.memorysize = 0;
        this.storagesize = 0;
        this.speed = 0;
    }

    public Computer(int wordsize, int memorysize, int storagesize, int speed) {
        this.wordsize = wordsize;
        this.memorysize = memorysize;
        this.storagesize = storagesize;
        this.speed = speed;
    }
    // Display function
    public void display() {
        System.out.println("Computer Specifications:");
        System.out.println("Word Size: " + wordsize + " bits");
        System.out.println("Memory Size: " + memorysize + " MB");
        System.out.println("Storage Size: " + storagesize + " MB");
        System.out.println("Speed: " + speed + " MHz");
    }

}
