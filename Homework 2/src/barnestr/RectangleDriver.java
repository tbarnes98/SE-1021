package barnestr;

public class RectangleDriver {
    public static void main(String[] args) {
        Point p1 = new Point(-3.0,1.0);
        Point p2 = new Point(3.0,-1.0);
        Rectangle rectangle = new Rectangle(p1,p2);
        rectangle.printCenter();
        rectangle.shiftUp(1.0);
        rectangle.shiftRight(1.0);
        rectangle.printCenter();
    }
}

