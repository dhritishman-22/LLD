package Problems.VendingMachine.states;

import Problems.VendingMachine.models.Coin;
import Problems.VendingMachine.models.Note;
import Problems.VendingMachine.models.Product;

public interface VendingMachineState {
    void selectProduct(Product product);

    void insertCoin(Coin coin);

    void insertNote(Note note);

    void dispenseProduct();

    void returnChange();
}
