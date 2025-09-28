// You must implement the logic inside these methods.

import java.util.*;

public class InventoryManager {

    private final Map<String, Integer> productStock;
    private final Set<String> productCategories;
    private final List<String> salesHistory;

    public InventoryManager(){
        productStock = new HashMap<>();
        productCategories = new HashSet<>();
        salesHistory = new ArrayList<>();
    }

    // Task 1: Use a Map to store product SKUs and their stock quantities.
    public void addProductStock(String sku, int quantity) {
        // TODO: Add the product SKU and its initial stock quantity.

        if(sku==null || sku.isBlank()){
            throw new IllegalArgumentException("SKU cannot be null or blank");
        }
        if(quantity<=0){
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        productStock.put(sku, productStock.getOrDefault(sku, 0) + quantity);        
    }

    public int getProductStock(String sku) {
        // TODO: Return the current stock quantity for a specific product SKU.
        // If the product does not exist, return 0.
        if(sku==null || sku.isBlank())
        return 0;
        return productStock.getOrDefault(sku, 0);
    }

    // Task 2: Use a Set to store the unique names of product categories.
    public void addCategory(String categoryName) {
        // TODO: Add a new, unique product category name to the set.
        if(categoryName==null || categoryName.isBlank()){
            throw new IllegalArgumentException("Category name cannot be null or blank");
        }
        productCategories.add(categoryName.trim());
    }

    public Set<String> getAvailableCategories() {
        // TODO: Return the set of all unique product categories.
        return new HashSet<>(productCategories);
    }

    // Task 3: Use a List to maintain a chronological log of sales.
    public void recordSale(String sku) {
        // TODO: Add the SKU of a sold product to the sales history log.
        // This list should maintain the order of sales as they happen.
        if(sku==null || sku.isBlank()){
            throw new IllegalArgumentException("SKU cannot be null or blank");
        }
        salesHistory.add(sku);
    }

    public List<String> getSalesHistory() {
        // TODO: Return the complete list of sales transactions.
        return new ArrayList<>(salesHistory);
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProductStock("SKU123", 50);
        manager.addProductStock("SKU123", 20);

        System.out.println("Stock for SKU123: " + manager.getProductStock("SKU123"));
        System.out.println("Stock for SKU999: " + manager.getProductStock("SKU999"));

        manager.addCategory("Electronics");
        manager.addCategory("Home Appliances");
        manager.addCategory("Electronics");
        System.out.println("Available Categories: " + manager.getAvailableCategories());

        manager.recordSale("SKU123");
        manager.recordSale("SKU456");
        System.out.println("Sales History: " + manager.getSalesHistory());
    }
}
