import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class for performing sine calculations and estimating the area under a sine curve.
 */
public class SineCalc {

    /**
     * Calculates the sine value (y) for a given x in radians.
     * 
     * @param x The x-value in radians.
     * @return The sine of x.
     */
    public static double findYvalue(double x) {
        return Math.sin(x);
    }

    /**
     * Estimates the area under the sine curve from 0 to π using the midpoint rectangle method.
     * 
     * @param numRect The number of rectangles to use for the estimation.
     * @return The estimated area under the sine curve from 0 to π.
     */
    public static double calcArea(int numRect) {
        if (numRect <= 0) {
            throw new IllegalArgumentException("Number of rectangles must be greater than zero.");
        }

        double totalArea = 0.0;
        double width = Math.PI / numRect;

        for (int rectIdx = 0; rectIdx < numRect; rectIdx++) {
            double xMidpoint = width * (rectIdx + 0.5); 
            double yValue = Math.sin(xMidpoint);     
            double areaRect = yValue * width;          
            totalArea += areaRect;                     
        }

        return roundToDecimal(totalArea, 4);
    }

    /**
     * Rounds a given value to a specified number of decimal places.
     * 
     * @param value The value to be rounded.
     * @param decimalPlaces The number of decimal places to round to.
     * @return The rounded value.
     */
    private static double roundToDecimal(double value, int decimalPlaces) {
        if (decimalPlaces < 0) {
            throw new IllegalArgumentException("Decimal places must be non-negative.");
        }

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
