public class PremiumMember extends Member
{
        // premium member due-paid attribute
        private boolean duePaid;

        // premium member constructor
        public PremiumMember(int id, String firstName, String lastName, boolean duePaid, int passcode)
        {
            super(id, firstName, lastName, passcode);
            this.duePaid = duePaid;
        }

        // returns whether member's due is paid or not
        public boolean isDuePaid()
        {
            return duePaid;
        }

        // sets the due-paid status of member
        public void setDuePaid(boolean newDuePaidStatus)
        {
            duePaid = newDuePaidStatus;
        }

        // neatly organizes premium member information
        public String getDisplay()
        {
            return "Member ID: " + this.getId() + " | Name: " + this.getFirstName() + " " + this.getLastName() + " | Money Spent: $ " + this.getMoneySpent() + " | Due Paid: " + duePaid;
        }
}
