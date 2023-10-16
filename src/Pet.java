//// abstract class for pets from which different types of pets will inherit
public abstract class Pet implements Comparable
{
    // pet attributes
    private int id;
    private String species;
    private int age;
    private int weight;
    private String color;
    private double price;

    // creates a pet
    public Pet(int id, String species, int age, int weight, String color, double price)
    {
        this.id = id;
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.price = price;
    }

    // neatly organizes pet information
    public String getDisplay()
    {
        return "ID: " + id + " | Species: " + species + " | Age: " + age + " | Weight: " + weight + " lbs | Color: " + color + " | Price: $" + price;
    }

    // getters for pet attributes
    public int getId()
    {
        return id;
    }

    public double getPrice()
    {
        return price;
    }
}