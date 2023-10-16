public class RegularMember extends Member
{
    // regular member constructor
    public RegularMember(int id, String firstName, String lastName, int passcode)
    {
        super(id, firstName, lastName, passcode);
    }

    // neatly organizes regular member information
    public String getDisplay()
    {
        return "Member ID: " + this.getId() + " | Name: " + this.getFirstName() + " " + this.getLastName() + " | Money Spent: $" + this.getMoneySpent();
    }
}
