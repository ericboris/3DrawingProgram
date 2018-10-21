
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
            ArrayList<Point> points = shapeLib.get(instr.getShapeName()).getPoints();
            dpg.setColor(instr.getColor());

            // draw each shape as many times as it is repeated
            for (int rep = 0; rep < instr.getRepeats(); rep++) {
                // create arrays to store the x and y points
                int[] x = new int[points.size()];
                int[] y = new int[points.size()];

                // the amount to translate the x and y points by
                int xTran = getTran(instr.getStartingX(), canvasInstr.getWidth(), 
                        rep * instr.getRepeatOffsetX());
                int yTran = getTran(instr.getStartingY(), canvasInstr.getHeight(), 
                        rep * instr.getRepeatOffsetY());

                // iterate over the each point in the shape and its x and y
                // locations to their respective array at location index               
                int index = 0;
                for (Point p : points) {
                    // get the x and y start values of the points
                    // multiply by the scale percentage
                    // add the shift transformation
                    double pX = (p.getX() * instr.getScalePercent() / 100) + xTran;
                    double pY = (p.getY() * instr.getScalePercent() / 100) + yTran;

                    // store the transformed point in the array of points
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

    /**
     * get the amount to translate the point by in a dimension (x or y)
     * 
     * @param   loc     the starting location of the point
     * @param   max     the maximum canvas size
     * @param   offset  the amount to offset the translation by, for repeated points
     * 
     * @return          the amount to translate a given point by
     */
    private int getTran(int loc, int max, int offset) {
        int trans = 0;
        if (loc == Integer.MIN_VALUE) {
            trans = new Random().nextInt(max);
        } else {
            trans =  loc + offset;
        }
        return trans;
    }
}