public class CheckingAccount extends BankAccount {
    // Additional instance variables for the CheckingAccount class
    private double intRate;
    
    // Constructor
    public CheckingAccount(String firstName, String lastName, int accountID, double balance,
                           double intRate) {
        // Call to the superclass constructor
        super(firstName, lastName, accountID, balance);
        this.intRate = intRate;
    }

    // Getter and Setter methods for the new variables
    public double getIntRate() {
        return intRate;
    }

    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }

    // new withdraw method to handle overdraft
    public void processWithdrawal(double amount) {
        if (amount > 0) {
            if (amount <= getBalance()) {
                setBalance(getBalance() - amount);
                System.out.println("Withdrew: " + amount + ", New Balance: " + getBalance());
            } else {
                setBalance((getBalance() - amount) - 30);
                System.out.println("Withdrew: " + amount + " using overdraft, incuring a $30 penalty. New Balance: " + getBalance() + ".");
            } 
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void displayAccount() {
        System.out.println("Account First Name: " + getFirstName());
        System.out.println("Account Last Name: " + getLastName());
        System.out.println("Account ID: " + getAccountID());
        System.out.println("Account Balance: " + getBalance());
        System.out.println("Account Interest Rate: " + intRate);
    }
}
