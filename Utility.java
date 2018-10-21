import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 * Provides supporting utilities for the Drawing Application, especially in creating the initial shape library
 *
 * @author      Bill Barry
 * @version     2017-09-07
 */
public class Utility {

    private Utility() {
        // This class isn't mean to be instantiated, so a private
        // constructor ensures other classes don't attempt such.  
        // Instead, they must use the static methods provided.
    }
    
    /**
     * Creates/recreates the shape library, overwriting existing files
     */
    public static void createShapeLib() throws FileNotFoundException, IOException {
        ArrayList<Shape> shapeLib = new ArrayList<>();
        addShapeSquare(shapeLib);
        addShapeStar(shapeLib);
        addShapeCircle(shapeLib);
        addShapeHeart(shapeLib);
        addShapeGem(shapeLib);
        addShapeSpiral(shapeLib);
        writeShapes(shapeLib);
    }
    
    /**
     * Creates a square shape and adds it to the library
     *
     * @param   shapeLib    the shape library to which to add the shape
     */
    private static void addShapeSquare(ArrayList<Shape> shapeLib) {
        Shape square = new Shape("square");
        square.addPoint(new Point(0, 0));
        square.addPoint(new Point(100, 0));
        square.addPoint(new Point(100, 100));
        square.addPoint(new Point(0, 100));
        shapeLib.add(square);
    }
    
    /**
     * Creates a four-pointed star shape and adds it to the library
     *
     * @param   shapeLib    the shape library to which to add the shape
     */
    private static void addShapeStar(ArrayList<Shape> shapeLib) {
        Shape star = new Shape("star");
        star.addPoint(new Point(50, 0));
        star.addPoint(new Point(50 + 10, 50 - 10));
        star.addPoint(new Point(100, 50));
        star.addPoint(new Point(50 + 10, 50 + 10));
        star.addPoint(new Point(50, 100));
        star.addPoint(new Point(50 - 10, 50 + 10));
        star.addPoint(new Point(0, 50));
        star.addPoint(new Point(50 - 10, 50 - 10));
        shapeLib.add(star);
    }
    
    /**
     * Creates a circle shape and adds it to the library
     *
     * @param   shapeLib    the shape library to which to add the shape
     */
    private static void addShapeCircle(ArrayList<Shape> shapeLib) {
        Shape circle = new Shape("circle");
        circle.addPoint(new Point(100.0,  50.0));
        circle.addPoint(new Point( 98.0,  37.0));
        circle.addPoint(new Point( 93.0,  25.0));
        circle.addPoint(new Point( 85.0,  15.0));
        circle.addPoint(new Point( 75.0,   7.0));
        circle.addPoint(new Point( 63.0,   2.0));
        circle.addPoint(new Point( 50.0,   0.0));
        circle.addPoint(new Point( 37.0,   2.0));
        circle.addPoint(new Point( 25.0,   7.0));
        circle.addPoint(new Point( 15.0,  15.0));
        circle.addPoint(new Point(  7.0,  25.0));
        circle.addPoint(new Point(  2.0,  37.0));
        circle.addPoint(new Point(  0.0,  50.0));
        circle.addPoint(new Point(  2.0,  63.0));
        circle.addPoint(new Point(  7.0,  75.0));
        circle.addPoint(new Point( 15.0,  85.0));
        circle.addPoint(new Point( 25.0,  93.0));
        circle.addPoint(new Point( 37.0,  98.0));
        circle.addPoint(new Point( 50.0, 100.0));
        circle.addPoint(new Point( 63.0,  98.0));
        circle.addPoint(new Point( 75.0,  93.0));
        circle.addPoint(new Point( 85.0,  85.0));
        circle.addPoint(new Point( 93.0,  75.0));
        circle.addPoint(new Point( 98.0,  63.0));
        circle.addPoint(new Point(100.0,  50.0));
        shapeLib.add(circle);
    }

    /**
     * Creates a heart shape and adds it to the library
     *
     * @param   shapeLib    the shape library to which to add the shape
     */
    private static void addShapeHeart(ArrayList<Shape> shapeLib) {
        Shape heart = new Shape("heart");
        heart.addPoint(new Point(100.0,  25.0));
        heart.addPoint(new Point( 99.0,  19.0));
        heart.addPoint(new Point( 97.0,  13.0));
        heart.addPoint(new Point( 93.0,   7.0));
        heart.addPoint(new Point( 88.0,   3.0));
        heart.addPoint(new Point( 81.0,   1.0));
        heart.addPoint(new Point( 75.0,   0.0));
        heart.addPoint(new Point( 69.0,   1.0));
        heart.addPoint(new Point( 63.0,   3.0));
        heart.addPoint(new Point( 57.0,   7.0));
        heart.addPoint(new Point( 53.0,  13.0));
        heart.addPoint(new Point( 51.0,  19.0));
        heart.addPoint(new Point( 50.0,  25.0));
        heart.addPoint(new Point( 49.0,  19.0));
        heart.addPoint(new Point( 47.0,  13.0));
        heart.addPoint(new Point( 43.0,   7.0));
        heart.addPoint(new Point( 38.0,   3.0));
        heart.addPoint(new Point( 31.0,   1.0));
        heart.addPoint(new Point( 25.0,   0.0));
        heart.addPoint(new Point( 19.0,   1.0));
        heart.addPoint(new Point( 13.0,   3.0));
        heart.addPoint(new Point(  7.0,   7.0));
        heart.addPoint(new Point(  3.0,  13.0));
        heart.addPoint(new Point(  1.0,  19.0));
        heart.addPoint(new Point(  0.0,  25.0));
        heart.addPoint(new Point( 50.0, 100.0));
        heart.addPoint(new Point(100.0,  25.0));
        shapeLib.add(heart);
    }
    
    private static void addShapeGem(ArrayList<Shape> shapeLib) {
        Shape gem = new Shape ("gem");
        
        gem.addPoint(new Point(  0.0,   50.0));
        gem.addPoint(new Point( 40.0,   40.0));
        gem.addPoint(new Point( 20.0,   30.0));
        gem.addPoint(new Point( 10.0,   10.0));
        gem.addPoint(new Point(  0.0,   50.0));
        gem.addPoint(new Point(  0.0,    0.0));
        gem.addPoint(new Point( 50.0,    0.0));
        gem.addPoint(new Point( 10.0,   10.0));
        gem.addPoint(new Point( 30.0,   20.0));
        gem.addPoint(new Point( 40.0,   40.0));
        gem.addPoint(new Point( 50.0,    0.0));
        
        gem.addPoint(new Point( 60.0,   40.0));
        gem.addPoint(new Point( 70.0,   20.0));
        gem.addPoint(new Point( 90.0,   10.0));
        gem.addPoint(new Point( 50.0,   0.0));
        gem.addPoint(new Point(100.0,    0.0));
        gem.addPoint(new Point(100.0,   50.0));
        gem.addPoint(new Point( 90.0,   10.0));
        gem.addPoint(new Point( 80.0,   30.0));
        gem.addPoint(new Point( 60.0,   40.0));
        gem.addPoint(new Point(100.0,   50.0));
        
        gem.addPoint(new Point( 60.0,   60.0));
        gem.addPoint(new Point( 80.0,   70.0));
        gem.addPoint(new Point( 90.0,   90.0));
        gem.addPoint(new Point(100.0,   50.0));
        gem.addPoint(new Point(100.0,  100.0));
        gem.addPoint(new Point( 50.0,  100.0));
        gem.addPoint(new Point( 90.0,   90.0));
        gem.addPoint(new Point( 70.0,   80.0));
        gem.addPoint(new Point( 60.0,   60.0));
        gem.addPoint(new Point( 50.0,  100.0));
        
        gem.addPoint(new Point( 40.0,   60.0));
        gem.addPoint(new Point( 30.0,   80.0));
        gem.addPoint(new Point( 10.0,   90.0));
        gem.addPoint(new Point( 50.0,  100.0));
        gem.addPoint(new Point(  0.0,  100.0));
        gem.addPoint(new Point(  0.0,   50.0));
        gem.addPoint(new Point( 10.0,   90.0));
        gem.addPoint(new Point( 20.0,   70.0));
        gem.addPoint(new Point( 40.0,   60.0));
        gem.addPoint(new Point(  0.0,   50.0)); 
        
        shapeLib.add(gem);
    }
    
    private static void addShapeSpiral(ArrayList<Shape> shapeLib) {
        Shape spiral = new Shape("spiral");
        
        spiral.addPoint(new Point(   0.0,    0.0));
        spiral.addPoint(new Point(  90.0,    0.0));
        spiral.addPoint(new Point(  90.0,   90.0));
        spiral.addPoint(new Point(   0.0,   90.0));
        spiral.addPoint(new Point(   0.0,   20.0));
        spiral.addPoint(new Point(  70.0,   20.0));
        spiral.addPoint(new Point(  70.0,   70.0));
        spiral.addPoint(new Point(  20.0,   70.0));
        spiral.addPoint(new Point(  20.0,   40.0));
        spiral.addPoint(new Point(  50.0,   40.0));
        spiral.addPoint(new Point(  50.0,   50.0));
        
        spiral.addPoint(new Point(  30.0,   50.0));
        spiral.addPoint(new Point(  30.0,   60.0));
        spiral.addPoint(new Point(  60.0,   60.0));
        spiral.addPoint(new Point(  60.0,   30.0));
        spiral.addPoint(new Point(  10.0,   30.0));
        spiral.addPoint(new Point(  10.0,   80.0));
        spiral.addPoint(new Point(  80.0,   80.0));
        spiral.addPoint(new Point(  80.0,   10.0));
        spiral.addPoint(new Point(   0.0,   10.0));
        spiral.addPoint(new Point(   0.0,    0.0));
       
        shapeLib.add(spiral);
    }
    
    /**
     * Writes shapes to their respective shape files, within the shapes folder (under the project folder)
     *
     * @param   shapeLib    the shape library from which to create the shapes
     */
    private static void writeShapes(ArrayList<Shape> shapeLib) throws FileNotFoundException, IOException {
        // Get the path to the current project folder, use it to create the shapes subfolder
        // This will succeed regardless of whether the folder already exists
        Path folderPath = Paths.get(System.getProperty("user.dir") + "/shapes");
        Files.createDirectories(folderPath);
        
        // Create the individual shape files
        for (int shapeIdx = 0; shapeIdx < shapeLib.size(); shapeIdx++) {
            FileOutputStream shapeFile = new FileOutputStream("shapes/" + shapeLib.get(shapeIdx).getName() + ".shp");
            ObjectOutputStream out = new ObjectOutputStream(shapeFile);
            out.writeObject(shapeLib.get(shapeIdx));
            out.close();
            shapeFile.close();
        }
    }

    /**
     * Ensures that RGB values are within required range 0-255; sets to boundary, otherwise
     *
     * @param   rgbValue        an RGB value to validate
     * @return                  an in-range RGB value
     */
    public static int rgbRangeLimit(int rgbValue) {
        return Math.min(255, Math.max(0, rgbValue));
    }
}
