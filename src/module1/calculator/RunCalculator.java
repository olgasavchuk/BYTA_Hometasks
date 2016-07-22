package module1.calculator;

import module1.reader.Reader;

import java.io.IOException;

public class RunCalculator {

    public static void main(String[] args) throws IOException {

        String operation;
        int number;
        int error;
        boolean isOperationCorrect;

        Reader reader = new Reader();
        Calculator calculator = new Calculator();
        String[] operationList = new String[]{"+", "-", "*", "/"};
        String operations = "";

        for (String s: operationList) {
            operations += s;
        }

        System.out.println("RESULT: " + calculator.getResult());

        do {
            do {
                System.out.println("Select the operation: +, -, *, /");
                operation = reader.getLine();
                isOperationCorrect = operations.contains(operation);
                if (!(isOperationCorrect)) {
                    System.out.println("Incorrect operation. Try again");
                }
            } while (!(isOperationCorrect));

            do {
                error = 0;
                System.out.print("Insert number: ");
                number = Integer.parseInt(reader.getLine());
                if ((number == 0) && (operation.equals("/"))) {
                    System.out.println("Can't divide by zero. Try again");
                    error = 1;
                }
            } while (error != 0);

            switch (operation) {
                case "+":
                    calculator.summarize(number);
                    break;
                case "-":
                    calculator.subtraction(number);
                    break;
                case "*":
                    calculator.multiplication(number);
                    break;
                case "/":
                    calculator.division(number);
                    break;
            }
            System.out.println("RESULT: " + calculator.getResult());
            System.out.print("Do you want to continue: y/n ? ");
        } while (!(reader.getLine().equals("n")));
    }
}
