public class Rectangle {
    private double width;
    private double height;

    public Rectangle(){
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        double Area = width * height;
        System.out.println("The Area of the Rectangle is: " + Area);
        return Area;
    }

    public double getPerimeter(){
        double Perimeter = 2 * (width + height);
        System.out.println("The Perimeter of the Rectangle is: " + Perimeter);
        return Perimeter;
    }
}

