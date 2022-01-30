package ua.goit.javaDev4.HW2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.mockito.Mockito;

import java.util.HashMap;

public class StoreServiceTest {

    @Test
    public void createProductsHashMapTestTrue() {
        StoreService storeServiceMock = Mockito.mock(StoreService.class);
        HashMap<Character, Product> products = new HashMap<>();
        Product a = new Product('A', 1.25f, 3, 3.00f);
        Product b = new Product('B', 4.25f, 0, 0.00f);
        Product c = new Product('C', 1.00f, 6, 5.00f);
        Product d = new Product('D', 0.75f, 0, 0.00f);
        products.put(a.getName(), a);
        products.put(b.getName(), b);
        products.put(c.getName(), c);
        products.put(d.getName(), d);

        Mockito.when(storeServiceMock.createProductsHashMap()).thenReturn(products);
        HashMap<Character, Product> productsExpected = storeServiceMock.createProductsHashMap();

        StoreService storeService = new StoreService();
        HashMap<Character, Product> productsActual = storeService.createProductsHashMap();

        Assertions.assertEquals(productsExpected, productsActual);
    }

    @Test
    public void createProductsHashMapTestFalse() {
        StoreService storeServiceMock = Mockito.mock(StoreService.class);
        HashMap<Character, Product> products = new HashMap<>();
        Product a = new Product('A', 0.25f, 3, 3.00f);
        Product b = new Product('B', 7.25f, 7, 0.00f);
        Product c = new Product('C', 5.00f, 6, 5.00f);
        products.put(a.getName(), a);
        products.put(b.getName(), b);
        products.put(c.getName(), c);

        Mockito.when(storeServiceMock.createProductsHashMap()).thenReturn(products);
        HashMap<Character, Product> productsExpected = storeServiceMock.createProductsHashMap();

        StoreService storeServiceActual = new StoreService();
        HashMap<Character, Product> productsActual = storeServiceActual.createProductsHashMap();

        Assertions.assertNotEquals(productsExpected, productsActual);
    }

    @Test
    public void storeInitTestTrue() {
        StoreService storeService = new StoreService();
        HashMap<Character, Product> products = storeService.createProductsHashMap();

        Store storeExpected = new Store();
        storeExpected.setProducts(products);

        Store storeActual = new Store();
        storeService.storeInit(storeActual, products);

        Assertions.assertEquals(storeExpected, storeActual);
    }

    @Test
    public void storeInitTestFalse() {
        StoreService storeService = new StoreService();
        HashMap<Character, Product> productsExpected = storeService.createProductsHashMap();

        Store storeExpected = new Store();
        storeExpected.setProducts(productsExpected);

        Product d = new Product('D', 5.75f, 7, 6.00f);
        HashMap<Character, Product> productsActual = storeService.createProductsHashMap();
        productsActual.put(d.getName(), d);

        Store storeActual = new Store();
        storeService.storeInit(storeActual, productsActual);

        Assertions.assertNotEquals(storeExpected, storeActual);
    }

    @Test
    public void calculateTotalCostTestTrue() {
        Float totalCostExpected = 13.25f;

        Store store = new Store();
        StoreService storeService = new StoreService();
        HashMap<Character, Product> products = storeService.createProductsHashMap();
        storeService.storeInit(store, products);

        String checkout = "ABCDABA";

        float totalCostActual = storeService.calculateTotalCost(store, checkout);

        Assertions.assertEquals(totalCostExpected, totalCostActual);
    }

    @Test
    public void calculateTotalCostTestFalse() {
        Float totalCostExpected = 13.25f;

        Store store = new Store();
        StoreService storeService = new StoreService();
        HashMap<Character, Product> products = storeService.createProductsHashMap();
        storeService.storeInit(store, products);

        String checkout = "ABCDABAA";

        float totalCostActual = storeService.calculateTotalCost(store, checkout);

        Assertions.assertNotEquals(totalCostExpected, totalCostActual);
    }
}
