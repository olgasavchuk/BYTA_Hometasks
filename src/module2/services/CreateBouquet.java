package module2.services;

import module1.reader.Reader;
import module2.exceptions.EmptyCostException;
import module2.exceptions.NonexistentFlowerException;
import module2.exceptions.WrongAnswerException;
import module2.models.Bouquet;

import java.io.File;
import java.io.IOException;

import static java.lang.System.*;

public class CreateBouquet {

    public static void main(String[] args) {

        Bouquet bouquet = null;
        Report report = new Report();
        String customer_name;

        try {
            bouquet = new Bouquet();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Reader reader = new Reader();
        out.println("Enter your name: ");
        customer_name = reader.getLine();

        int exit = 0;
        do {
            out.println("Flowers available to buy:\n" +
                    "1 - Rose\n" +
                    "2 - Lilia\n" +
                    "Please choose any:");
            try {
                if (bouquet == null) throw new NullPointerException();
                switch (Integer.parseInt(reader.getLine())) {
                    case 1:
                        bouquet.addFlower("Rose");
                        break;
                    case 2:
                        bouquet.addFlower("Lilia");
                        break;
                    default:
                        throw new NonexistentFlowerException("We don't have such flower");
                }
            } catch (NonexistentFlowerException e) {
                out.println("Invalid input. Try again");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                out.println("Input is empty. Try again");
                e.printStackTrace();
            } catch (NullPointerException e) {
                out.print("Bouquet is empty");
                e.printStackTrace();
            }
            out.println("Do you want to buy more? y/n");
            try {
                switch (reader.getLine()) {
                    case "y":
                        break;
                    case "n":
                        exit = 1;
                        break;
                    default:
                        throw new WrongAnswerException();
                }
            } catch (WrongAnswerException e) {
                out.println("Let it be yes :)");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                out.println("Input is empty. Try again");
                e.printStackTrace();
            }
        } while (exit == 0);

        try {
            if (bouquet == null) throw new NullPointerException();
            if (bouquet.getCost() == 0) throw new EmptyCostException ("Cost is empty");
            out.println("Bouquet Cost is: " + bouquet.getCost());
        } catch (EmptyCostException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            out.print("Bouquet is empty");
            e.printStackTrace();
        }

        try {
            if (bouquet == null) throw new NullPointerException();
            bouquet.showBouquet();

            FileService file = new FileService();
            file.writeToFile(bouquet);

            (new DBService()).writeBouquet(bouquet, customer_name);
            System.out.println("TOTAL FOR ALL BOUQUETS: " + report.getReport(file.getFilesList()));
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
            out.println("Something went wrong");
        }
    }
}
