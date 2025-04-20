package Problems.Atm;

import Problems.Atm.transaction.DepositTransaction;
import Problems.Atm.transaction.Transaction;
import Problems.Atm.transaction.WithdrawalTransaction;

import java.util.UUID;

public class Atm {
    private final BankingService bankingService;
    private final CashDispenser cashDispenser;

    public Atm(BankingService bankingService, CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    public double checkBalance(String accountNumber) {
        Account account = bankingService.getAccount(accountNumber);
        return account.getBalance();
    }

    public void withdrawCash(String accountNumber, double amount) {
        Account account = bankingService.getAccount(accountNumber);
        if (account != null && account.getBalance() < amount) {
            System.out.println("Error: Insufficient balance.");
            return;
        }
        Transaction transaction = new WithdrawalTransaction(UUID.randomUUID().toString(), account, amount);
        bankingService.processTransaction(transaction);
        cashDispenser.dispenseCash((int) amount);
    }

    public void depositCash(String accountNumber, double amount) {
        Account account = bankingService.getAccount(accountNumber);
        Transaction transaction = new DepositTransaction(UUID.randomUUID().toString(), account, amount);
        bankingService.processTransaction(transaction);
    }

    public void authenticateUser(Card card) {
        //logic to authenticate
    }
}
