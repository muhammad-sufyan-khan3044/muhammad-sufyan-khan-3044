class OvernightPackage extends Package {

    private double extraFeePerOunce;

    public OvernightPackage(String sName, String sAddress, String sCity, String sState, String sZip,
                            String rName, String rAddress, String rCity, String rState, String rZip,
                            double weight, double costPerOunce, double extraFeePerOunce) {

        super(sName, sAddress, sCity, sState, sZip,
                rName, rAddress, rCity, rState, rZip,
                weight, costPerOunce);

        this.extraFeePerOunce = extraFeePerOunce;
    }

    @Override
    public double calculateCost() {
        return getWeight() * (getCostPerOunce() + extraFeePerOunce);
    }
}
