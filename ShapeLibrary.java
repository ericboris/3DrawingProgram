import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.*;


/**
 * used for storing and accessing shapes
 * 
 * @author      Eric Boris
 * @version     10/12/18
 */
public class ShapeLibrary {
    /** the collection of shapes that shape library stores */
    ArrayList<Shape> shapes;
    
    /** a collection of the available shapes */
    public static final ArrayList<Shape> SHAPES = new ArrayList<>();
    
    /**
     * create the library and try to load shapes from files
     */
    public ShapeLibrary() {
        shapes = new ArrayList<Shape>();
        fillFromFiles();
    }
    
    /**
     * add a shape to the library
     * 
     * @param   shape   the shape to add
     */
    public void add(Shape shape) {
        shapes.add(shape);
    }
    
    /**
     * return the a shape by index
     * 
     * @param   index   the index of the shape to return
     */
    public Shape get(int index) {
        return shapes.get(index);
    }
    
    /**
     * try to fill the shapes library with files from working path
     */
    public void fillFromFiles() {
        try {
            FileInputStream fileStream = new FileInputStream("shapes/square.shp");
            ObjectInputStream input = new ObjectInputStream(fileStream);
            add((Shape) input.readObject());
        } catch (IOException i) {
            throw new RuntimeException(i);
        } catch (ClassNotFoundException c) {
            throw new RuntimeException(c);
        } 
    }
}