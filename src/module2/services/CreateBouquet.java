package module2.services;

import module1.reader.Reader;
import module2.exceptions.EmptyCostException;
import module2.exceptions.NonexistentFlowerException;
import module2.exceptions.WrongAnswerException;
import module2.models.Bouquet;

import java.io.IOException;

import static java.lang.System.*;

public class CreateBouquet {

    public static void main(String[] args) {

        Bouquet bouquet = null;
        Report report = new Report();
        String customer_name;
        Reader reader = new Reader();

        try {
            bouquet = new Bouquet();
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.print("Enter your name: ");
        customer_name = reader.getLine();

        int exit = 0;
        do {
            out.print("\nChoose any flower:\n" + "Rose - put 1\n" + "Lilia - put 2\n" + "Your choice: ");
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
            out.print("Do you want more? y/n: ");
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
            out.println("\nBouquet Cost is: " + bouquet.getCost());
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
            out.println("TOTAL FOR ALL BOUQUETS: " + report.getReport(file.getFilesList()));

            (new DBService()).writeBouquet(bouquet, customer_name);

            XMLService xmlService = new XMLService();
            xmlService.writeToDocument(bouquet, bouquet.getCost());

        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
            out.println("Something went wrong");
        }
    }
}
