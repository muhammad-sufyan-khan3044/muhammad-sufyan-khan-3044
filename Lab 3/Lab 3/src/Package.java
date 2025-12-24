class Package {

    private String senderName;
    private String senderAddress;
    private String senderCity;
    private String senderState;
    private String senderZip;

    private String receiverName;
    private String receiverAddress;
    private String receiverCity;
    private String receiverState;
    private String receiverZip;

    private double weight;
    private double costPerOunce;

    public Package(String sName, String sAddress, String sCity, String sState, String sZip,
                   String rName, String rAddress, String rCity, String rState, String rZip,
                   double weight, double costPerOunce) {

        this.senderName = sName;
        this.senderAddress = sAddress;
        this.senderCity = sCity;
        this.senderState = sState;
        this.senderZip = sZip;

        this.receiverName = rName;
        this.receiverAddress = rAddress;
        this.receiverCity = rCity;
        this.receiverState = rState;
        this.receiverZip = rZip;

        if (weight > 0)
            this.weight = weight;
        else
            this.weight = 1;

        if (costPerOunce > 0)
            this.costPerOunce = costPerOunce;
        else
            this.costPerOunce = 1;
    }

    public double calculateCost() {
        return weight * costPerOunce;
    }

    public double getWeight() {
        return weight;
    }

    public double getCostPerOunce() {
        return costPerOunce;
    }
}
