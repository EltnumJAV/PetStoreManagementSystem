import java.util.InputMismatchException;
import java.util.Scanner;

public class PetStoreDriver
{
    // main method for testing pet store functions
    public static void main(String[] args)
    {
        PetStore petStore = new PetStore("PetSmart", "727 Blue Zenith Dr", 727);

        System.out.println("Welcome to " + petStore.getDisplay());

        Scanner scanner = new Scanner(System.in);

        start(scanner, petStore);
    }

    // starts the user-console interaction
    public static void start(Scanner scanner, PetStore petStore)
    {
        System.out.println("\n1 - Owner\n2 - Customer\n");

        try
        {
            int choice = scanner.nextInt();

            while(!(choice == 1) && !(choice == 2))
            {
                System.out.println("\nPlease Enter 1 or 2\n");
                start(scanner, petStore);
            }

            if(choice == 1)
            {
                routeOwnerLogin(scanner, petStore);
            }
            else
            {
                routeCustomer(scanner, petStore);
            }

        }
        catch(InputMismatchException e)
        {
            System.out.println("\nPlease Enter 1 or 2\n");
            scanner.next();
            start(scanner, petStore);
        }
    }

    // routes user as though they were the owner logging in
    public static void routeOwnerLogin(Scanner scanner, PetStore petStore)
    {
        int count = 0;
        System.out.println("\n1 - Login\n2 - Back\n");

        try
        {
            int choice = scanner.nextInt();

            while(!(choice == 1) && !(choice == 2))
            {
                System.out.println("\nPlease Enter 1 or 2\n");
                routeOwnerLogin(scanner, petStore);
            }

            if(choice == 1)
            {
                System.out.print("\nEnter Owner Passcode: ");
                count = 1;
                int passcodeInput = scanner.nextInt();
                if (passcodeInput == 902911)
                {
                    routeOwner(scanner, petStore);
                }
                else
                {
                    System.out.println("\nPassword Incorrect. Returning To Initial Status\n");
                    start(scanner, petStore);
                }
            }
            else
            {
                start(scanner, petStore);
            }

        }
        catch(InputMismatchException e)
        {
            if(count == 1)
            {
                System.out.println("\nPlease Enter a Number Next Guess\n");
                scanner.next();
                routeOwnerLogin(scanner, petStore);
            }
            System.out.println("\nPlease Enter 1 or 2\n");
            scanner.next();
            routeOwnerLogin(scanner, petStore);
        }
    }

    // routes owner post login
    public static void routeOwner(Scanner scanner, PetStore petStore)
    {
        if(petStore.isMonthlyFeeDue())
        {
            System.out.println("\nMonthly Fee Is Currently Due");
        }
        else
        {
            System.out.println("\nMonthly Fee Is Not Currently Due");
        }

        System.out.println("\n1 - View Dogs\n2 - View Cats\n3 - View Exotics\n4 - View Regular Members\n5 - View Premium Members\n6 - Compare Two Pets' Value\n7 - Check Inventory Value\n8 - Add Pet To Adoption Pool\n9 - Operation Adopt\n10 - Toggle Monthly Due\n0 - Back\n");

        try
        {
            int choice = scanner.nextInt();

            while(!(choice == 1) && !(choice == 2) && !(choice == 3) && !(choice == 4) && !(choice == 5) && !(choice == 6) && !(choice == 7) && !(choice == 8) && !(choice == 9) && !(choice == 10) && !(choice == 0))
            {
                System.out.println("\nPlease Enter 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, or 0\n");
                scanner.next();
                routeOwner(scanner, petStore);
            }

            if(choice == 1)
            {
                petStore.displayDogs();
                routeOwner(scanner, petStore);
            }
            else if(choice == 2)
            {
                petStore.displayCats();
                routeOwner(scanner, petStore);
            }
            else if(choice == 3)
            {
                petStore.displayExotics();
                routeOwner(scanner, petStore);
            }
            else if(choice == 4)
            {
                petStore.displayRegularMembers();
                routeOwner(scanner, petStore);
            }
            else if(choice == 5)
            {
                petStore.displayPremiumMembers();
                routeOwner(scanner, petStore);
            }
            else if(choice == 6)
            {
                comparePets(scanner, petStore);
                routeOwner(scanner, petStore);
            }
            else if(choice == 7)
            {
                System.out.println("\n" + petStore.getName() + "'s Inventory Is Worth: $" + petStore.getInventoryValue() + "\n");
                routeOwner(scanner, petStore);
            }
            else if(choice == 8)
            {
                addPetForAdoption(scanner, petStore);
                routeOwner(scanner, petStore);
            }
            else if(choice == 9)
            {
                petStore.adoptionDrive(petStore.getAdoptionPool());
                petStore.displayDogs();
                petStore.displayCats();
                petStore.displayExotics();
                routeOwner(scanner, petStore);
            }
            else if(choice == 10)
            {
                if(petStore.isMonthlyFeeDue())
                {
                    petStore.setMonthlyFeeDue(false);
                    System.out.println("\nMonthly Fee Is No Longer Due\n");
                }
                else
                {
                    petStore.setMonthlyFeeDue(true);
                    System.out.println("\nMonthly Fee Is Now Due\n");
                }
                routeOwner(scanner, petStore);
            }
            else
            {
                start(scanner, petStore);
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("\nPlease Enter 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, or 0\n");
            scanner.next();
            routeOwner(scanner, petStore);
        }
    }

    // compares the price of two pets
    public static void comparePets(Scanner scanner, PetStore petStore)
    {
        try
        {
            System.out.print("\nEnter ID Of First Pet: ");
            int firstId = scanner.nextInt();
            Pet p1 = petStore.getPet(firstId);

            System.out.print("\nEnter ID Of Second Pet: ");
            int secondId = scanner.nextInt();
            Pet p2 = petStore.getPet(secondId);

            if(p1.compareTo(p2) == 1)
            {
                System.out.println("\nThe First Pet Is More Expensive\n");
            }
            else if(p1.compareTo(p2) == -1)
            {
                System.out.println("\nThe Second Pet Is More Expensive\n");
            }
            else
            {
                System.out.println("\nThe Pets Are Of Equal Value\n");
            }
        }
        catch(InputMismatchException | NullPointerException e)
        {
            System.out.println("\nPlease Enter Existing ID's\n");
            scanner.next();
            comparePets(scanner, petStore);
        }
    }

    // adds a pet to a pet store's adoption pool
    public static void addPetForAdoption(Scanner scanner, PetStore petStore)
    {
        try
        {
            System.out.print("\nEnter Species: ");
            scanner.next();
            String species = scanner.nextLine().toUpperCase();

            System.out.print("\nEnter Age: ");
            int age = scanner.nextInt();

            System.out.print("\nEnter Weight: ");
            int weight = scanner.nextInt();

            System.out.print("\nEnter Color: ");
            scanner.next();
            String color = scanner.nextLine().toUpperCase();

            System.out.print("\nEnter Price: ");
            double price = scanner.nextDouble();

            if(species.equals("DOG"))
            {
                petStore.getAdoptionPool().add(new Dog(petStore.getPetId(), age, weight, color, price));
                petStore.incrementPetId();
            }
            else if(species.equals("CAT"))
            {
                petStore.getAdoptionPool().add(new Cat(petStore.getPetId(), age, weight, color, price));
                petStore.incrementPetId();
            }
            else
            {
                petStore.getAdoptionPool().add(new Exotic(petStore.getPetId(), species, age, weight, color, price));
                petStore.incrementPetId();
            }

            petStore.displayAdoptionPool();
        }
        catch(InputMismatchException e)
        {
            System.out.println("\nPlease Enter The Requested Information\n");
            scanner.next();
            addPetForAdoption(scanner, petStore);
        }
    }

    // routes user as though they were a customer
    public static void routeCustomer(Scanner scanner, PetStore petStore)
    {

    }
}
