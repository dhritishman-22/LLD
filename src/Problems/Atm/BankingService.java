package Problems.Atm;

import Problems.Atm.transaction.Transaction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    public void createAccount(String number, double balance) {
        accounts.put(number, new Account(number, balance));
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void processTransaction(Transaction transaction) {
        transaction.execute();
    }
}
