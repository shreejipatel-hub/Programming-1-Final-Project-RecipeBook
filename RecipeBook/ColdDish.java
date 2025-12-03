public class ColdDish extends Recipe
{
    private double chillTime;
    private boolean isSet;

    public ColdDish(String name, RecipeType type)
    {
        super(name, type);
        chillTime = 0;
        this.isSet = false;
    }
    
    public void setChillTime(double time)
    {
        this.chillTime = time;
    }

    public double getChillTime()
    {
        return chillTime;
    }
    
    public void setIsSet(boolean status)
    {
        this.isSet = status;
    }

    public boolean checkTexture()
    {
        System.out.println("Checking consistency...");
        if(this.isSet == true)
        {
            return true;
        }
        return false;
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
