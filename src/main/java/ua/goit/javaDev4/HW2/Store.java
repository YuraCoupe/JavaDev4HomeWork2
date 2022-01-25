package ua.goit.javaDev4.HW2;

import java.util.HashMap;

public class Store {
    HashMap<Character, Product> products = new HashMap<>();

    public HashMap<Character, Product> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Character, Product> products) {
        this.products = products;
    }
}
