import java.io.Serializable;

/** 
 * Create a shape class that exists as a collection of points
 * 
 * @author      Eric Boris
 * @version     10/12/18
 */
public class Shape implements Serializable {
    /** name the name of the shape */
    private String name;
    /** points collection of all the points that comprise a shape */
    private ArrayList<Point> points;
    
    /**
     * create a new shape
     * 
     * @param   name    the name of the shape
     */
    public Shape(String name) {
        this.name = name;
        this.points = new ArrayList<Point>();
    }
    
    /**
     * add a new point to the shape
     * 
     * @param   point   the point to add to the shape
     */
    public void addPoint(Point point) {
        this.points.add(point);
    }
    
    /**
     * get the name of the shape
     */
    public String getName() {
        return name;
    }
    
    /**
     * get the points of the shape
     */
    public ArrayList getPoints() {
        return points;
    }
    
    /**
     * get the center of the shape
     * 
     * @return          the center point
     */
    public Point getCenter() {
        double cX = 0;
        double cY = 0;
        for (Point p : points) {
            cX = cX + p.getX();
            cY = cY + p.getY();
        }
        cX = cX / points.size();
        cY = cY / points.size();
        return new Point(cX, cY);
    }
}
