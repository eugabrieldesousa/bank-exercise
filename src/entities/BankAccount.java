package entities;

public class BankAccount {
    private int numberAccount;
    private String holderName;
    private double deposit;

    public static final double TAX = 5.0;  // Taxa de saque

    public BankAccount(String holderName, int numberAccount) {
        this.holderName = holderName;
        this.numberAccount = numberAccount;
    }

    public BankAccount(String holderName, int numberAccount, double initialDeposit) {
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }
        this.holderName = holderName;
        this.numberAccount = numberAccount;
        moneyDeposit(initialDeposit);
    }

    public void moneyDeposit(double quantity) {
        if (quantity <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        this.deposit += quantity;
    }

    public void withdrawMoney(double quantity) {
        if (quantity + TAX > this.deposit) {
            System.out.println("Insufficient funds!");
            return;
        }
        this.deposit -= (quantity + TAX);
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getDeposit() {
        return deposit;
    }

    @Override
    public String toString() {
        return "Account " + numberAccount +
                ", Holder: " + holderName +
                ", Balance: $" + String.format("%.2f", deposit);
    }
}
