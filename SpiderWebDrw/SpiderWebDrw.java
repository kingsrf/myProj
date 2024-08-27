import java.awt.*;

/**
 * Draws a spider web pattern with two options:
 * 1. Static spider web drawing.
 * 2. Spider web drawing with color interpolation for extra credit.
 * 
 * @ author King Sambonge
 * @ version Proj02 - 04/16/2024
 */

public class SpiderWebDrw {
    public static final int PANEL_WIDTH = 400;
    public static final int PANEL_HEIGHT = 400;

    public static final int INCREMENT = 8;
    public static final int X_OFFSET = PANEL_WIDTH / 2;
    public static final int Y_OFFSET = PANEL_HEIGHT / 2;
    
    // Define starting and ending colors for extra credit
    public static final Color START_COLOR = new Color(3, 160, 98); // Matrix Green
    public static final Color END_COLOR = new Color(224, 255, 102); // Matrix Yellow

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
        panel.setBackground(Color.BLACK);
        Graphics gPanel = panel.getGraphics();
        
        // Choose which drawing to perform
        drawSpiderWeb(gPanel); // Original drawing
        //drawSpiderWebWithColorInterpolation(gPanel);
    }
    
    /**
     * Draws a spider web pattern using a static color.
     *
     * @param gPanel The Graphics object to draw on.
     */
    public static void drawSpiderWeb(Graphics gPanel) {
        // Matrix Green
        Color graphicColor = new Color(3, 160, 98);
        
        // Sets the color of the graphics object
        gPanel.setColor(graphicColor);
        
        // To calculate the diagonal distance
        for (int i = 0; i <= Math.min(X_OFFSET, Y_OFFSET); i += INCREMENT) {
            int cornerOffset = (int) Math.round((Math.sqrt((i * i) * 0.5)));
            
            // Draws lines with the custom color
            gPanel.drawLine(X_OFFSET, i, X_OFFSET + cornerOffset, Y_OFFSET - cornerOffset);
            gPanel.drawLine(i, Y_OFFSET, X_OFFSET - cornerOffset, Y_OFFSET + cornerOffset);
            gPanel.drawLine(PANEL_WIDTH - i, Y_OFFSET, X_OFFSET + cornerOffset, Y_OFFSET - cornerOffset);
            gPanel.drawLine(X_OFFSET, PANEL_HEIGHT - i, X_OFFSET - cornerOffset, Y_OFFSET + cornerOffset);
            gPanel.drawLine(X_OFFSET + cornerOffset, Y_OFFSET + cornerOffset, PANEL_WIDTH - i, Y_OFFSET);
            gPanel.drawLine(X_OFFSET + cornerOffset, Y_OFFSET + cornerOffset, X_OFFSET, PANEL_HEIGHT - i);
            gPanel.drawLine(i, Y_OFFSET, X_OFFSET - cornerOffset, Y_OFFSET - cornerOffset);
            gPanel.drawLine(X_OFFSET, i, X_OFFSET - cornerOffset, Y_OFFSET - cornerOffset);
        }
    }

    /**
     * Draws a spider web pattern with color interpolation for extra credit.
     *
     * @param gPanel The Graphics object to draw on.
     */
    public static void drawSpiderWebWithColorInterpolation(Graphics gPanel) {
        // To calculate the diagonal distance
        for (int i = 0; i <= Math.min(X_OFFSET, Y_OFFSET); i += INCREMENT) {
            int cornerOffset = (int) Math.round((Math.sqrt((i * i) * 0.5)));
            
            // Interpolate color between Starting color and Ending color
            float ratio = (float) i / Math.min(X_OFFSET, Y_OFFSET);
            int red = (int) (START_COLOR.getRed() * (1 - ratio) + END_COLOR.getRed() * ratio);
            int green = (int) (START_COLOR.getGreen() * (1 - ratio) + END_COLOR.getGreen() * ratio);
            int blue = (int) (START_COLOR.getBlue() * (1 - ratio) + END_COLOR.getBlue() * ratio);
            Color graphicColor = new Color(red, green, blue);
            
            // Sets the color of the graphics object
            gPanel.setColor(graphicColor);
            
            // Draws lines with the custom color
            gPanel.drawLine(X_OFFSET, i, X_OFFSET + cornerOffset, Y_OFFSET - cornerOffset);
            gPanel.drawLine(i, Y_OFFSET, X_OFFSET - cornerOffset, Y_OFFSET + cornerOffset);
            gPanel.drawLine(PANEL_WIDTH - i, Y_OFFSET, X_OFFSET + cornerOffset, Y_OFFSET - cornerOffset);
            gPanel.drawLine(X_OFFSET, PANEL_HEIGHT - i, X_OFFSET - cornerOffset, Y_OFFSET + cornerOffset);
            gPanel.drawLine(X_OFFSET + cornerOffset, Y_OFFSET + cornerOffset, PANEL_WIDTH - i, Y_OFFSET);
            gPanel.drawLine(X_OFFSET + cornerOffset, Y_OFFSET + cornerOffset, X_OFFSET, PANEL_HEIGHT - i);
            gPanel.drawLine(i, Y_OFFSET, X_OFFSET - cornerOffset, Y_OFFSET - cornerOffset);
            gPanel.drawLine(X_OFFSET, i, X_OFFSET - cornerOffset, Y_OFFSET - cornerOffset);
        }
    }
}
