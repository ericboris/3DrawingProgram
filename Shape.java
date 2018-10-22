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
     * return a string version of this shape
     * 
     * @return          the string version of this shape
     */
    public String toString() {
        String pts = "";
        for (Point pt : points) {
            pts += pt.toString();
        }
        return name + "\t: " + pts;
    }
}
