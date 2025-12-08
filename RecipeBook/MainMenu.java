import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class MainMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainMenu
{
    // a scanner that is global to read the userinput throughout the class
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[]args)
    {
        //initializing the recipebook
        RecipeBook myBook = new RecipeBook("My Cookbook", "Student Name", "1st Edition", 2025);
        boolean running = true;
        
        //mainmenu loop
        while(running)
        {
            printMenu();//print the options
            //int choice = getIntInout("Enter your choice");
            //if (choice == 1)
            //{
              //  myBook.printBookDetails();
            //}
            //else if (choice == 2)
            //{
              //  ArrayList<Recipe> all = myBook.listAllRecipes();
            //}
            //else if (choice == 3)
            //{
              //  handleListByType(myBook);
            //}
            //else if (choice == 4)
            //{
              //  handleSearch(myBook);
            //}
            //else if (choice == 5)
            //{
              //  handlePrintDetails(myBook);
            //}
            //else if (choice == 6)
            //{
              //  handleRating(myBook);
            //}
            //else if (choice == 7)
            //{
               // Recipe top = myBook.getTopRated;
                //if(top != null)
                //{
                 //   System.out.println("Top Rated: "+top);
                //}
                //else
                //{
                  //  System.out.println("No recipes found");
                //}
            //}
            //else if (choice == 8)
            //{
              //  handleScaling(myBook);
            //}
            //else if (choice == 9)
            //{
              //  handleAddRecipe(mBook);
            //}
            //else if (choice == 0)
            //{
              //  System.out.println("Exiting system...");
               // running = false;//ends the loop
            //}
            //System.out.println("\n(press Enter to continue)");
            //scanner.nextLine();
        }
    }
    
    private static void printMenu()
    {
        System.out.println("\n=== RECIPE BOOK MENU ===");
        System.out.println("1. Print book details");
        System.out.println("2. List all recipes");
        System.out.println("3. List by type");
        System.out.println("4. Search (Title, Ingredient, Tag)");
        System.out.println("5. Print recipe details");
        System.out.println("6. Rate a recipe");
        System.out.println("7. Show top-rated recipe");
        System.out.println("8. Scale a recipe");
        System.out.println("9. Add your own recipe");
        System.out.println("0. Exit");
    }
    
    private static int getIntInput(String prompt)
    {
        System.out.println(prompt);
        while(!scanner.hasNextInt())
        {
            System.out.println("Invalid number. try again.");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }
    



}