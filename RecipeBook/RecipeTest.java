

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RecipeTest
{
    private BakedDish cake;
    private ColdDish salad;
    private Ingredient flour;
    /**
     * Default constructor for test class RecipeTest
     */
    public RecipeTest()
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
        //creating a baked dish
        cake = new BakedDish("Chocolate Cake", RecipeType.DESSERT);
        cake.setOvenTemp(350);
        cake.setBakeTime(45);
        cake.addStep("Mix ingredients");
        //add a new ingredient
        flour = new Ingredient("Flour", 1.0, "cup");
        cake.addIngredient(flour);
        //create a cold dish
        salad = new ColdDish("Fruit Salad", RecipeType.APPETIZER);
        salad.addTag("Vegan");        
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