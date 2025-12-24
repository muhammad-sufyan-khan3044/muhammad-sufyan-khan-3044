public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol, String name, double previousClosingPrice, double currentPrice){
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = previousClosingPrice;
        this.currentPrice = currentPrice;
    }

    public double getChangePercent(){
        double ChangePercent = (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
        System.out.println("Company info: " + "Symbol: " + this.symbol + "\n" + "Name: " + this.name);
        System.out.println("The Change Percent is: " + ChangePercent);
        return ChangePercent;
    }


}
