public class CalculatorLogic {

    public double sumNumbers(double num1, double num2) {
        return num1 + num2;
    }

    public double subNumbers(double num1, double num2) {
        return num1 - num2;
    }

    public double divNumbers(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("You divide by zero");
        }
        return num1 / num2;
    }

    public double mulNumbers(double num1, double num2) {
        return num1 * num2;
    }
}
