package application;

import entities.BankAccount;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter account holder: ");
        String holderName = sc.nextLine();

        System.out.print("Is there an initial deposit (y/n)? ");
        char isInitialDeposit = sc.next().charAt(0);
        sc.nextLine();

        BankAccount account;

        if (isInitialDeposit == 'y' || isInitialDeposit == 'Y') {
            System.out.print("Enter initial deposit value: ");
            double deposit = sc.nextDouble();
            sc.nextLine();
            account = new BankAccount(holderName, accountNumber, deposit);
        } else {
            account = new BankAccount(holderName, accountNumber);
        }

        System.out.println("\nAccount data:");
        System.out.println(account);

        // Opções de transações
        System.out.print("\nEnter a deposit value: ");
        double depositValue = sc.nextDouble();
        account.moneyDeposit(depositValue);
        System.out.println("Updated account data:");
        System.out.println(account);

        System.out.print("\nEnter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        account.withdrawMoney(withdrawValue);
        System.out.println("Updated account data:");
        System.out.println(account);

        sc.close();
    }
}
