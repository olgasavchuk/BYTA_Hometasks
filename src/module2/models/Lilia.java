package module2.models;

public class Lilia extends Flower {

    private static final int TAX = 5;

    public Lilia() {
        this.flowerName = "Lilia";
        this.price = 50;
    }

    public int getPrice() {
        return this.price + TAX;
    }
}
