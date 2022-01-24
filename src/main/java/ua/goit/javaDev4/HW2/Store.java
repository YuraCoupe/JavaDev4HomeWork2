package ua.goit.javaDev4.HW2;

import java.util.HashMap;

public class Store {
    HashMap<Integer, Character> goodsNames = new HashMap<>();
    HashMap<Integer, Float> prices = new HashMap<>();
    HashMap<Integer, Integer> actionQuantities = new HashMap<>();
    HashMap<Integer, Float> actionPrices = new HashMap<>();

    public HashMap<Integer, Character> getGoodsNames() {
        return goodsNames;
    }

    public void setGoodsNames(HashMap<Integer, Character> goodsNames) {
        this.goodsNames = goodsNames;
    }

    public HashMap<Integer, Float> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<Integer, Float> prices) {
        this.prices = prices;
    }

    public HashMap<Integer, Integer> getActionQuantities() {
        return actionQuantities;
    }

    public void setActionQuantities(HashMap<Integer, Integer> actionQuantities) {
        this.actionQuantities = actionQuantities;
    }

    public HashMap<Integer, Float> getActionPrices() {
        return actionPrices;
    }

    public void setActionPrices(HashMap<Integer, Float> actionPrices) {
        this.actionPrices = actionPrices;
    }
}
