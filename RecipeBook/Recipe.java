 import java.util.ArrayList;

public abstract class Recipe
{
    protected String name;
    protected ArrayList<String> tags;
    protected ArrayList<Ingredient> ingredients;
    protected ArrayList<String> steps;
    protected double rating;
    protected RecipeType type;
    protected int servingSize;
    public Recipe(String name, RecipeType type)
    {
        this.name = name;
        this.type = type;
        this.tags = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.rating =  rating;
        this.servingSize = 1;//serving size set to 1 by default
         
    }
    
    public void setServingSize(int newSize)
    {
        //calculating the ratio
        double factor = (double) newSize / this.servingSize;
        //update the number
        this.servingSize = newSize;
        //update all ingredients
        for(Ingredient i :  ingredients)
        {
            i.scale(factor);
        }
    }

    public void addTag(String tag)
    {
        tags.add(tag);
    }
    
    public boolean hasTag(String tag)
    {
        return tags.contains(tag);
    }

    public void addIngredient(Ingredient i)
    {
        ingredients.add(i);
    }

    public ArrayList<Ingredient> getIngredients()
    {
        return ingredients;
    }

    public void addStep(String step)
    {
        steps.add(step);
    }

    public void rate(double stars)
    {
        //checks if the rating is in a valid range
        if(stars >= 0 && stars <= 5)
        {
          this.rating = stars;//update the rating if valid  
        }
        
        else
        {
            //prints the rror if not in the valid range
            System.out.println("Error: The rating must be in between 0-5.");
        }
    }

    public double getRating()
    {
        return rating;
    }

    public RecipeType getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public int getServingSize()
    {
        return servingSize;
    }
    
    @Override
    public String toString()
    {
        return name + " ("+type+") - "+rating+"/5 stars";
    }
    // ABSTRACT method that forces the subclasses to define how to prepare
    public abstract void prepare();
}
