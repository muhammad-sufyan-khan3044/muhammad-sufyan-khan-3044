class TwoDayPackage extends Package {

    private double flatFee;

    public TwoDayPackage(String sName, String sAddress, String sCity, String sState, String sZip,
                         String rName, String rAddress, String rCity, String rState, String rZip,
                         double weight, double costPerOunce, double flatFee) {

        super(sName, sAddress, sCity, sState, sZip,
                rName, rAddress, rCity, rState, rZip,
                weight, costPerOunce);

        this.flatFee = flatFee;
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + flatFee;
    }
}
