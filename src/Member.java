import java.util.ArrayList;

public abstract class Member
{
    // member attributes
    private int id;
    private String firstName;
    private String lastName;
    private double moneySpent;
    private int petsPurchased;
    private int transactionCount;
    private int passcode;

    // member constructor
    public Member(int id, String firstName, String lastName, int passcode)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passcode = passcode;
    }

    // neatly organizes member information
    public abstract String getDisplay();

    // getters for member attributes
    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public double getMoneySpent()
    {
        return moneySpent;
    }

    public int getPetsPurchased()
    {
        return petsPurchased;
    }

    public int getTransactionCount()
    {
        return transactionCount;
    }

    // setters for member attributes
    public void setMoneySpent(double newMoneySpent)
    {
        moneySpent = newMoneySpent;
    }

    public void setPetsPurchased(int newPetsPurchased)
    {
        petsPurchased = newPetsPurchased;
    }

    public void setTransactionCount(int newTransactionCount)
    {
        transactionCount = newTransactionCount;
    }
}