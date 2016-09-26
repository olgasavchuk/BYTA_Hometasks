package module2.services;

import module1.reader.Reader;
import module2.exceptions.EmptyCostException;
import module2.exceptions.NonexistentFlowerException;
import module2.exceptions.WrongAnswerException;
import module2.interfases.Buying;
import module2.models.Bouquet;

import java.io.IOException;

public class CreateBouquet {

    public static void main(String[] args) {

        Bouquet bouquet = null;
        String customer_name;
        Reader reader = new Reader();
        StringBuilder sb = new StringBuilder();

        try {
            bouquet = new Bouquet();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Enter your name: ");
        customer_name = reader.getLine();

        sb.append("\nChoose any flower:\n")
                .append("Rose - put 1\n")
                .append("Lilia - put 2\n")
                .append("Your choice: ");

        int exit = 0;
        do {
            System.out.print(sb.toString());
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
                System.out.println("Invalid input. Try again");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Input is empty. Try again");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.print("Bouquet is empty");
                e.printStackTrace();
            }
            System.out.print("Do you want more? y/n: ");
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
                System.out.println("Let it be yes :)");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Input is empty. Try again");
                e.printStackTrace();
            }
        } while (exit == 0);

        getBouquetCost(bouquet);

        serviceOperations(bouquet, customer_name);
    }

    private static void getBouquetCost(Buying bouquet) {
        try {
            if (bouquet == null) throw new NullPointerException();
            if (bouquet.getPrice() == 0) throw new EmptyCostException ("Cost is empty");
            System.out.println("\nBouquet Cost is: " + bouquet.getPrice());
        } catch (EmptyCostException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.print("Bouquet is empty");
            e.printStackTrace();
        }
    }

    private static void serviceOperations(Bouquet bouquet, String customerName) {

        Report report = new Report();

        try {
            if (bouquet == null) throw new NullPointerException();
            bouquet.showBouquet();

            FileService file = new FileService();
            file.writeToSource(bouquet);
            System.out.println("TOTAL FOR ALL BOUQUETS: " + report.getReport(file.getFilesList()));
            System.out.println("\nRead from .txt");
            file.readFromSource();

            (new DBService()).writeToSource(bouquet, customerName);

            XMLService xmlService = new XMLService();
            xmlService.writeToSource(bouquet, bouquet.getPrice());
            System.out.println("\nRead from .xml");
            xmlService.readFromSource();

            JSONService jSONService = new JSONService();
            jSONService.writeToSource(bouquet);
            System.out.println("\nRead from .json");
            jSONService.readFromSource();

        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
    }
}
