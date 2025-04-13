package Problems.VendingMachine;

import Problems.VendingMachine.states.*;
import Problems.VendingMachine.models.Coin;
import Problems.VendingMachine.models.Note;
import Problems.VendingMachine.models.Product;

public class VendingMachine {
    private static VendingMachine instance;
    private final Inventory inventory;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private VendingMachineState currentState;
    private Product selectedProduct;
    private int totalPayment;

    private VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseProductState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = new IdleState(this);
        selectedProduct = null;
        totalPayment = 0;
    }

    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setState(VendingMachineState state) {
        currentState = state;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void resetPayment() {
        totalPayment = 0;
    }

    public void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    public void addNote(Note note) {
        totalPayment += note.getValue();
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void resetSelectedProduct() {
        selectedProduct = null;
    }

    public void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

}
