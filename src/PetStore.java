import java.util.ArrayList;

// class for creating pet stores that implements methods from a class that specifies pet store-specific features
public class PetStore implements PetStoreSpecification
{
    // pet store attributes
    private String name;
    private String address;
    private int storeNumber;
    private boolean monthlyFeeDue;
    private ArrayList<Pet> petList;
    private ArrayList<Member> memberList;
    private ArrayList<Pet> adoptionPool;
    private static int petId = 1;
    private static int memberId = 1;

    // creates a pet store
    public PetStore(String name, String address, int storeNumber)
    {
        this.name = name;
        this.address = address;
        this.storeNumber = storeNumber;
        petList = new ArrayList<>();
        memberList = new ArrayList<>();
        adoptionPool = new ArrayList<>();
        monthlyFeeDue = false;
    }

    // gets a pet's id
    public int getPetId()
    {
        return petId;
    }

    // returns pet store's name
    public String getName()
    {
        return name;
    }

    // returns whether pet store's monthly fee is due or not
    public boolean isMonthlyFeeDue()
    {
        return this.monthlyFeeDue;
    }

    // neatly organizes pet store information
    public String getDisplay()
    {
        return name + " at " + address + ". Store Number: " + storeNumber;
    }

    // returns specified member by id
    public Member getMember(int memberId)
    {
        for (Member member : memberList)
        {
            if(member.getId() == memberId)
            {
                return member;
            }
        }
        return null;
    }

    // returns list of registered regular pet store members
    public ArrayList<RegularMember> getRegularMembers()
    {
        ArrayList<RegularMember> result = new ArrayList<>();
        for(Member member : memberList)
        {
            if(member instanceof RegularMember)
            {
                result.add((RegularMember) member);
            }
        }
        return result;
    }

    // returns list of registered premium pet store members
    public ArrayList<PremiumMember> getPremiumMembers()
    {
        ArrayList<PremiumMember> result = new ArrayList<>();
        for(Member member : memberList)
        {
            if(member instanceof PremiumMember)
            {
                result.add((PremiumMember) member);
            }
        }
        return result;
    }

    // returns specified pet by id
    public Pet getPet(int petId)
    {
        for(Pet pet : petList)
        {
            if(pet.getId() == petId)
            {
                return pet;
            }
        }
        return null;
    }

    // returns list of pet store pets
    public ArrayList<Pet> getPets()
    {
        return petList;
    }

    // returns list of pet store dogs
    public ArrayList<Dog> getDogs()
    {
        ArrayList<Dog> result = new ArrayList<>();
        for(Pet pet : petList)
        {
            if(pet instanceof Dog)
            {
                result.add((Dog) pet);
            }
        }
        return result;
    }

    // returns list of pet store cats
    public ArrayList<Cat> getCats()
    {
        ArrayList<Cat> result = new ArrayList<>();
        for(Pet pet : petList)
        {
            if(pet instanceof Cat)
            {
                result.add((Cat) pet);
            }
        }
        return result;
    }

    // returns list of pet store exotics
    public ArrayList<Exotic> getExotics()
    {
        ArrayList<Exotic> result = new ArrayList<>();
        for(Pet pet : petList)
        {
            if(pet instanceof Exotic)
            {
                result.add((Exotic) pet);
            }
        }
        return result;
    }

    // neatly organizes regular members' information
    public void displayRegularMembers()
    {
        System.out.println("\nRegular Members:\n");
        for(Member member : this.getRegularMembers())
        {
            System.out.println(member.getDisplay() + "\n");
        }
        System.out.println("End Of Regular Members\n");
    }

    // neatly organizes premium members' information
    public void displayPremiumMembers()
    {
        System.out.println("\nPremium Members:\n");
        for(Member member : this.getPremiumMembers())
        {
            System.out.println(member.getDisplay() + "\n");
        }
        System.out.println("End Of Premium Members\n");
    }

    // adds a regular member to pet store
    public void registerRegularMember(String firstName, String lastName, int passcode)
    {
        memberList.add(new RegularMember(memberId, firstName, lastName, passcode));
        memberId++;
    }

    // adds a premium member to pet store
    public void registerPremiumMember(String firstName, String lastName, boolean duePaid, int passcode)
    {
        memberList.add(new PremiumMember(memberId, firstName, lastName, duePaid, passcode));
        memberId++;
    }

    // adds a dog to pet store
    public void addDog(int age, int weight, String color, double price)
    {
        petList.add(new Dog(petId, age, weight, color, price));
        petId++;
    }

    // adds a cat to pet store
    public void addCat(int age, int weight, String color, double price)
    {
        petList.add(new Cat(petId, age, weight, color, price));
        petId++;
    }

    // adds an exotic to pet store
    public void addExotic(String species, int age, int weight, String color, double price)
    {
        petList.add(new Exotic(petId, species, age, weight, color, price));
        petId++;
    }

    // neatly organize dogs' information
    public void displayDogs()
    {
        System.out.println("\nDogs:\n");
        for(Dog dog : this.getDogs())
        {
            System.out.println(dog.getDisplay() + "\n");
        }
        System.out.println("End Of Dogs\n");
    }

    // neatly organize cats' information
    public void displayCats()
    {
        System.out.println("\nCats:\n");
        for(Cat cat : this.getCats())
        {
            System.out.println(cat.getDisplay() + "\n");
        }
        System.out.println("End Of Cats\n");
    }

    // neatly organize exotic (pets') information
    public void displayExotics()
    {
        System.out.println("\nExotics:\n");
        for(Exotic exotic : this.getExotics())
        {
            System.out.println(exotic.getDisplay() + "\n");
        }
        System.out.println("End Of Exotics\n");
    }

    // returns pet store's adoption pool
    public ArrayList<Pet> getAdoptionPool()
    {
        return adoptionPool;
    }

    // neatly organize pets' information from the adoption pool
    public void displayAdoptionPool()
    {
        System.out.println("\nPets For Adoption:\n");
        for(Pet pet : adoptionPool)
        {
            System.out.println(pet.getDisplay() + "\n");
        }
        System.out.println("End Of Pets For Adoption\n");
    }

    // sets monthly fee due-status of pet store
    public void setMonthlyFeeDue(boolean updatedDueStatus)
    {
        monthlyFeeDue = updatedDueStatus;
    }

    // increments pet id by 1 to maintain id functionality
    public void incrementPetId()
    {
        petId++;
    }

    // takes in a list of pets to add to pet store's pet inventory
    @Override
    public void adoptionDrive(ArrayList<Pet> pets)
    {
        for(Pet pet : pets)
        {
            petList.add(pet);
        }
    }

    // returns dollar value of pet store's pet inventory
    @Override
    public double getInventoryValue()
    {
        double result = 0;
        for(Pet pet : petList)
        {
            result += pet.getPrice();
        }
        return result;
    }
}
