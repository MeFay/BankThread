public class BankAccount {
    private double balance;
    public BankAccount() {
        this.balance = 0.0;
    }
    public double getBalance() {
        return balance;
    }
    private void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposit: " + amount);
            System.out.println("Balance after deposit: " + getBalance());
        } else {
            System.out.println("Invalid deposit amount: " + amount);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0) {
            if (getBalance() >= amount) {
                setBalance(getBalance() - amount);
                System.out.println("Withdrawal: " + amount);
                System.out.println("Balance after withdrawal: " + getBalance());
            } else {
                System.out.println("Try to Withdraw: " + amount);
                System.out.println("Insufficient funds. Withdrawal cancelled.");
            }
        } else {
            System.out.println("Invalid withdrawal amount: " + amount);
        }
    }
}
