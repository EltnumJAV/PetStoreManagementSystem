// cat class that inherits pet attributes
public class Cat extends Pet
{
    // creates a cat
    public Cat(int id, int age, int weight, String color, double price)
    {
        super(id, "CAT", age, weight, color, price);
    }

    // compares cat object to provided object based on price
    public int compareTo(Object obj)
    {
        double catPrice = this.getPrice();
        double objPrice = ((Cat) obj).getPrice();
        if(catPrice > objPrice)
        {
            return 1;
        }
        else if(catPrice < objPrice)
        {
            return -1;
        }
        return 0;
    }
}

