import edu.cymbal.graphics.PainterAPI;

import java.util.ArrayList;


public class Draw {
    /**
     * @param initial Initial sequence
     * // @param lSystem For every occurrence of axiom & rule - axiom first, then rule (index 0 = axiom, index 1 = rule, ...)
     *                Starting at index 0, all axioms are at an even index - 0, 2, 4, 6, ...
     *                Starting at index 1, all rules are at an odd index - 1, 3, 5, 7, ...
     *
     * @param time Number of iteration steps
     */
    // ArrayList<String> lSystem
    public static String generatePlant(String initial, int time) {
        //String current = "-x";

        for (int i = 0; i < time; i++) {
            // the linter kept telling me to use StringBuilder
            StringBuilder newInstructions = new StringBuilder();
            for (char character : initial.toCharArray()) {
                if (character == 'x') {
                    newInstructions.append("f+[[x]-x]-f[-fx]+x");

                } else if (character == 'f') {
                    newInstructions.append("ff");
                } else {
                    newInstructions.append(character);
                }
            }
            //current = newInstructions;
            initial = newInstructions.toString();
            //System.out.println(output);
        }
        //return current;

        return initial;
    }

    public static double drawPlant(double currentAngle, double branchLength, int time, double xPos1, double yPos1, PainterAPI painter) {
        /* vars: xf
        f = draw forward
        - = turn right 25 degrees
        + = turn left 25 degrees
        x = nothing
        [ = save current pos and angle
        ] = position and angle reset
        every [ comes before ]
        constants: x - []
        start: -x
        rules: (x -> f+[[x]-x]-f[-fx]+x), (f -> ff) */
        painter.liftPen();
        painter.moveTo(xPos1, yPos1);
        painter.lowerPen();
        ArrayList<Integer> positions = new ArrayList<>();
        positions.add((int) painter.getX());
        positions.add((int) painter.getY());
        positions.add((int) currentAngle);
        String initial = "-x";
        String current = generatePlant(initial, time);
        ArrayList<String> test = new ArrayList<>();
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
                // x, y, angle
                positions.removeLast();
                // angle, x, y
                painter.liftPen();
                painter.moveTo(painter.getX(), positions.getLast());
                positions.removeLast();
                // y, angle, x
                painter.moveTo(positions.getLast(), painter.getY());
                positions.removeLast();
                // x, y, angle
                if (positions.getLast() - currentAngle > 0) {
                    painter.turnLeft(positions.getLast() - currentAngle);
                } else {
                    painter.turnRight(Math.abs(positions.getLast() - currentAngle));
                }
                currentAngle = positions.getLast();
                painter.lowerPen();
                //System.out.println(positions);
            } else if (character == 'f') {
                painter.forward(branchLength);
            }
        }
        return currentAngle;
    }
}
