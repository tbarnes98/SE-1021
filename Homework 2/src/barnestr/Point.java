package barnestr;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double shiftRight(double shiftAmount) {
        x += shiftAmount;
        return shiftAmount;
    }
    public double shiftUp(double shiftAmount) {
        y += shiftAmount;
        return shiftAmount;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
