// Parent class
class Simple {
    protected int num1;
    protected int num2;

    public Simple(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void add() {
        int result = num1 + num2;
        System.out.println("Addition: " + result);
    }

    public void sub() {
        int result = num1 - num2;
        System.out.println("Subtraction: " + result);
    }

    public void mul() {
        int result = num1 * num2;
        System.out.println("Multiplication: " + result);
    }

    public void div() {
        if (num2 != 0) {
            double result = (double) num1 / num2;
            System.out.println("Division: " + result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}
