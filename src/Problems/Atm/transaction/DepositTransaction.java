package Problems.Atm.transaction;

import Problems.Atm.Account;

public class DepositTransaction extends Transaction {

    public DepositTransaction(String id, Account account, double amount) {
        super(id, account, amount);
    }

    @Override
    public void execute() {
        account.credit(amount);
    }
}
