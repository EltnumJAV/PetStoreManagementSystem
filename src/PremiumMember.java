// premium member class that inherits from member
public class PremiumMember extends Member
{
        // premium member due-paid attribute
        private boolean duePaid;

        // creates a premium member
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

        // neatly organizes premium member's information
        public String getDisplay()
        {
            return super.getDisplay() + " | Monthly Fee Paid: " + this.isDuePaid();
        }
}
