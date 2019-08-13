package barnestr;

public interface Commission {
    static final double COMMISSION_RATE = 0.10;

    public abstract void addSales(double sales);
}
