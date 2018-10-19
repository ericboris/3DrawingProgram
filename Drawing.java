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
}