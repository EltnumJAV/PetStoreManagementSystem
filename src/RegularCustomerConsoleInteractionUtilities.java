import java.util.InputMismatchException;
import java.util.Scanner;

// utility class that contains methods for console interaction with regular pet store customer
public class RegularCustomerConsoleInteractionUtilities
{
    // routes regular customer's login
    public static void routeRegularCustomer(Scanner scanner, PetStore petStore, RegularMember member)
    {
        if(member == null)
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            PetStoreDriver.routeCustomer(scanner, petStore);
        }

        System.out.print("\nEnter Passcode For Selected Member: ");
        int passcodeInput = scanner.nextInt();

        if(passcodeInput == member.getPasscode())
        {
            routeRegularCustomerPostLogin(scanner, petStore, member);
        }
        else
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            PetStoreDriver.routeCustomer(scanner, petStore);
        }
    }

    // routes regular customer past login
    public static void routeRegularCustomerPostLogin(Scanner scanner, PetStore petStore, RegularMember member)
    {
        System.out.println("\n1 - Purchase A Pet\n2 - Offer Pet For Adoption\n3 - Back\n");

        try
        {
            int choice = scanner.nextInt();

            while(!(choice == 1) && !(choice == 2) && !(choice == 3))
            {
                System.out.println("\nPlease Enter The Requested Information Next Time\n");
                routeRegularCustomerPostLogin(scanner, petStore, member);
            }

            if(choice == 1)
            {
                PetStoreDriver.routePurchase(scanner, petStore, member);
            }
            else if(choice == 2)
            {
                PetStoreDriver.addPetForAdoption(scanner, petStore);
                PetStoreDriver.routeCustomer(scanner, petStore);
            }
            else
            {
                PetStoreDriver.routeCustomer(scanner, petStore);
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            scanner.next();
            routeRegularCustomerPostLogin(scanner, petStore, member);
        }
    }
}
