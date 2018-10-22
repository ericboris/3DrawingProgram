import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ShapeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ShapeTest {
    /**
     * Default constructor for test class ShapeTest
     */
    public ShapeTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
    
    @Test
    public void testConstructor() {
        Shape testShape = new Shape("test") ;
        Point testPoint = new Point();
        ArrayList<Point> testPoints = new ArrayList<Point>();
        testPoints.add(testPoint);
        testShape.addPoint(testPoint);
        assertEquals(testPoints.get(0), testShape.getPoints().get(0));
    }
}
