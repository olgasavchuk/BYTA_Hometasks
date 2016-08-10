package module2.models;

import module2.interfases.Buying;

import java.util.HashMap;
import java.util.Map;

public class Bouquet implements Buying{

    Map<Flower, Integer> bouquet;

    public Bouquet() {
        this.bouquet = new HashMap<>();
    }

    public void addFlower(String flowerName) {

        if (this.bouquet.size() == 0) {
            this.setNewFlower(flowerName);
        } else {
            int exist = 0;
            Flower key = null;
            for (Map.Entry<Flower, Integer> entry : this.bouquet.entrySet()) {
                if (entry.getKey().flowerName.equals(flowerName)) {
                    exist = 1;
                    key = entry.getKey();
                    break;
                }
            }
            if (exist == 0) {
                this.setNewFlower(flowerName);
            } else {
                this.bouquet.put(key, this.bouquet.get(key) + 1);
            }
        }
    }

    public int getCost() {
        int bouquetCost = 0;
        for (Map.Entry<Flower, Integer> entry : this.bouquet.entrySet()) {
            bouquetCost += entry.getKey().getPrice() * entry.getValue();
        }
        return bouquetCost;
    }

    public void showBouquet() {
        for (Map.Entry<Flower, Integer> entry : this.bouquet.entrySet()) {
            if (entry.getValue() > 0) System.out.println(entry.getKey().getFlowerName() + ": " + entry.getValue());
        }
    }

    private void setNewFlower(String flowerName) {
        switch (flowerName) {
            case "Rose":
                Flower rose = new Rose();
                this.bouquet.put(rose, 1);
                break;
            case "Lilia":
                Flower lilia = new Lilia();
                this.bouquet.put(lilia, 1);
                break;
        }
    }
}
