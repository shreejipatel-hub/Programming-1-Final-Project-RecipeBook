import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu 
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        // 1. Initialize the RecipeBook
        RecipeBook myBook = new RecipeBook("Grandma's Secrets", "Chief Chef", "1st Edition", 2025);

        // 2. Add some dummy data so you can test immediately
        seedData(myBook);

        boolean running = true;

        while (running) 
        {
            printMenu();
            int choice = getIntInput("Enter your choice: ");

            if (choice == 1) {
                // Add Recipe
                handleAddRecipe(myBook);
            }
            else if (choice == 2) {
                // List All
                ArrayList<Recipe> all = myBook.listAllRecipes();
                printRecipeList(all);
            }
            else if (choice == 3) {
                // Search
                handleSearch(myBook);
            }
            else if (choice == 4) {
                // List by Type
                handleListByType(myBook);
            }
            else if (choice == 5) {
                // Prepare (View details & execute steps)
                handlePrepare(myBook);
            }
            else if (choice == 6) {
                // Rate
                handleRate(myBook);
            }
            else if (choice == 7) {
                // Scale (Serving Size)
                handleScale(myBook);
            }
            else if (choice == 8) {
                // Top Rated
                Recipe top = myBook.getTopRated();
                if (top != null)
                {
                 System.out.println("\nTop Rated: " + top);   
                }
                else 
                {
                    System.out.println("No recipes found.");
                }
            }
            else if (choice == 9) {
                // Print Book Details
                myBook.printBookDetails();
            }
            else if (choice == 0) {
                System.out.println("Goodbye!");
                running = false;
            }
            else {
                System.out.println("Invalid choice.");
            }

            if(running) {
                System.out.println("\n(Press Enter to continue)");
                scanner.nextLine();
            }
        }
    }


    private static void printMenu() {
        System.out.println("\n=== RECIPE BOOK ===");
        System.out.println("1. Add a New Recipe");
        System.out.println("2. List All Recipes");
        System.out.println("3. Search (Title, Tag, Ingredient)");
        System.out.println("4. Filter by Meal Type");
        System.out.println("5. Prepare a Recipe (View Steps)");
        System.out.println("6. Rate a Recipe");
        System.out.println("7. Scale Serving Size");
        System.out.println("8. Show Top Rated Recipe");
        System.out.println("9. Book Details");
        System.out.println("0. Exit");
    }

    private static void printRecipeList(ArrayList<Recipe> list) {
        if (list.isEmpty()) {
            System.out.println("No recipes found.");
        } else {
            System.out.println("--- Recipe List ---");
            for (int i = 0; i < list.size(); i++) {
                Recipe r = list.get(i);
                System.out.println((i + 1) + ". " + r.toString());
            }
        }
    }

    

    private static void handleAddRecipe(RecipeBook book) {
        System.out.print("Enter Recipe Name: ");
        String name = scanner.nextLine();

        // Select Type
        System.out.println("Select Type: 1.DESSERT 2.SOUP 3.MAIN 4.BREAKFAST 5.APPETIZER");
        int typeIn = getIntInput("Choice: ");
        RecipeType type = RecipeType.MAIN_COURSE; // Default
        if (typeIn == 1) 
        {
            type = RecipeType.DESSERT;
        }
        else if (typeIn == 2)
        {
            type = RecipeType.SOUP;
        }
        else if (typeIn == 4) 
        {
            type = RecipeType.BREAKFAST;
        }
        else if (typeIn == 5) 
        {
            type = RecipeType.APPETIZER;
        }

        // Select Category (Baked vs Cold) to decide which class to create
        System.out.println("Is this a (1) Baked Dish or (2) Cold Dish?");
        int cat = getIntInput("Choice: ");

        Recipe newRecipe;

        if (cat == 1) {
            BakedDish bd = new BakedDish(name, type);
            bd.setOvenTemp(getDoubleInput("Enter Oven Temp (F): "));
            bd.setBakeTime(getDoubleInput("Enter Bake Time (mins): "));
            newRecipe = bd;
        } else {
            ColdDish cd = new ColdDish(name, type);
            cd.setChillTime(getDoubleInput("Enter Chill Time (hours): "));
            cd.setIsSet(true); 
            newRecipe = cd;
        }

        // Add Ingredients Loop
        System.out.println("--- Add Ingredients ---");


        // Add Steps Loop
        System.out.println("--- Add Steps ---");
        

        // Add Tags
        

        book.addRecipe(newRecipe);
        System.out.println("Recipe added successfully!");
    }

    private static void handleSearch(RecipeBook book) {
        System.out.println("Search by: 1. Title  2. Tag  3. Ingredient");
        int choice = getIntInput("Choice: ");
        
        System.out.print("Enter search term: ");
        String term = scanner.nextLine();

        ArrayList<Recipe> results;

        if (choice == 1) {
            results = book.searchByTitle(term);
        } else if (choice == 2) {
            results = book.searchByTag(term);
        } else {
            results = book.searchByIngredient(term);
        }
        printRecipeList(results);
    }

    private static void handleListByType(RecipeBook book) {
        System.out.println("1.DESSERT 2.SOUP 3.MAIN 4.BREAKFAST 5.APPETIZER");
        int typeIn = getIntInput("Choice: ");
        RecipeType type = RecipeType.MAIN_COURSE;
        if (typeIn == 1) 
        {
            type = RecipeType.DESSERT;
        }
        else if (typeIn == 2) 
        {
            type = RecipeType.SOUP;
        }
        else if (typeIn == 4) 
        {
            type = RecipeType.BREAKFAST;
        }
        else if (typeIn == 5) 
        {
            type = RecipeType.APPETIZER;
        }

        ArrayList<Recipe> results = book.listByType(type);
        printRecipeList(results);
    }

    private static void handlePrepare(RecipeBook book) {
        ArrayList<Recipe> all = book.listAllRecipes();
        printRecipeList(all);
        if (all.isEmpty()) 
        {
            return;
        }

        int idx = getIntInput("Select recipe number to prepare: ") - 1;
        if (idx >= 0 && idx < all.size()) {
            Recipe r = all.get(idx);
            
            System.out.println("\n*** PREPARING " + r.getName().toUpperCase() + " ***");
            System.out.println("Ingredients needed:");
            for(Ingredient i : r.getIngredients()) {
                System.out.println("- " + i.toString());
            }
            System.out.println("\nSteps:");
            // This calls the abstract method we defined in BakedDish or ColdDish
            r.prepare(); 
        } else {
            System.out.println("Invalid selection.");
        }
    }

    private static void handleScale(RecipeBook book) {
        ArrayList<Recipe> all = book.listAllRecipes();
        printRecipeList(all);
        if (all.isEmpty()) 
        {
            return;
        }

      
    }

    private static void handleRate(RecipeBook book) {
        ArrayList<Recipe> all = book.listAllRecipes();
        printRecipeList(all);
        if (all.isEmpty()) 
        {
            return;
        }

        int idx = getIntInput("Select recipe number: ") - 1;
        if (idx >= 0 && idx < all.size()) {
            double stars = getDoubleInput("Enter rating (0-5): ");
            all.get(idx).rate(stars);
            System.out.println("Rating saved.");
        }
    }

    

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid number.");
            scanner.next(); 
        }
        int i = scanner.nextInt();
        scanner.nextLine(); 
        return i;
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid number.");
            scanner.next(); 
        }
        double d = scanner.nextDouble();
        scanner.nextLine(); 
        return d;
    }

    private static void seedData(RecipeBook book) {
        
        BakedDish cake = new BakedDish("Chocolate Cake", RecipeType.DESSERT);
        cake.setOvenTemp(350);
        cake.setBakeTime(45);
        cake.addIngredient(new Ingredient("Flour", 2, "cups"));
        cake.addIngredient(new Ingredient("Sugar", 1, "cup"));
        cake.addStep("Mix dry ingredients");
        cake.addStep("Pour into pan");
        cake.addTag("sweet");
        cake.rate(4.5);
        book.addRecipe(cake);

        
        ColdDish salad = new ColdDish("Greek Salad", RecipeType.APPETIZER);
        salad.setChillTime(0.5);
        salad.setIsSet(true);
        salad.addIngredient(new Ingredient("Cucumber", 1, "large"));
        salad.addIngredient(new Ingredient("Feta Cheese", 100, "grams"));
        salad.addStep("Chop vegetables");
        salad.addStep("Toss with dressing");
        salad.addTag("healthy");
        salad.addTag("vegetarian");
        salad.rate(5.0);
        book.addRecipe(salad);
    }
}