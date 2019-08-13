package barnestr;

public class Rectangle {
    Point topLeft;
    Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double shiftRight(double shiftAmount) {
        topLeft.x += shiftAmount;
        bottomRight.x += shiftAmount;
        return shiftAmount;
    }

    public double shiftUp(double shiftAmount) {
        topLeft.y += shiftAmount;
        bottomRight.y += shiftAmount;
        return shiftAmount;
    }

    public void printCenter() {
        double centerX = (topLeft.x + bottomRight.x)/2;
        double centerY = (topLeft.y + bottomRight.y)/2;
        System.out.println("x = " + centerX + " y = " + centerY);
    }

}
