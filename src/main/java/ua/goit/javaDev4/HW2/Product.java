package ua.goit.javaDev4.HW2;

import java.util.Objects;
/* following convention a class should have structure like

variables
constructors
methods (equals hashcode toString in the end
 */
public class Product {
    private Character name;
    private float price;
    private int actionQuantity;
    private float actionPrice;

    @Override
    public String toString() {
        return "Product{" +
                "name=" + name +
                ", price=" + price +
                ", actionQuantity=" + actionQuantity +
                ", actionPrice=" + actionPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 && actionQuantity == product.actionQuantity && Float.compare(product.actionPrice, actionPrice) == 0 && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, actionQuantity, actionPrice);
    }

    public Product(Character name, float price, int actionQuantity, float actionPrice) {
        this.name = name;
        this.price = price;
        this.actionQuantity = actionQuantity;
        this.actionPrice = actionPrice;
    }

    public Character getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getActionQuantity() {
        return actionQuantity;
    }

    public float getActionPrice() {
        return actionPrice;
    }
}
