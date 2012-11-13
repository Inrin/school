

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TaskTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TaskTest
{
    private Task task1;
    private Task task2;

    /**
     * Default constructor for test class TaskTest
     */
    public TaskTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        task1 = new Task("test w/p", 1);
        task2 = new Task("test");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void getDescriptonTest()
    {
        assertEquals("test w/p", task1.getDescription());
        assertEquals("test w/p", task1.getDescription());
    }
}

