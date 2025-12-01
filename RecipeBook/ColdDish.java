public class ColdDish extends Recipe
{
    private double chillTime;
    private boolean isSet;

    public ColdDish(String name, RecipeType type)
    {
        super(name, type);
        chillTime = 0;
        isSet = false;
    }

    public double chill()
    {
        return chillTime;
    }

    public void checkTexture()
    {
        System.out.println("Checking texture...");
    }

    @Override
    public void prepare()
    {
        System.out.println("Chilling for " + chillTime + " hours.");
    }
}
