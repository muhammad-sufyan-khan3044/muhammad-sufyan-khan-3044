class Electricity {
    private int units;
    private double cost;

    Electricity(int u) {
        units = u;
    }

    public int getUnits() {
        return units;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double c) {
        cost = c;
    }

    public double Bill() {
        if (units <= 100) {
            cost = units * 0.50;
        } else {
            cost = (100 * 0.50) + ((units - 100) * 0.60);
        }
        return cost;
    }
}
