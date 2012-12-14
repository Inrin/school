

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StackTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StackTest
{
    /**
     * Default constructor for test class StackTest
     */
    public StackTest()
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
    public void checkEmptiness()
    {
        Stack stack1 = new Stack();
        assertEquals(true, stack1.isEmpty());
    }

    @Test
    public void peekAndRetreat()
    {
        Stack stack1 = new Stack();
        stack1.push(new Card(1));
        assertEquals(1, stack1.peek());
    }

    @Test
    public void pop()
    {
        Stack stack1 = new Stack();
        assertEquals(null, stack1.pop());
        stack1.push(new Card(2));
        assertEquals(2, stack1.pop());
        assertEquals(null, stack1.peek());
    }
}



