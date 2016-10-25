package module1.calculator;

public class Calculator {

    int result;

    public Calculator() {
        this.result = 0;
    }

    public int getResult() {
        return result;
    }

    public void summarize(int number){
        this.result += number;
    }


    public void subtraction(int number){
        this.result -= number;
    }

    public void multiplication(int number){
        this.result *= number;
    }

    public void division(int number){
        this.result /= number;
    }


}
