import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;

public class Aquarium {
    public static void main(String[] args) {
        // initialize requirements
        boolean run = true;
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "test");
        PainterAPI painter = canvas.getPainter();

        // orients new painter to +y orientation
        painter.setSpeed(0); // Lower number means faster, zero means as fast as possible.
        painter.turnLeft(90);

        //while (run) {
            //double randomSeed = Math.random();
            double currentAngle = 0;
            int xPos1 = 0;
            //int xPos2 = 200;
            int yPos1 = -50;
            double branchLength = 4;

            int time = 5;
            Draw.drawPlant(currentAngle, branchLength, time, xPos1, yPos1, painter);
            //Draw.drawPlant(currentAngle, branchLength, time, xpos2, painter);
            //run = false;
        //}

    }
}