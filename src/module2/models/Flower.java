package module2.models;

public abstract class Flower{

    protected String flowerName;
    protected int price = 0;

    public String getFlowerName() {
        return this.flowerName;
    }

    abstract public int getPrice();
}
