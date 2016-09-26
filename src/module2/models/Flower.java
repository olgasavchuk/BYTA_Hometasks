package module2.models;

import module2.interfases.Buying;

public abstract class Flower implements Buying {

    protected String flowerName;
    protected int price = 0;

    public String getFlowerName() {
        return this.flowerName;
    }

    abstract public int getPrice();
}
