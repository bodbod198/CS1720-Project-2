import edu.cymbal.graphics.PainterAPI;

import java.util.ArrayList;

/* TODO: determine if methods need to return 'currentAngle'
 *       - it might be best to have every draw method return the 'painter'
 *           to a certain angle
 *           turnLeft(90) from the original +x axis to the +y axis
 */

// draws plants/rocks from Generate.java - along with fish
public class Draw {

    /**
     * @param currentAngle current orientation of {@code painter}
     * @param branchLength desired length of each branch
     * @param time number of iterations/steps passed to {@link Generate#generatePlant}
     * @param xPos1 desired starting x position
     * @param yPos1 desired starting y position
     * @param painter a {@link PainterAPI} object
     * @return the new {@code currentAngle} of {@code painter}
     */
    public static double drawPlant(double currentAngle, double branchLength, int time, double xPos1,
                                   double yPos1, PainterAPI painter) {

        // TODO: make it better
        // moves painter into correct position
        painter.liftPen();
        painter.moveTo(xPos1, yPos1);
        painter.lowerPen();

        // creates and adds initial values to the array
        ArrayList<Integer> positions = new ArrayList<>();
        positions.add((int) painter.getX());
        positions.add((int) painter.getY());
        positions.add((int) currentAngle);

        // TODO: remove placeholders
        // placeholder for 'generatePlant'
        String initial = "-x";
        // generates plant
        String current = Generate.generatePlant(initial, time);

        // iterates through the string given by 'generatePlant' and draws the result
        for (char character : current.toCharArray()) {
            if (character == '-') {
                painter.turnRight(25);
                currentAngle -= 25;
            } else if (character == '+') {
                painter.turnLeft(25);
                currentAngle += 25;
            } else if (character == '[') {
                positions.add((int) painter.getX());
                positions.add((int) painter.getY());
                positions.add((int) currentAngle);
            } else if (character == ']') {
                // 'positions'
                // ... x, y, angle
                positions.removeLast();
                // ... angle, x, y
                painter.liftPen();
                painter.moveTo(painter.getX(), positions.getLast());
                positions.removeLast();
                // ... y, angle, x
                painter.moveTo(positions.getLast(), painter.getY());
                positions.removeLast();
                // ... x, y, angle

                if (positions.getLast() - currentAngle > 0) {
                    painter.turnLeft(positions.getLast() - currentAngle);
                } else {
                    // 'Math.abs' isn't necessary if you change this to 'painter.turnLeft'
                    painter.turnRight(Math.abs(positions.getLast() - currentAngle));
                }
                // sets 'currentAngle' to be returned
                currentAngle = positions.getLast();
                painter.lowerPen();
            } else if (character == 'f') {
                painter.forward(branchLength);
            }
        }
        return currentAngle;
    }

    /**
     *
     * @param currentAngle current angle of the painter
     * @param time for animation
     * @param painter painter object
     * @return the new current angle of 'painter'
     */
    public static double drawRocks(double currentAngle, int time, PainterAPI painter) {
        // draws rocks
        // painter.liftPen();
        // painter.moveTo(0, 0);
        // painter.lowerPen();
        // draws stuff here
        return 0.0;
    }

    /**
     *
     * @param currentAngle current angle of the painter
     * @param time for animation
     * @param painter painter object
     * @return the new current angle of 'painter'
     */
    public static double drawFish(double currentAngle, int time, PainterAPI painter) {
        // draws fish
        // painter.liftPen();
        // painter.moveTo(placeholder, placeholder);
        // painter.lowerPen();
        // draws stuff here
        return 0.0;
    }

    /**
     *
     * @param currentAngle current angle of the painter
     * @param time for animation
     * @param painter painter object
     * @return the new current angle of 'painter'
     */
    public static double drawBubbles(double currentAngle, int time, PainterAPI painter) {
        // draws fish
        // painter.liftPen();
        // painter.moveTo(0, 0);
        // painter.lowerPen();
        // draws stuff here
        return 0.0;
    }

    /**
     *
     * @param currentAngle current angle of the 'painter'
     * @param time for animation
     * @param painter painter object
     * @return the new current angle of 'painter'
     */
    public static double drawStarFish(double currentAngle, int time, PainterAPI painter) {
        // draws a starfish
        // painter.liftPen();
        // painter.moveTo(placeholder, placeholder);
        // painter.lowerPen();
        // draws stuff here
        return 0.0;
    }
}
