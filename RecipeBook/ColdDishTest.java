

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ColdDishTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ColdDishTest
{
    private ColdDish pudding;
    /**
     * Default constructor for test class ColdDishTest
     */
    public ColdDishTest()
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
        pudding = new ColdDish("Banana Pudding", RecipeType.DESSERT);
    }
    
    @Test
    public void testInitialization()
    {
        //check if name was set correctly inherited from recipe
        assertEquals("Banana Pudding", pudding.getName());
        //check if type was set correctly inherited from recipe
        assertEquals(RecipeType.DESSERT, pudding .getType());
        //check if unique fields are set to default
        assertEquals(0.0, pudding.getChillTime(), 0.01);
    }
    
    @Test
    public void testChillTimeSetter()
    {
        //set a new time
        pudding.setChillTime(4.5);
        //verify the getter return that time
        assertEquals(4.5, pudding.getChillTime(), 0.01);
    }
    
    @Test
    public void testTextureCheck()
    {
        //it should start with a false
        assertFalse(pudding.checkTexture());
        pudding.setIsSet(true);
        //it should be true now
        assertTrue(pudding.checkTexture());
    }
    
    @Test
    public void testPreparingSteps()
    {
        //add a step
        pudding.addStep("Mix milk and powder");
        //ensure the methode dont crash
        pudding.setChillTime(2);
        pudding.prepare();
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