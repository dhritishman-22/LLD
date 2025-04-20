package Problems.Atm;

public class CashDispenser {
    private int cashAvailable;

    public CashDispenser(int cashDump) {
        this.cashAvailable = cashDump;
    }

    public synchronized void dispenseCash(int amount) {
        if (amount > cashAvailable) {
            throw new IllegalStateException("Cash insufficient! Remaining balance = " + cashAvailable);
        }
        cashAvailable -= amount;
        System.out.println("Cash dispensed = " + amount);
    }
}
