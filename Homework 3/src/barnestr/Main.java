package barnestr;

import java.text.DecimalFormat;

public class Main {

    private final DecimalFormat decimalFormat = new DecimalFormat();
    private double testNum = 10.0/6.0;

    public static void main(String[] args) {




    }
    public String test() {
       return decimalFormat.format(testNum);
    }
}
