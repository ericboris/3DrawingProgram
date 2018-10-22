import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

/**
 * The test class InstructGuiTest.
 *
 * @author      Bill Barry
 * @version     2018-09-14
 */
public class InstructGuiTest {
    /**
     * Default constructor for test class InstructGuiTest
     */
    public InstructGuiTest() {
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
    public void testColorToRgb() {
        Color testColor = new Color(45, 56, 67);
        String colorString = InstructGui.colorToRgb(testColor, "");
        assertEquals(", red=45, green=56, blue=67", colorString);
        
        colorString = InstructGui.colorToRgb(testColor, "test");
        assertEquals(", testRed=45, testGreen=56, testBlue=67", colorString);
        
        colorString = InstructGui.colorToRgb(null, "x");
        assertEquals("", colorString);
    }
    
}
