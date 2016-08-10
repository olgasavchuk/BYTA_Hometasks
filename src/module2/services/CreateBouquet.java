package module2.services;

import module1.reader.Reader;
import module2.models.Bouquet;

import static java.lang.System.*;

public class CreateBouquet {

    public static void main(String[] args) {

        Bouquet bouquet = new Bouquet();
        Reader reader = new Reader();

        int exit = 0;
        do {
            out.println("Flowers available to buy:\n" +
                    "1 - Rose\n" +
                    "2 - Lilia\n" +
                    "Please choose any:");
            switch (Integer.parseInt(reader.getLine())) {
                case 1:
                    bouquet.addFlower("Rose");
                    break;
                case 2:
                    bouquet.addFlower("Lilia");
                    break;
                default:
                    out.println("Invalid input. Try again");
            }
            out.println("Do you want to buy more? y/n");
            switch (reader.getLine()) {
                case "y":
                    break;
                case "n":
                    exit = 1;
                    break;
                default:
                    out.println("Let it be yes :)");
            }
        } while (exit == 0);
        out.println("Bouquet Cost is: " + bouquet.getCost());
        bouquet.showBouquet();
    }
}
