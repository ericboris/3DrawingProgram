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
        fillFromFile();
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
     * return a shape by index
     * 
     * @param   index   the index of the shape to return
     * @return          the shape to be returned
     */
    public Shape get(int index) {
        return shapes.get(index);
    }
    
    /** 
     * return a shape by shape name
     * 
     * @param   name    the name of shape to return
     * @return          the shape to be returned
     */
    public Shape get(String shapeName) {
        Shape shape = null;
        
        for (Shape sp : shapes) {
            if (shapeName.equals(sp.getName())) {
                shape = sp;
                break;
            } 
        }
        
        return shape;
    }
    
    /**
     * try to fill the shapes library with files from working path
     */
    public void fillFromFile() {
        try {
            String path = System.getProperty("user.dir") + "/shapes";
            File folder = new File(path);
            File[] files = folder.listFiles();
            for (File file : files) {
                String fileName = file.getPath();
                if (fileName.endsWith(".shp")) {
                    FileInputStream fileStream = new FileInputStream(fileName);
                    ObjectInputStream input = new ObjectInputStream(fileStream);
                    add((Shape) input.readObject());
                }
            }
        } catch (IOException i) {
            throw new RuntimeException(i);
        } catch (ClassNotFoundException c) {
            throw new RuntimeException(c);
        } 
    }
}