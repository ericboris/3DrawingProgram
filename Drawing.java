/*
 * You must then do the work of drawing.  In some cases that will 
 * involved some transforms on the data, e.g., if the instruction
 * file says to draw the shape at (250, 100), then you must make
 * that happen.  Size is another transform that you'll need to 
 * handle.  Make sure to handle transforms in the proper order,
 * e.g., do you size first, then shift later, or the reverse?
 * 
 * When it comes to drawing the shape, you only need a couple of
 * basic Graphics methods.  You'll need .setColor() to change 
 * to the color you're about to draw with.  You'll also need
 * .drawPolygon() and .fillPolygon().  For extra credit a few
 * other methods will be necessary.
 * 
 * Do not use Graphics2D to do any of this work, regular or 
 * extra credit.  Use simple graphics commands and math to
 * accomplish these tasks.
 */
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
        // create, size, and colore new canvas
        DrawingPanel dp = new DrawingPanel();
        dp.setWidth(canvasInstr.getWidth());
        dp.setHeight(canvasInstr.getHeight());
        dp.setBackground(canvasInstr.getColorSolid());
        
        Graphics dpg = dp.getGraphics();
        
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
                
                // set the global adjustments on all the x pixel values
                int xStart = 0;
                int xOff = 0;
                // randomize the x location or use the provided one
                if (instr.getStartingX() == Integer.MIN_VALUE) {
                    xStart = new Random().nextInt(canvasInstr.getWidth());
                } else {
                    // set the pixel start for x apoints
                    xStart =  instr.getStartingX();
                    // set the offset amount in pixels for repeated shapes
                    xOff = rep * instr.getRepeatOffsetX();;
                }
                
                // repeat the above for y
                // kept seperate in case x is random and y is not, and vice versa
                int yStart = 0;
                int yOff = 0;
                if (instr.getStartingY() == Integer.MIN_VALUE) {
                    yStart = new Random().nextInt(canvasInstr.getHeight());
                } else {
                    yStart = instr.getStartingY();
                    yOff = rep * instr.getRepeatOffsetY();
                }
                
                // iterate over the each point in the shape and its x and y
                // locations to their respective array at location index               
                int index = 0;
                for (Point p : points) {
                    x[index] = ((int) Math.round(p.getX())) + xStart + xOff;
                    y[index] = ((int) Math.round(p.getY())) + yStart + yOff;
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
}