package ua.goit.javaDev4.HW2;

import java.util.HashMap;

public class StoreDemo {
    public static void main(String[] args) {
        Store store = new Store();
        StoreService storeService = new StoreService();

        HashMap<Integer, Character> goods = new HashMap<>();
        goods.put(1, 'A');
        goods.put(2, 'B');
        goods.put(3, 'C');
        goods.put(4, 'D');
        storeService.setGoodsNames(store, goods);

        HashMap<Integer, Float> prices = new HashMap<>();
        prices.put(1, 1.25f);
        prices.put(2, 4.25f);
        prices.put(3, 1.00f);
        prices.put(4, 0.75f);
        storeService.setGoodsPrices(store, prices);

        HashMap<Integer, Integer> actionQuantities = new HashMap<>();
        actionQuantities.put(1, 3);
        actionQuantities.put(2, 0);
        actionQuantities.put(3, 6);
        actionQuantities.put(4, 0);
        storeService.setActionQuantities(store, actionQuantities);

        HashMap<Integer, Float> actionPrices = new HashMap<>();
        actionPrices.put(1, 3.00f);
        actionPrices.put(2, 0.00f);
        actionPrices.put(3, 5.00f);
        actionPrices.put(4, 0.00f);
        storeService.setActionPrices(store, actionPrices);

        String checkout = "ABCDABA";

        float totalCost = storeService.calculateTotalCost(store, checkout);

        System.out.println(totalCost);

    }
}
