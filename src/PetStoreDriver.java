import java.util.InputMismatchException;
import java.util.Scanner;

// main class that tests program functionality with a pre-made pet store
public class PetStoreDriver
{
    // main method for testing pet store functions
    public static void main(String[] args)
    {
        PetStore petStore = new PetStore("PetSmart", "727 Blue Zenith Dr", 727);
        System.out.println("\nWelcome to " + petStore.getDisplay());
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
                System.out.println("\nPlease Enter The Requested Information Next Time\n");
                start(scanner, petStore);
            }
            if(choice == 1)
            {
                OwnerConsoleInteractionUtilities.routeOwnerLogin(scanner, petStore);
            }
            else
            {
                routeCustomer(scanner, petStore);
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            scanner.next();
            start(scanner, petStore);
        }
    }

    // routes a generic customer through the pet store
    public static void routeCustomer(Scanner scanner, PetStore petStore)
    {
        System.out.println("\n1 - Log Into Regular Customer\n2 - Log Into Premium Customer\n3 - Register Regular Customer\n4 - Register Premium Customer\n5 - View Pets For Sale\n6 - Compare Two Pets' Price\n7 - Back\n");
        try
        {
            int choice = scanner.nextInt();
            scanner.nextLine();
            while(!(choice == 1) && !(choice == 2) && !(choice == 3) && !(choice == 4) && !(choice == 5) && !(choice == 6) && !(choice == 7))
            {
                System.out.println("\nPlease Enter The Requested Information Next Time\n");
                routeCustomer(scanner, petStore);
            }
            if(choice == 1)
            {
                petStore.displayRegularMembers();
                System.out.print("\nEnter Your Persons ID: ");
                int tempId = scanner.nextInt();
                RegularCustomerConsoleInteractionUtilities.routeRegularCustomer(scanner, petStore, (RegularMember) petStore.getMember(tempId));
            }
            else if(choice == 2)
            {
                petStore.displayPremiumMembers();
                System.out.print("\nEnter Your Persons ID: ");
                int tempId = scanner.nextInt();
                PremiumCustomerConsoleInteractionUtilities.routePremiumCustomer(scanner, petStore, (PremiumMember) petStore.getMember(tempId));
            }
            else if(choice == 3)
            {
                System.out.print("\nEnter First Name: ");
                String firstName = scanner.nextLine();
                System.out.print("\nEnter Last Name: ");
                String lastName = scanner.nextLine();
                System.out.print("\nEnter Passcode: ");
                int passcode = scanner.nextInt();
                petStore.registerRegularMember(firstName, lastName, passcode);
                System.out.println("\nRegistration Successful\n");
                routeCustomer(scanner, petStore);
            }
            else if(choice == 4)
            {
                System.out.print("\nEnter First Name: ");
                String firstName = scanner.nextLine();
                System.out.print("\nEnter Last Name: ");
                String lastName = scanner.nextLine();
                System.out.print("\nEnter Passcode: ");
                int passcode = scanner.nextInt();
                System.out.println("\nPay Monthly Fee Now:\n(1 - Yes)\n(2 - No)\n");
                int tempResponse = scanner.nextInt();
                while(!(tempResponse == 1) && !(tempResponse == 2))
                {
                    System.out.println("\nPlease Enter The Requested Information Next Time\n");
                    routeCustomer(scanner, petStore);
                }
                if(tempResponse == 1)
                {
                    petStore.registerPremiumMember(firstName, lastName, true, passcode);
                    System.out.println("\nRegistration Successful\n");
                }
                else
                {
                    petStore.registerPremiumMember(firstName, lastName, false, passcode);
                    System.out.println("\nRegistration Successful\n");
                }
                routeCustomer(scanner, petStore);
            }
            else if(choice == 5)
            {
                petStore.displayDogs();
                petStore.displayCats();
                petStore.displayExotics();
                routeCustomer(scanner, petStore);
            }
            else if(choice == 6)
            {
                comparePets(scanner, petStore);
            }
            else
            {
                start(scanner, petStore);
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            scanner.next();
            routeCustomer(scanner, petStore);
        }
        catch(ClassCastException e)
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            routeCustomer(scanner, petStore);
        }
    }

    // routes a purchase by a regular or premium member
    public static void routePurchase(Scanner scanner, PetStore petStore, Member member)
    {
        petStore.displayDogs();
        petStore.displayCats();
        petStore.displayExotics();
        try
        {
            System.out.print("\nEnter ID Of Desired Pet (or '0' To Back): ");
            int tempId = scanner.nextInt();
            if(tempId == 0)
            {
                PetStoreDriver.routeCustomer(scanner, petStore);
            }
            else
            {
                if(petStore.getPet(tempId) == null)
                {
                    System.out.println("\nPlease Enter The Requested Information Next Time\n");
                    routePurchase(scanner, petStore, member);
                }
                else
                {
                    member.setMoneySpent(member.getMoneySpent() + petStore.getPet(tempId).getPrice());
                    member.setPetsPurchased(member.getPetsPurchased() + 1);
                    member.setTransactionCount(member.getTransactionCount() + 1);
                    petStore.getPets().remove(petStore.getPet(tempId));

                    System.out.println("\nTransaction Successful. Updated Profile:\n" + member.getDisplay() + "\n");
                    routeCustomer(scanner, petStore);
                }
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            scanner.next();
            routePurchase(scanner, petStore, member);
        }
    }

    // compares two pets based on price
    public static void comparePets(Scanner scanner, PetStore petStore)
    {
        try
        {
            petStore.displayDogs();
            petStore.displayCats();
            petStore.displayExotics();
            System.out.print("\nEnter ID Of First Pet: ");
            int firstId = scanner.nextInt();
            Pet p1 = petStore.getPet(firstId);
            System.out.print("\nEnter ID Of Second Pet: ");
            int secondId = scanner.nextInt();
            Pet p2 = petStore.getPet(secondId);
            if((p1.compareTo(p2)) == 1)
            {
                System.out.println("\nThe First Pet Is More Expensive\n");
            }
            else if((p1.compareTo(p2)) == -1)
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
            System.out.println("\nSuch Pets Do Not Exist\n");
            start(scanner, petStore);
        }
    }

    // adds a pet to the adoption pool
    public static void addPetForAdoption(Scanner scanner, PetStore petStore)
    {
        try
        {
            System.out.print("\nEnter Species: ");
            String species = scanner.next().toUpperCase();
            System.out.print("\nEnter Age: ");
            int age = scanner.nextInt();
            System.out.print("\nEnter Weight: ");
            int weight = scanner.nextInt();
            System.out.print("\nEnter Color: ");
            String color = scanner.next().toUpperCase();
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
            System.out.println("\nPlease Enter The Requested Information Next Time\n");
            routeCustomer(scanner, petStore);
        }
    }
}
