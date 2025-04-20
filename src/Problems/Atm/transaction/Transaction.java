package Problems.Atm.transaction;

import Problems.Atm.Account;

public abstract class Transaction {
    protected final String id;
    protected final Account account;
    protected final double amount;

    public Transaction(String id, Account account, double amount) {
        this.id = id;
        this.account = account;
        this.amount = amount;
    }

    public abstract void execute();
}
