public class ColdDish extends Recipe
{
    private double chillTime;
    private boolean isSet;

    public ColdDish(String name, RecipeType type)
    {
        super(name, type);//calling the super class
        chillTime = 0;
        this.isSet = false;
    }
    
    public void setChillTime(double time)
    {
        this.chillTime = time;//updates the private variable
    }

    public double getChillTime()
    {
        return chillTime;//returns the value of chill time
    }
    
    public void setIsSet(boolean status)
    {
        this.isSet = status;//will update the boolean to true or false
    }
    
    //specfic method to see if the dish is ready
    public boolean checkTexture()
    {
        System.out.println("Checking consistency...");
        if(this.isSet == true)//checks the boolean condition
        {
            return true;//return true if the dish is set
        }
        return false;//return false if its not
    }

    @Override
    public void prepare()
    {
        System.out.println("Chilling for " + chillTime + " hours.");
        //print steps
        int i = 1;
        for(String s : steps)//loop through the steps arraylist stored in Recipe
        {
            System.out.println(i+ ". "+s);//print the current step
            i++;//increment so moving on to next step
        }
        System.out.println(i + ". Chill for "+ chillTime + " hours.");
        if(chillTime==0)//check if we forgot to set a time
        {
            System.out.println("Note: Serve Immidiately this dish does not require chilling");
        }
    }
}
