public class Dog extends Pet
{
    // dog constructor
    public Dog(int id, int age, int weight, String color, double price)
    {
        super(id, "Dog", age, weight, color, price);
    }

    // compares dog object to provided object based on price
    public int compareTo(Object obj)
    {
        double dogPrice = this.getPrice();
        double objPrice = ((Dog) obj).getPrice();

        if(dogPrice > objPrice)
        {
            return 1;
        }
        else if(dogPrice < objPrice)
        {
            return -1;
        }
        return 0;
    }
}
