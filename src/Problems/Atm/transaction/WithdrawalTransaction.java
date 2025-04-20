package Problems.Atm.transaction;

import Problems.Atm.Account;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(String id, Account account, double amount) {
        super(id, account, amount);
    }

    @Override
    public void execute() {
        account.debit(amount);
    }
}
