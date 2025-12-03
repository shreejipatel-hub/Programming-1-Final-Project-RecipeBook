 

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
    
    public void setBakeTime(double time)
    {
        this.bakeTime = time;
    }

    public void setOvenTemp(double temp)
    {
        this.ovenTemp = temp;
    }
    
    public double getOvenTemp()
    {
        return bakeTime;
        
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
        //print steps
        int i = 2;
        for(String s : steps)
        {
            System.out.println(i + ". "+s);
            i++;
        }
        System.out.println(i+ ". bake for "+ bakeTime + " minutes");
    }
}
