/**
 * used for storing and accessing shapes
 * 
 * @author      Eric Boris
 * @version     10/12/18
 */
public class ShapeLibrary {
    /** the collection of shapes that shape library stores */
    ArrayList<Shape> shapes;
    
    /**
     * create the library
     */
    public ShapeLibrary() {
        shapes = new ArrayList<Shape>();
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
}