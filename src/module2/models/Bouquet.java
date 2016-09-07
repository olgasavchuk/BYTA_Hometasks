package module2.models;

import module2.exceptions.EmptyCostException;
import module2.interfases.Buying;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bouquet implements Buying {

    protected Map<Flower, Integer> flowers;
    private int bouquetCost;

    public Bouquet() {
        this.flowers = new HashMap<>();
        this.bouquetCost = 0;
    }

    public Map<Flower, Integer> getFlowers() {
        return flowers;
    }

    public void addFlower(String flowerName) {

        if (this.flowers.size() == 0) {
            this.setNewFlower(flowerName);
        } else {
            int exist = 0;
            Flower key = null;
            for (Map.Entry<Flower, Integer> entry : this.flowers.entrySet()) {
                if (entry.getKey().flowerName.equals(flowerName)) {
                    exist = 1;
                    key = entry.getKey();
                    break;
                }
            }
            if (exist == 0) {
                this.setNewFlower(flowerName);
            } else {
                this.flowers.put(key, this.flowers.get(key) + 1);
            }
        }
    }

    public int getCost() throws EmptyCostException {

        for (Map.Entry<Flower, Integer> entry : this.flowers.entrySet()) {
            this.bouquetCost += entry.getKey().getPrice() * entry.getValue();
        }
        return this.bouquetCost;
    }

    public void showBouquet() throws IOException {
        for (Map.Entry<Flower, Integer> entry : this.flowers.entrySet()) {
            if (entry.getValue() > 0) System.out.println(entry.getKey().getFlowerName() + ": " + entry.getValue());
        }
    }

    private void setNewFlower(String flowerName) {
        switch (flowerName) {
            case "Rose":
                Flower rose = new Rose();
                this.flowers.put(rose, 1);
                break;
            case "Lilia":
                Flower lilia = new Lilia();
                this.flowers.put(lilia, 1);
                break;
        }
    }
}
