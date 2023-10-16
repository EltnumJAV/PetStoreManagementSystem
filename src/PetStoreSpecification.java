import java.util.ArrayList;

// interface that provides methods for pet store features/functionality
public interface PetStoreSpecification
{
    // adds provided pets to a pet store's pet inventory
    public void adoptionDrive(ArrayList<Pet> pets);

    // returns a pet store's inventory value in dollars
    public double getInventoryValue();
}
