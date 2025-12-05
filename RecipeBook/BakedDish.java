 

 public class BakedDish extends Recipe
{
    //stores oven temperature
    private double ovenTemp;
    //stores baking time
    private double bakeTime;

    public BakedDish(String name, RecipeType type)
    {
        super(name, type);
        //sets the bake duration and the temperature to 0
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
        System.out.println("-------Baking Instructions for "+name+" --------");
        //starting with a specific step
        System.out.println("1. Preheat oven to "+ ovenTemp +" degrees.");
        //print the steps stored in the superclass
        int stepNum = 2;
        for(String step : steps)//looping through the steps arraylist from recipe
        {
            //print the step number and the instructions
           System.out.println(stepNum + ". "+ step);
           //incrementing the counter for next stap
           stepNum++;
        }
        //ending with a specific step
        System.out.println(". Bake for  "+ bakeTime +" minutes.");
    }
}
