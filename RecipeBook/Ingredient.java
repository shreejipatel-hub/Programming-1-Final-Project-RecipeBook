public class Ingredient
{
    private String name;
    private double amount;
    private String unit;
    private int calories; // optional extra data

    public Ingredient(String name, double amount, String unit)
    {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.calories = 0;
    }

    public String getName()
    {
        return name;
    }

    public double getAmount()
    {
        return amount;
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
        return amount + " " + unit + " " + name;
    }
}
