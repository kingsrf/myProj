
/**
 * Console-based Plotting Program
 *
 * @author King Sambonge
 * @version Proj01 - 04/09/2024
 */

public class SidePlot {
    public static final String PLOT_CHAR = "*";

    public static void plotLine(int minX, int maxX, int y) {
        StringBuilder plotLine = new StringBuilder();
        for (int i = 0; i < y; i++) {
            plotLine.append(" ");
        }
        plotLine.append(PLOT_CHAR); // Append the plot character at the end
        System.out.println(plotLine.toString()); // Print the plot line
    }

    public static void plotXSquared(int minX, int maxX) {
        for (int x = minX; x <= maxX; x++) {
            int y = x * x; // Calculate the y-value for the current x
            plotLine(minX, maxX, y);
        }
    }
    
    public static void plotAbsXPlus1(int minX, int maxX) {
        for (int x = minX; x <= maxX; x++) {
            int y = Math.abs(x) + 1; // Calculate the y-value for the current x
            plotLine(minX, maxX, y);
        }
    }

    public static void plotNegXSquaredPlus20(int minX, int maxX) {
        for (int x = minX; x <= maxX; x++) {
            int y = -(x * x) + 20; // Calculate the y-value for the current x
            plotLine(minX, maxX, y);
        }
    }

    public static void plotSinWave(int minX, int maxX) {
        for (int x = minX; x <= maxX; x++){
            int y = (int) (20 * Math.sin(0.5 * x) + 20); // Calculate the y-value for the current x
            plotLine(minX, maxX, y);
        }
    }

    public static void main(String[] args) {
        System.out.println("Sideways Plot\ny = x*x where -6<=x<=6");
        plotXSquared(-6, 6);
        
        System.out.println("\nSideways Plot\ny = |x|+1, where -5<=x<=5");
        plotAbsXPlus1(-5, 5);

        System.out.println("\nSideways Plot\ny = -(x*x)+ 20 where -4<=x<=4");
        plotNegXSquaredPlus20(-4, 4);

        System.out.println("\nSideways Plot\ny = 20sin(.5x)+20 where -9<=x<=9");
        plotSinWave(-9, 9);
    }
}
