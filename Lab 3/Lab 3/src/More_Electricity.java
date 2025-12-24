class More_Electricity extends Electricity {

    public More_Electricity(int u) {
        super(u);
    }

    @Override
    public double Bill() {
        double cost = super.Bill();

        if (cost > 250) {
            double extra = cost - 250;
            cost = cost + (extra * 0.15);
        }

        setCost(cost);
        return getCost();
    }
}
