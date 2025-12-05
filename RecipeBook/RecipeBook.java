import java.util.ArrayList;

public class RecipeBook
{
    private ArrayList<Recipe> recipes;
    private String author;
    private String edition;
    private int yearPublished;
   
    public RecipeBook(String bookName, String author, String edition, int yearPublished)
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
    
    //list all recipes
    public ArrayList<Recipe> listAllRecipes()
    {
        return recipes;
    }
     
    //list recipes by type
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
    
    public ArrayList<Recipe> searchByTag(String tag)
    {
        //creating a temporary list to hold matches
        ArrayList<Recipe> results = new ArrayList<>();
        //looping throught the recipes list
        for(Recipe r : recipes)
        {
            //use the hasTags() method that we have in Recipe class
            if(r.hasTag(tag))
            {
                //if it matches add it to results list
                results.add(r);
            }
        }
        return results;
    }
    
    public ArrayList<Recipe> searchByTitle(String searchString)
    {
        ArrayList<Recipe> results = new ArrayList<>();
        
        for(Recipe r : recipes)
        {
            //we will convert both to lowercase so it is case insensitive
            String recipeName = r.getName().toLowerCase();
            String search = searchString.toLowerCase();
            
            if(recipeName.contains(search))
            {
                results.add(r);
            }
            
        }
        return results;
    }
    
    public ArrayList<Recipe> searchByIngredient(String ingredientName)
    {
        ArrayList<Recipe> results = new ArrayList<>();
        
        //checks inside the recipes ingredients list
        for(Recipe r : recipes)
        {
            for(Ingredient i : r.getIngredients())
            {
                if(i.getName().equalsIgnoreCase(ingredientName))
                {
                    results.add(r);
                    //found it stope checking ingredients for this specific recipe
                    break;
                }
            }
        }
        return results;
    }   
}
 