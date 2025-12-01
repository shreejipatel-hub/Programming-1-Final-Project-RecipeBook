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
        this.rating = 0;
        this.servingSize = 1;
    }

    public void addTag(String tag)
    {
        tags.add(tag);
    }

    public boolean hasTag(String tag)
    {
        return tags.contains(tag);
    }

    public void addIngredient(Ingredient ingredient)
    {
        ingredients.add(ingredient);
    }

    public ArrayList<Ingredient> getIngredients()
    {
        return ingredients;
    }

    public void addStep(String step)
    {
        steps.add(step);
    }

    public void rate(double value)
    {
        rating = value;
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

    public void setServingSize(int s)
    {
        servingSize = s;
    }

    // ABSTRACT
    public abstract void prepare();
}
