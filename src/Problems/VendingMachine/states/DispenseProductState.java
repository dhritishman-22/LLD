package Problems.VendingMachine.states;

import Problems.VendingMachine.models.Coin;
import Problems.VendingMachine.models.Note;
import Problems.VendingMachine.models.Product;
import Problems.VendingMachine.VendingMachine;

public class DispenseProductState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public DispenseProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already made. Please collect the dispensed product.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment already made. Please collect the dispensed product.");
    }

    @Override
    public void dispenseProduct() {
        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.getInventory().updateStock(product, vendingMachine.getInventory().getStock(product) - 1);
        System.out.println("Product dispensed: " + product.getName());
        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect the dispensed product first.");
    }
}
