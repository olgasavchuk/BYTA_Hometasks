package module2.models;

public abstract class Flower{

    String flowerName;
    int price = 0;

    public String getFlowerName() {
        return this.flowerName;
    }

    abstract public int getPrice();
}
