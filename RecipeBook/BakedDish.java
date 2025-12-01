 public class BakedDish extends Recipe
{
    private double ovenTemp;
    private double bakeTime;

    public BakedDish(String name, RecipeType type)
    {
        super(name, type);
        ovenTemp = 0;
        bakeTime = 0;
    }

    public void setOvenTemp(double temp)
    {
        ovenTemp = temp;
    }

    public double getBakeTime()
    {
        return bakeTime;
    }

    @Override
    public void prepare()
    {
        System.out.println("Preheating oven to " + ovenTemp);
        System.out.println("Baking for " + bakeTime + " minutes.");
    }
}
