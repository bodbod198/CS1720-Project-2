import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;

import java.awt.Color;


public class Aquarium {
    public static int windowX = 1280;
    public static int windowY = 720;
    private static final CanvasAPI canvas = Graphics.createCanvas(windowX, windowY, "Bodie's Aquarium");
    // painter starts at 1/2 * windowX, 1/2 * windowY
    public static PainterAPI painter = Aquarium.canvas.getPainter();
    public static void initializePainter() {
        painter.setSpeed(0);
        // orients new painter to +y-axis
        painter.turnLeft(90);
    }

    public static void main(String[] args) {
        canvas.setBackgroundColor(new Color(118, 182, 196));
        initializePainter();
        //long startTime = System.nanoTime();
        Draw.drawPlant(5);
        //long currentTime = System.nanoTime();
        //double dtime =  (currentTime - startTime) / 1_000_000_000.0;
        //System.out.println(dtime);

    }
}