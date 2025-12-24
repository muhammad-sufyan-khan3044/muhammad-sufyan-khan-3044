public class Marks {
    private int English;
    private int Maths;
    private int Urdu;

    public Marks(int English, int Maths, int Urdu){
        this.English = English;
        this.Maths = Maths;
        this.Urdu = Urdu;
    }

    public void setEnglish(int English){
        this.English = English;
    }

    public int getEnglish(){
        return English;
    }

    public void setMaths(int Maths){
        this.Maths = Maths;
    }

    public int getMaths(){
        return Maths;
    }

    public void setUrdu(int Urdu){
        this.Urdu = Urdu;
    }

    public int getUrdu(){
        return Urdu;
    }

    public void sum(){
        System.out.println("English No: = " + this.English + "\n" + "Urdu No: = " + this.Urdu + "\n" + "Maths No: = " + this.Maths);
        int sum = this.English + this.Maths + this.Urdu;
        System.out.println("The sum of All the Subjects is: " + sum);

    }
    public void average(){
        System.out.println("English No: = " + this.English + "\n" + "Urdu No: = " + this.Urdu + "\n" + "Maths No: = " + this.Maths);
        double average = (double) (this.English + this.Maths + this.Urdu) / 3;
        System.out.println("The Average of All the Subjects is: " + average);
    }
}
