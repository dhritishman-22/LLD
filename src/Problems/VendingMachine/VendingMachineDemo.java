package Problems.VendingMachine;

import Problems.VendingMachine.models.Coin;
import Problems.VendingMachine.models.Note;
import Problems.VendingMachine.models.Product;

public class VendingMachineDemo {
    public static void run() {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        Product coke = new Product("Coke", 20);
        Product pepsi = new Product("Pepsi", 40);
        Product water = new Product("Water", 10);
        Product redBull = new Product("Redbull", 100);

        vendingMachine.getInventory().addProduct(coke, 5);
        vendingMachine.getInventory().addProduct(pepsi, 3);
        vendingMachine.getInventory().addProduct(water, 2);
        vendingMachine.getInventory().addProduct(redBull, 1);

        vendingMachine.selectProduct(coke);

        vendingMachine.insertNote(Note.FIFTY);

        vendingMachine.dispenseProduct();

        vendingMachine.returnChange();

        vendingMachine.selectProduct(redBull);

        vendingMachine.dispenseProduct();

        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.TEN);

        vendingMachine.dispenseProduct();

        vendingMachine.insertNote(Note.HUNDRED);

        vendingMachine.dispenseProduct();

        vendingMachine.returnChange();
    }
}