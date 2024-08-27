import java.awt.*;

/**
 * Utility class for drawing sine waves and their corresponding area estimation rectangles.
 */
public class SineDraw {

    private static final int SCALE_FACTOR = 100;
    private static final int PANEL_HEIGHT = 200;

    /**
     * Draws a sine wave with rectangular approximations for area estimation.
     *
     * @param graphic The Graphics object used to draw.
     * @param numRectangles The number of rectangles to draw for area estimation.
     * @param panel The drawing panel.
     * @param rectangleColor The color of the rectangles.
     */
    public static void drawWave(Graphics graphic, int numRectangles, DrawingPanel panel, Color rectangleColor) {
        graphic.setColor(rectangleColor);
        
        drawRectangles(graphic, numRectangles);

        graphic.setColor(Color.BLUE);

        drawSineCurve(graphic);
    }

    /**
     * Draws the sine curve on the given Graphics context.
     *
     * @param graphic The Graphics object used to draw.
     */
    private static void drawSineCurve(Graphics graphic) {
        for (int angle = 0; angle <= 314; angle++) {
            double x1 = angle / 100.0;
            double x2 = (angle + 1) / 100.0;

            double y1 = Math.sin(x1);
            double y2 = Math.sin(x2);

            int xPanel1 = cartesianXToGraphicX(x1);
            int yPanel1 = cartesianYToGraphicY(y1);
            int xPanel2 = cartesianXToGraphicX(x2);
            int yPanel2 = cartesianYToGraphicY(y2);
            
            // Draw the line segment of the sine curve
            graphic.drawLine(xPanel1, PANEL_HEIGHT / 2 - yPanel1, xPanel2, PANEL_HEIGHT / 2 - yPanel2);
        }
    }

    /**
     * Draws rectangles under the sine curve to estimate the area.
     *
     * @param graphic The Graphics object used to draw.
     * @param numRectangles The number of rectangles to draw.
     */
    private static void drawRectangles(Graphics graphic, int numRectangles) {
        double rectWidth = Math.PI / numRectangles; // Width of each rectangle

        for (int rectIdx = 0; rectIdx < numRectangles; rectIdx++) {
            double leftX = rectIdx * rectWidth;
            double rightX = rectWidth * (rectIdx + 1);
            double midX = (leftX + rightX) / 2;
            double rectHeight = Math.sin(midX);

            int xRect = cartesianXToGraphicX(leftX);
            int yRect = cartesianYToGraphicY(rectHeight);

            int width = (int) (rectWidth * SCALE_FACTOR);
            int height = (int) (rectHeight * SCALE_FACTOR);
            
            // Draw the rectangle
            graphic.drawRect(xRect, PANEL_HEIGHT / 2 - yRect, width, height);
        }
    }

    /**
     * Converts a Cartesian X coordinate to a graphical X coordinate.
     *
     * @param x The Cartesian X coordinate.
     * @return The graphical X coordinate.
     */
    public static int cartesianXToGraphicX(double x) {
        return (int) Math.round(x * SCALE_FACTOR);
    }

    /**
     * Converts a Cartesian Y coordinate to a graphical Y coordinate.
     *
     * @param y The Cartesian Y coordinate.
     * @return The graphical Y coordinate.
     */
    public static int cartesianYToGraphicY(double y) {
        return (int) Math.round(y * SCALE_FACTOR);
    }
}
