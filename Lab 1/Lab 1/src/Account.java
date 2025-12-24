public class Account {
    private int id;
    private double balance;
    private double annualInterestRate = 4.5;
    private Date dateCreated;
    private double MonthlyInterestRate;

    public Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
    }

    public Account(int id, double balance, Date dateCreated){
        this.id = id;
        this.balance = balance;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        dateCreated.dispalydate();
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getMonthlyInterestRate(){
        this.MonthlyInterestRate = annualInterestRate / 12;
        return MonthlyInterestRate;
    }

    public double getMonthlyInterest(){
        double MonthlyInterest = (this.annualInterestRate / 100) / 12 * this.balance;
        return MonthlyInterest;
    }


    public void withdraw(double amount){
        balance = this.balance - amount;
        System.out.println("The amount has successfully withdraw: " + amount);
        System.out.println("Remaining Balance is: " + balance);
    }

    public void deposit(double amount){
        balance = this.balance + amount;
        System.out.println("The amount has successfully Deposit: " + amount);
        System.out.println("Remaining Balance is: " + balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID: = " + id +
                ", Balance: = " + balance +
                ", Annual Interest Rate: = " + annualInterestRate +
                ", Monthly Interest Rate: = " + getMonthlyInterestRate() +
                ", Monthly Interest: = " + getMonthlyInterest() +
                ", Date Created: = " + dateCreated +
                '}';
    }
}
