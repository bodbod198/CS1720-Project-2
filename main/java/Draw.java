import edu.cymbal.graphics.PainterAPI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

// draws plants/rocks from Generate.java - along with fish
public class Draw {

    private static final PainterAPI painter = Aquarium.painter;
    private static final ArrayList<Double> positions = new ArrayList<>();

    private static double currentAngle = 0;
    public double getCurrentAngle() {
        return currentAngle;
    }
    private static void resetAngle() {
        if (currentAngle > 0) {
            painter.turnRight(currentAngle);
        } else {
            painter.turnLeft(currentAngle);
        }
        currentAngle = 0;
    }


    private static void turnLeft(double angle) {
        painter.turnLeft(angle);
        currentAngle += angle;
    }
    private static void turnRight(double angle) {
        painter.turnRight(angle);
        currentAngle -= angle;
    }


    private static void positionsAdd() {
        positions.add(painter.getX());
        positions.add(painter.getY());
        positions.add(currentAngle);
    }
    private static void positionsRemove() {
        painter.liftPen();
        // ... x, y, angle
        positions.removeLast();
        // ... angle, x, y
        painter.moveTo(painter.getX(), positions.getLast());
        positions.removeLast();
        // ... y, angle, x
        painter.moveTo(positions.getLast(), painter.getY());
        positions.removeLast();
        // ... x, y, angle
        if (positions.getLast() - currentAngle > 0) {
            turnLeft(positions.getLast() - currentAngle);
        } else {
            // 'Math.abs' isn't necessary if you change this to 'painter.turnLeft'
            turnRight(Math.abs(positions.getLast() - currentAngle));
        }
        // sets 'currentAngle' to be returned
        currentAngle = positions.getLast();
        painter.lowerPen();
    }
    private static void initializePainter(int xPos, int yPos, Color color) {
        painter.liftPen();
        painter.moveTo(xPos, yPos);
        painter.setPenColor(color);
        painter.lowerPen();
        positionsAdd();
    }

    public static void drawPlant(int iterations) {
        // initializes vars
        int xPos = -400;
        int yPos = -360;
        double angle = 0;
        double branchLength = 0;
        char drawLetter = ' ';

        // generates plant strings
        // always gives 3 elements!!!
        String[] plants = Generate.generatePlants(iterations);
        System.out.println(Arrays.toString(plants));
        // draws 'plants' one by one, starting from [0]
        for (int i = 0; i < plants.length; i++) {
            String current = plants[i];
            System.out.println(plants[i]);
            // ensures currentAngle is always 0 when drawing a new plant
            resetAngle();
            // iterates through the string given by 'generatePlants' and draws the result
            if (current.charAt(0) == 'a' || current.charAt(1) == 'a') {
                angle = 17;
                branchLength = 3;
                drawLetter = 'a';
                // puts painter in correct position with desired penColor
                initializePainter(xPos, yPos, new Color(1, 50, 32));

            } else if (current.charAt(0) == 'b' || current.charAt(1) == 'b') {
                angle = 23;
                branchLength = 3;
                drawLetter = 'b';
                // puts painter in correct position with desired penColor
                initializePainter(xPos, yPos, new Color(165, 42, 42));

            } else if (current.charAt(0) == 'c' || current.charAt(1) == 'c') {
                angle = 27;
                branchLength = 4;
                drawLetter = 'c';
                // puts painter in correct position with desired penColor
                initializePainter(xPos, yPos, new Color(132, 89, 126));
            }

            // the actual drawing logic
            for (char character : current.toCharArray()) {
                if (character == '-') {
                    turnRight(angle);
                } else if (character == '+') {
                    turnLeft(angle);
                } else if (character == '[') {
                    positionsAdd();
                } else if (character == ']') {
                    positionsRemove();
                } else if (character == drawLetter) {
                    painter.forward(branchLength);
                }
            }
            // for next plant placement
            xPos += 400;
            positions.clear();
        }
        drawFish(200, 250);
    }

    public static void drawFish(int x, int y) {
        initializePainter(x, y, new Color(28, 128, 128));
        painter.circle(30);
        painter.liftPen();
        painter.moveTo((x - 60), (y - 10));
        painter.lowerPen();
        resetAngle();
        turnLeft(45);
        painter.forward(40);
        turnLeft(135);
        painter.forward(40);
        turnLeft(135);
        painter.forward(40);

    }

    public static void drawBubbles() {

        // painter.liftPen();
        // painter.moveTo(0, 0);
        // painter.lowerPen();
        // draws stuff here
    }


    public static void drawStarFish() {
        // draws a starfish
        // painter.liftPen();
        // painter.moveTo(placeholder, placeholder);
        // painter.lowerPen();
        // draws stuff here
    }

}
