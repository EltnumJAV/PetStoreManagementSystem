import java.util.InputMismatchException;
import java.util.Scanner;

// utility class that contains methods for console interaction with pet store owner
public class OwnerConsoleInteractionUtilities
{
    // routes the owner's login
    public static void routeOwnerLogin(Scanner scanner, PetStore petStore)
    {
        int count = 0;
        System.out.println("\n1 - Login\n2 - Back\n");
        try
        {
            int choice = scanner.nextInt();
            scanner.nextLine();
            while(!(choice == 1) && !(choice == 2))
            {
                System.out.println("\nPlease Enter The Requested Information Next Time\n");
                routeOwnerLogin(scanner, petStore);
            }
            if(choice == 1)
            {
                System.out.print("\nEnter Owner Passcode: ");
                count = 1;
                int passcodeInput = scanner.nextInt();
                scanner.nextLine();
                if (passcodeInput == 902911)
                {
                    routeOwner(scanner, petStore);
                }
                else
                {
                    System.out.println("\nPlease Enter The Requested Information Next Time\n");
                    PetStoreDriver.start(scanner, petStore);
                }
            }
            else
            {
                PetStoreDriver.start(scanner, petStore);
            }
        }
        catch(InputMismatchException e)
        {
            if(count == 1)
            {
                System.out.println("\nPlease Enter The Requested Information Next Time\n");
                scanner.nextLine();
                routeOwnerLogin(scanner, petStore);
            }
            System.out.println("\nPlease Enter 1 or 2\n");
            scanner.nextLine();
            routeOwnerLogin(scanner, petStore);
        }
    }

    // routes the owner past login
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
        System.out.println("\n1 - View Dogs\n2 - View Cats\n3 - View Exotics\n4 - View Regular Members\n5 - View Premium Members\n6 - Compare Two Pets' Price\n7 - Check Inventory Value\n8 - Add Pet To Adoption Pool\n9 - Operation Orphan\n10 - Toggle Monthly Due\n0 - Back\n");
        try
        {
            int choice = scanner.nextInt();
            scanner.nextLine();
            while(!(choice == 1) && !(choice == 2) && !(choice == 3) && !(choice == 4) && !(choice == 5) && !(choice == 6) && !(choice == 7) && !(choice == 8) && !(choice == 9) && !(choice == 10) && !(choice == 0))
            {
                System.out.println("\nPlease Enter The Requested Information Next Time\n");
                scanner.nextLine();
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
                PetStoreDriver.comparePets(scanner, petStore);
                routeOwner(scanner, petStore);
            }
            else if(choice == 7)
            {
                System.out.println("\n" + petStore.getName() + "'s Inventory Is Worth: $" + petStore.getInventoryValue() + "\n");
                routeOwner(scanner, petStore);
            }
            else if(choice == 8)
            {
                PetStoreDriver.addPetForAdoption(scanner, petStore);
                routeOwner(scanner, petStore);
            }
            else if(choice == 9)
            {
                petStore.adoptionDrive(petStore.getAdoptionPool());
                petStore.getAdoptionPool().clear();
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
                PetStoreDriver.start(scanner, petStore);
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            scanner.nextLine();
            routeOwner(scanner, petStore);
        }
    }
}
