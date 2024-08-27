import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/** 
 * User interface for interacting with mathematical sine wave calculations 
 * and visualizations. It allows users to perform operations related to the sine function, 
 * such as finding the y-value for a given x-value in radians, 
 * estimating the area under the sine curve, 
 * and drawing the sine curve with rectangular approximations.
 * 
 * @author King Sambonge
 * @version SineUI - 04/30/2024
 **/
public class SineUI {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int userChoice;
        do {
            displayMenu();
            userChoice = getUserInput();
            processMenuChoice(userChoice);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("An error occurred while pausing the program.");
                Thread.currentThread().interrupt(); // Reset the interrupted status
            }
        } while (userChoice != 0);
        
        System.out.println("Program exited.");
    }

    /**
     * Displays the main menu to the user.
     */
    private static void displayMenu() {
        System.out.println("\n" + "-".repeat(50) + "\nSine Wave Menu\n" + "-".repeat(50) + "\n");
        System.out.println("1. Find y value for specified radians x");
        System.out.println("2. Estimate area for 0 <= x <= PI");
        System.out.println("3. Draw curve with area estimation rectangles");
        System.out.println("\n0. EXIT the program");
        System.out.println("\nEnter your choice:");
    }

    /**
     * Processes the user's menu choice.
     * 
     * @param choice the user's choice from the menu
     */
    private static void processMenuChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("EXIT the program");
                break;
            case 1:
                findYValue();
                break;
            case 2:
                estimateArea();
                break;
            case 3:
                drawCurve();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Prompts the user for input and returns a valid choice between 0 and 3.
     * 
     * @return the user's valid input choice
     */
    private static int getUserInput() {
        int userInput = -1;
        while (true) {
            System.out.print("Please enter a number between 0 and 3: ");
            try {
                userInput = scanner.nextInt();
                if (userInput >= 0 && userInput <= 3) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.next(); // Consume the invalid input
            }
        }
        return userInput;
    }

    /**
     * Prompts the user for an x-value in radians and calculates the corresponding y-value.
     */
    private static void findYValue() {
        SineCalc sineCalc = new SineCalc();
        System.out.print("Please enter a radian value for calculating y: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a numerical value for radians.");
            scanner.next(); // Consume the invalid input
        }
        double xValue = scanner.nextDouble();
        double yValue = sineCalc.findYvalue(xValue);
        System.out.printf("The y-value of sin(%.4f) is %.4f%n", xValue, yValue);
    }

    /**
     * Prompts the user to enter the number of rectangles and estimates the area under the sine curve.
     */
    private static void estimateArea() {
        SineCalc sineCalc = new SineCalc();
        int numRect = chooseRectNumber();
        double estimatedArea = sineCalc.calcArea(numRect);
        System.out.printf("The estimated area under the curve of sin(x) from 0 to pi with %d rectangles is %.4f%n", numRect, estimatedArea);
    }

    /**
     * Draws the sine curve and area estimation rectangles on a graphical panel.
     */
    private static void drawCurve() {
        DrawingPanel panel = new DrawingPanel(628, 200);
        Graphics graphic = panel.getGraphics();
        Color rectangleColor = Color.BLACK;
        SineDraw sineDraw = new SineDraw();
        int numRect = chooseRectNumber();
        sineDraw.drawWave(graphic, numRect, panel, rectangleColor);
    }

    /**
     * Prompts the user to choose the number of rectangles for area estimation.
     * 
     * @return the number of rectangles chosen by the user
     */
    private static int chooseRectNumber() {
        int numRect = 0;
        while (true) {
            System.out.print("Please enter a number between 1 and 500 for rectangles: ");
            if (scanner.hasNextInt()) {
                numRect = scanner.nextInt();
                if (numRect >= 1 && numRect <= 500) {
                    break;
                } else {
                    System.out.println("Invalid number. Please enter a number between 1 and 500.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.next(); // Consume the invalid input
            }
        }
        return numRect;
    }
}
