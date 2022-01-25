package ua.goit.javaDev4.HW2;

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

    public Product(Character name, float price, int actionQuantity, float actionPrice) {
        this.name = name;
        this.price = price;
        this.actionQuantity = actionQuantity;
        this.actionPrice = actionPrice;
    }

    public Character getName() {
        return name;
    }

    public void setName(Character name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getActionQuantity() {
        return actionQuantity;
    }

    public void setActionQuantity(int actionQuantity) {
        this.actionQuantity = actionQuantity;
    }

    public float getActionPrice() {
        return actionPrice;
    }

    public void setActionPrice(float actionPrice) {
        this.actionPrice = actionPrice;
    }
}
