package module1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    public static Double summarize(Double x, Double y){
        return x+y;
    }

    public static Double subtraction(Double x, Double y){
        return x-y;
    }

    public static Double multiplication(Double x, Double y){
        return x*y;
    }

    public static Double division(Double x, Double y){
        return x/y;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter number 1:");
        Double number1 = Double.parseDouble(reader.readLine());
        System.out.println("Enter number 2:");
        Double number2 = Double.parseDouble(reader.readLine());

        System.out.println("x+y="+summarize(number1,number2));
        System.out.println("x-y="+subtraction(number1, number2));
        System.out.println("x*y="+multiplication(number1, number2));
        System.out.println("x/y="+division(number1, number2));

        System.out.print("Done. Have a nice day!");
    }
}
