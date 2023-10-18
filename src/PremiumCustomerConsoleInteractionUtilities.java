import java.util.InputMismatchException;
import java.util.Scanner;

// utility class that contains methods for console interaction with premium pet store member
public class PremiumCustomerConsoleInteractionUtilities
{
    // routes premium customer's login
    public static void routePremiumCustomer(Scanner scanner, PetStore petStore, PremiumMember member)
    {
        if(member == null)
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            PetStoreDriver.routeCustomer(scanner, petStore);
        }
        System.out.print("\nEnter Passcode For Selected Member: ");
        int passcodeInput = scanner.nextInt();
        scanner.nextLine();
        if(passcodeInput == member.getPasscode())
        {
            routePremiumCustomerPostLogin(scanner, petStore, member);
        }
        else
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            PetStoreDriver.routeCustomer(scanner, petStore);
        }
    }

    // routes premium customer past login
    public static void routePremiumCustomerPostLogin(Scanner scanner, PetStore petStore, PremiumMember member)
    {
        System.out.println("\n1 - Purchase A Pet\n2 - Offer Pet For Adoption\n3 - Pay Monthly Fee\n4 - Back\n");
        try
        {
            int choice = scanner.nextInt();
            scanner.nextLine();
            while(!(choice == 1) && !(choice == 2) && !(choice == 3) && !(choice == 4))
            {
                System.out.println("\nPlease Enter The Requested Information Next Time\n");
                routePremiumCustomerPostLogin(scanner, petStore, member);
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
            else if(choice == 3)
            {
                if(!member.isDuePaid())
                {
                    member.setDuePaid(true);
                    member.setMoneySpent(member.getMoneySpent() + petStore.getMonthlyFee());
                    System.out.println("\nYour Monthly Fee Has Been Successfully Paid\n");
                    PetStoreDriver.routeCustomer(scanner, petStore);
                }
                else
                {
                    System.out.println("\nYou're Monthly Fee Is Already Paid\n");
                    PetStoreDriver.routeCustomer(scanner, petStore);
                }
            }
            else
            {
                PetStoreDriver.routeCustomer(scanner, petStore);
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            scanner.nextLine();
            routePremiumCustomerPostLogin(scanner, petStore, member);
        }
    }
}
