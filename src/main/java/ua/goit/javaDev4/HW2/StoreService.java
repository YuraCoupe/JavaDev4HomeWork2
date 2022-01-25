package ua.goit.javaDev4.HW2;

import java.util.*;
import java.util.stream.Collectors;

public class StoreService {

    public void storeInit(Store store, HashMap<Character, Product> products) {
        store.products.putAll(products);
    }

    public  HashMap<Character, Product> createProductsHashMap() {
        HashMap<Character, Product> products = new HashMap<>();
        Product A = new Product('A', 1.25f, 3, 3.00f);
        Product B = new Product('B', 4.25f, 0, 0.00f);
        Product C = new Product('C', 1.00f, 6, 5.00f);
        Product D = new Product('D', 0.75f, 0, 0.00f);
        products.put(A.getName(), A);
        products.put(B.getName(), B);
        products.put(C.getName(), C);
        products.put(D.getName(), D);
        return products;
    }

    public Product getProductByName(Store store, Character name) {
        return store.getProducts().get(name);
    }

    public float calculateTotalCost(Store store, String checkout) {
        float totalCost = 0;
        List<Character> goodsInChar = checkout.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Map<Character, Integer> countGoods = goodsInChar.stream().collect(HashMap::new, (m, c) -> {
            if (m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else
                m.put(c, 1);
        }, HashMap::putAll);
        for (Map.Entry<Character, Product> entry : store.getProducts().entrySet()) {
            if (countGoods.get(entry.getKey()) != null) {

                if ((Integer) countGoods.get(entry.getKey()).compareTo(entry.getValue().getActionQuantity()) >= 0 && entry.getValue().getActionQuantity() != 0) {
                    totalCost += (Integer) countGoods.get(entry.getKey()) / entry.getValue().getActionQuantity()
                            * entry.getValue().getActionPrice()
                            + (Integer) countGoods.get(entry.getKey()) % entry.getValue().getActionQuantity()
                            * entry.getValue().getPrice();
                } else {
                    totalCost += countGoods.get(entry.getKey()) * entry.getValue().getPrice();
                }
            }
        }
        return totalCost;
    }
}
