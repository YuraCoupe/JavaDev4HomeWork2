package ua.goit.javaDev4.HW2;

import java.util.HashMap;

public class StoreDemo {
    public static void main(String[] args) {
        Store store = new Store();
        StoreService storeService = new StoreService();
        HashMap<Character, Product> products = storeService.createProductsHashMap();
        storeService.storeInit(store, products);

        String checkout = "ABCDABA";

        float totalCost = storeService.calculateTotalCost(store, checkout);

        System.out.println("Total cost is " + totalCost);
    }


}

