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
    /** the collection of available shapes to draw */
    private ShapeLibrary shapeLib;
    /** the file to access canvas and drawing instructions from */
    private File file;
    /** the instructions to use to draw a canvas */
    private CanvasInstruction canvasInstr;
    /** the instructions to us to draw a picture on the canvas */
    private ArrayList<DrawInstruction> drawInstrs;
    /** the string all the details of this object */
    private String toString;

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
        this.drawInstrs = new ArrayList<DrawInstruction>(10);
        while (fileScan.hasNext()) {
            this.drawInstrs.add(DrawInstruction.readFromFile(fileScan));
        }
        
        this.toString = "";
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
            @SuppressWarnings("unchecked")
            ArrayList<Point> points = shapeLib.get(instr.getShapeName()).getPoints();
            dpg.setColor(instr.getColor());

            this.toString = toString + 
                            "\n\t\tname:\t" + instr.getShapeName() +
                            "\n\t\tfilled:\t" + instr.getFilled() + 
                            "\n\t\tcolor:\t" + instr.getColor() + 
                            "\n\t\tscale:\t " + instr.getScalePercent() +
                            "\n\t\trepeat:\t" + instr.getRepeats() + 
                            "\n\t\tpoints:";
            
            // draw each shape as many times as it is repeated
            for (int rep = 0; rep < instr.getRepeats(); rep++) {                
                // create arrays to store the x and y points
                int[][] pts = new int[2][points.size()];

                // the amount to translate the x and y points
                int xTran = getTrans(instr.getStartingX(), canvasInstr.getWidth(), 
                        rep * instr.getRepeatOffsetX());
                int yTran = getTrans(instr.getStartingY(), canvasInstr.getHeight(), 
                        rep * instr.getRepeatOffsetY());

                this.toString = toString + "\n\t\t\t" + (rep + 1) + ". ";
                        
                // iterate over the each point in the shape and its x and y
                // locations to their respective array at location index               
                for (int idx = 0; idx < points.size(); idx++) {
                    // for the x and y values of each point in the sahpe
                    // scale and translate
                    // and round the result
                    pts[0][idx] = ((int) Math.round(
                            points.get(idx).getX() * 
                            instr.getScalePercent() / 100) + 
                        xTran);
                    pts[1][idx] = ((int) Math.round(
                            points.get(idx).getY() * 
                            instr.getScalePercent() / 100) +
                        yTran);
                        
                    this.toString = toString + "(" + pts[0][idx] + ", " + pts[1][idx] + ")";
                }

                // draw the shape
                // either filled or line only
                if (instr.getFilled()) {
                    dpg.fillPolygon(pts[0], pts[1], points.size());
                } else {
                    dpg.drawPolygon(pts[0], pts[1], points.size());
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
    private int getTrans(int loc, int max, int offset) {
        int trans = 0;
        if (loc == Integer.MIN_VALUE) {
            trans = new Random().nextInt(max);
        } else {
            trans =  loc + offset;
        }
        return trans;
    }
    
    public String toString() {
        return file.getName() + ":\n\t" +
               canvasInstr.toString() + 
               "\n\tDrawing Instructions:" + this.toString;
    }
}