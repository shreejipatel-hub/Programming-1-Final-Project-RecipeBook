public class Ingredient
{
    private String name;
    private double quantity;
    private String unit;
    private int calories; // optional extra data

    public Ingredient(String name, double quantity, String unit)
    {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.calories = 0;
    }

    public String getName()
    {
        return name;
    }

    public double getQuantity()
    {
        return quantity;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setCalories(int calories)
    {
        this.calories = calories;
    }

    public int getCalories()
    {
        return calories;
    }

    public String toString()
    {
        return quantity + " " + unit + " " + name;
    }
}
