
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

/**
 * draw the instructions to the canvas
 * 
 * @author      Eric Boris 
 * @version     10/13/18
 */
public class Drawing {
    private ShapeLibrary shapeLib;
    private File file;
    private CanvasInstruction canvasInstr;
    private ArrayList<DrawInstruction> drawInstrs;

    /**
     * create a drawing object
     * 
     * @param   file        indicates what instruction file to utilize
     * @param   shapeLib    a collection of available shapes to draw
     */
    public Drawing(ShapeLibrary shapeLib, File file) {
        this.shapeLib = shapeLib;
        this.file = file;

        // get a new scanner object from the provided file
        Scanner fileScan;
        try {
            fileScan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // get the canvas instructions
        this.canvasInstr = CanvasInstruction.readFromFile(fileScan);

        // get all the draw instructions
        drawInstrs = new ArrayList<DrawInstruction>();
        while (fileScan.hasNext()) {
            this.drawInstrs.add(DrawInstruction.readFromFile(fileScan));
        }      
    }

    /**
     *  create a drawing based on canvas instructions and draw instructions
     */
    public void draw() {
        // create, size, and color new canvas
        DrawingPanel dp = new DrawingPanel();
        dp.setWidth(canvasInstr.getWidth());
        dp.setHeight(canvasInstr.getHeight());
        dp.setBackground(canvasInstr.getColorSolid());

        // create the drawaing panel graphics
        Graphics dpg = dp.getGraphics();

        // perform each of the drawing instructions        
        for (DrawInstruction instr : drawInstrs) {
            // get information about the shape
            Shape shape = shapeLib.get(instr.getShapeName());
            ArrayList<Point> points = shape.getPoints();
            dpg.setColor(instr.getColor());

            // draw each shape as many times as it is repeated
            for (int rep = 0; rep < instr.getRepeats(); rep++) {
                // create arrays to store the x and y points
                int[] x = new int[points.size()];
                int[] y = new int[points.size()];

                int xShift = getShift(instr.getStartingX(), canvasInstr.getWidth(), 
                        rep, instr.getRepeatOffsetX());
                int yShift = getShift(instr.getStartingY(), canvasInstr.getHeight(), 
                        rep, instr.getRepeatOffsetY());

                /*                     
                // move the shape's center in prepartion for scaling
                // removed xOff and yOff from end of lines for testing getShift()
                double cX = shape.getCenter().getX() + xShift;
                double cY = shape.getCenter().getY() + yShift;
                 */
                double cX = shape.getCenter().getX();
                double cY = shape.getCenter().getY();

                // iterate over the each point in the shape and its x and y
                // locations to their respective array at location index               
                int index = 0;
                for (Point p : points) {
                    // apply scaling and transformation
                    double sp = instr.getScalePercent();
                    double pX = ((p.getX() - cX) * sp / 100 + cX) + xShift;
                    double pY = ((p.getY() - cY) * sp / 100 + cY) + yShift;
                    
                    // store the modified point in the array of points
                    // and update the index
                    x[index] = ((int) Math.round(pX));
                    y[index] = ((int) Math.round(pY));
                    index++;
                }

                // draw the shape
                // either filled or line only
                if (instr.getFilled()) {
                    dpg.fillPolygon(x, y, points.size());
                } else {
                    dpg.drawPolygon(x, y, points.size());
                }
            }
        }
    }

    private int getShift(int initStart, int maxSize, int initRepeat, int initOffset) {
        // set the global adjustments on all the x pixel values
        int start = 0;
        int offset = 0;
        // randomize the x location or use the provided one
        if (initStart == Integer.MIN_VALUE) {
            start = new Random().nextInt(maxSize);
        } else {
            // set the pixel start for x apoints
            start =  initStart;
            // set the offset amount in pixels for repeated shapes
            offset = initRepeat * initOffset;
        }
        return start + offset;
    }
}