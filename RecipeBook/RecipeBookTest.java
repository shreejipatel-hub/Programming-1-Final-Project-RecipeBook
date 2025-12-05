

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeBookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RecipeBookTest
{
    private RecipeBook myBook;
    private BakedDish cake;
    private ColdDish salad;
    private ColdDish smoothie;
    /**
     * Default constructor for test class RecipeBookTest
     */
    public RecipeBookTest()
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
        //creating a book
        myBook = new RecipeBook ("Test Book","shreeji","1st",2025);
        //creating some recipes for test
        cake = new BakedDish("Chocolate Cake", RecipeType.DESSERT);
        cake.setOvenTemp(350.0);
        cake.setBakeTime(45);
        cake.rate(5.0);//high rating
        
        salad = new ColdDish("Greek Salad", RecipeType.MAIN_COURSE);
        salad.rate(4.0);
        salad.addTag("Healthy");
        
        smoothie = new ColdDish("Berry Smoothie", RecipeType.DESSERT);
        smoothie.rate(4.5);
        smoothie.addTag("Vegan");
        smoothie.addTag("Healthy");
        //adding them to the book
        myBook.addRecipe(cake);
        myBook.addRecipe(salad);
        myBook.addRecipe(smoothie);
    }
    
    @Test
    public void testAddAndList()
    {
        //assertEquals(3, myBook.getRecipecount());
    }
    
    @Test
    

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