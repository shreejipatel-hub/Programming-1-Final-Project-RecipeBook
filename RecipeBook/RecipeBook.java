import java.util.ArrayList;

public class RecipeBook
{
    private ArrayList<Recipe> recipes;
    private String author;
    private String edition;
    private int yearPublished;
   
    public RecipeBook(String author, String edition, int yearPublished)
    {
        recipes = new ArrayList<>();
        this.author = author;
        this.edition = edition;
        this.yearPublished = yearPublished;
    }

    public void addRecipe(Recipe r)
    {
        recipes.add(r);
    }

    public ArrayList<Recipe> listAllRecipes()
    {
        return recipes;
    }
 
    public ArrayList<Recipe> listByType(RecipeType type)
    {
        ArrayList<Recipe> out = new ArrayList<>();
        for (Recipe r : recipes)
        {
            if (r.getType() == type)
            {
                out.add(r);
            }
        }
        return out;
    }

    public Recipe getTopRated()
    {
        if (recipes.isEmpty()) return null;
        
        Recipe best = recipes.get(0);

        for (Recipe r : recipes)
        {
            if (r.getRating() > best.getRating())
            {
                best = r;
            }
        }
        return best;
    }

    public void printBookDetails()
    {
        System.out.println("Author: " + author);
        System.out.println("Edition: " + edition);
        System.out.println("Year: " + yearPublished);
        System.out.println("Total Recipes: " + recipes.size());
    }
}
 