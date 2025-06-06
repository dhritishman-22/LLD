package Problems.VendingMachine;

import Problems.VendingMachine.models.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final Map<Product, Integer> products;

    public Inventory() {
        products = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int stock) {
        products.put(product, stock);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void updateStock(Product product, int stock) {
        products.put(product, stock);
    }

    public int getStock(Product product) {
        return products.getOrDefault(product, 0);
    }

    public boolean isAvailable(Product product) {
        return products.containsKey(product) && products.get(product) > 0;
    }
}
