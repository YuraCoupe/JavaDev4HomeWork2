package ua.goit.javaDev4.HW2;

import java.util.HashMap;
import java.util.Objects;

public class Store {
    HashMap<Character, Product> products = new HashMap<>();

    public HashMap<Character, Product> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Character, Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(products, store.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}
