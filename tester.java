public class tester {
    public static void main(String[] args) {
        // Create a new bank account
        BankAccount bankAccount = new BankAccount("James", "Samson", 123456, 0);
        bankAccount.deposit(500);
        bankAccount.withdraw(200);
        bankAccount.accountSummary();

        // Create a new checking account
        CheckingAccount checkingAccount = new CheckingAccount("Sheila", "Samson", 654321, 0, 1.3);
        checkingAccount.deposit(1000);
        checkingAccount.processWithdrawal(700);
        checkingAccount.processWithdrawal(500);  // This should show an overdraft limit exceeded message
        checkingAccount.displayAccount();
    }
}
