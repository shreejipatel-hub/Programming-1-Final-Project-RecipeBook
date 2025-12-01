

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BakedDishTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BakedDishTest
{
    private BakedDish cake;
    /**
     * Default constructor for test class BakedDishTest
     */
    public BakedDishTest()
    {
        
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        cake = new BakedDish("Vanilla Cake", RecipeType.DESSERT);
    }

    @Test
    public void testBakingSpecifics()
    {
        //test the getters and setters
        cake.setOvenTemp(350);
        cake.setBakeTime(45);
        
        assertEquals(45.0, cake.getBakeTime(), 0.01);
        assertEquals(350.0, cake.getOvenTemp(), 0.01);
        
    }
    
    @Test
    public void testInheritanceInBakedDish()
    {
        //test to see if the super class features still work here
        cake.addTag("Sweet");
        cake.setServingSize(4);
        
        assertEquals(4, cake.getServingSize());
        assertTrue(cake.hasTag("Sweet"));
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}