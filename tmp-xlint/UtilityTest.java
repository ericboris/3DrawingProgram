

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UtilityTest.
 *
 * @author      Bill Barry
 * @version     2018-09-14
 */
public class UtilityTest {
    /**
     * Default constructor for test class UtilityTest
     */
    public UtilityTest() {
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
    public void testRgbRangeLimit() {
        // Corrected values
        assertEquals(0,     Utility.rgbRangeLimit( -1));
        assertEquals(255,   Utility.rgbRangeLimit(256));
        
        // Non-corrected values
        assertEquals(0,     Utility.rgbRangeLimit(  0));
        assertEquals(255,   Utility.rgbRangeLimit(255));
        assertEquals(127,   Utility.rgbRangeLimit(127));
    }
}
