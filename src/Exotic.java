public class Exotic extends Pet
{
    // exotic constructor
    public Exotic(int id, String species, int age, int weight, String color, double price)
    {
        super(id, species, age, weight, color, price);
    }

    // compares exotic object to provided object based on price
    public int compareTo(Object obj)
    {
        double exoticPrice = this.getPrice();
        double objPrice = ((Exotic) obj).getPrice();

        if(exoticPrice > objPrice)
        {
            return 1;
        }
        else if(exoticPrice < objPrice)
        {
            return -1;
        }
        return 0;
    }
}
