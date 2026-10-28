import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;


/* FIXME: Add features if there is time
        - make Javadoc comments look good
 *      - add randomness to plants, fish, bubbles
 *          use 'Math.random' to give a chance for a different operation to apply when
 *          generating plants/fish/bubbles - i guess its pseudo-random, not random
 *      - grow the aquarium over time
 *          keep track of time elapsed, and use that to slowly 'grow' the aquarium
 *      - animation
 *          redraw plants, fish, bubbles to appear to move
 *              - plants will 'sway' slightly
 *              - fish go across the screen, hit the edge, and appear on the other side
 *              - bubbles rise up from the bottom, and 'sway' slightly (sine wave maybe?)
 *      - allow different L-System 'grammar' to be used, aka make 'Draw' methods not use
 *        'hardcoded' rules
 */

public class Aquarium {
    public static void main(String[] args) {
        // initialize requirements
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "test");
        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(0);
        // orients new painter to +y axis
        painter.turnLeft(90);

        // placeholder vars for demo
        // TODO: move placeholder variables
        double currentAngle = 0;
        int xPos1 = 0;
        int yPos1 = -50;
        double branchLength = 4;
        int time = 5;

        // draws demo plant
        Draw.drawPlant(currentAngle, branchLength, time, xPos1, yPos1, painter);

    }
}