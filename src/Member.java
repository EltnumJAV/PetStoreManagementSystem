// abstract class for members from which different types of members will inherit
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

    // creates a member
    public Member(int id, String firstName, String lastName, int passcode)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passcode = passcode;
    }

    // neatly organizes member information
    public String getDisplay()
    {
        return "Member ID: " + this.getId() + " | Name: " + this.getFirstName() + " " + this.getLastName() + " | Money Spent: $" + this.getMoneySpent() + " | Pets Purchased: " + this.getPetsPurchased() + " | Total Transactions: " + this.getTransactionCount();
    }

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

    public int getPasscode()
    {
        return passcode;
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