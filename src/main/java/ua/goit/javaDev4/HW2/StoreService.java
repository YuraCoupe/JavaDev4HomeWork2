package ua.goit.javaDev4.HW2;

import java.util.*;
import java.util.stream.Collectors;

public class StoreService {

    public void setGoodsNames(Store store, HashMap<Integer, Character> goodsNames) {
            store.setGoodsNames(goodsNames);
        }

    public void setGoodsPrices(Store store, HashMap<Integer, Float> goodsPrices) {
        store.setPrices(goodsPrices);
    }

    public void setActionQuantities(Store store, HashMap<Integer, Integer> actionQuantities) {
        store.setActionQuantities(actionQuantities);
    }

    public void setActionPrices(Store store, HashMap<Integer, Float> actionPrices) {
        store.setActionPrices(actionPrices);
    }

    public float calculateTotalCost(Store store, String checkout) {
        float totalCost = 0;
        List<Character> goodsInChar = checkout.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        Map<Character, Integer> countGoods = goodsInChar.stream().collect(HashMap::new, (m, c) -> {
            if(m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else
                m.put(c, 1);
        }, HashMap::putAll);
        System.out.println(countGoods.toString());
        for(Map.Entry entry: store.getGoodsNames().entrySet()) {
            if ((Integer) countGoods.get(entry.getValue()).compareTo(store.getActionQuantities().get(entry.getKey())) >= 0 && store.getActionQuantities().get(entry.getKey()) != 0) {
                totalCost += (Integer) countGoods.get(entry.getValue()) / store.getActionQuantities().get(entry.getKey())
                        * store.getActionPrices().get(entry.getKey())
                        + (Integer) countGoods.get(entry.getValue()) % store.getActionQuantities().get(entry.getKey())
                        * store.getPrices().get(entry.getKey());
            } else {
                totalCost += countGoods.get(entry.getValue()) * store.getPrices().get(entry.getKey());
            }
            System.out.println(totalCost);
        }
        return totalCost;
    }
}
