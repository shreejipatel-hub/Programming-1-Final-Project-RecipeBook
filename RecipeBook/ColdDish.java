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
    
    public void setChillTime(double time)
    {
        this.chillTime = time;
    }

    public double getChillTime()
    {
        return chillTime;
    }

    public void checkTexture()
    {
        System.out.println("Checking consistency...");
        this.isSet = true;
    }

    @Override
    public void prepare()
    {
        System.out.println("Chilling for " + chillTime + " hours.");
        //print steps
        int i = 1;
        for(String s : steps)
        {
            System.out.println(i+ ". "+s);
            i++;
        }
        System.out.println(i + ". Chill for "+ chillTime + " hours.");
    }
}
