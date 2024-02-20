package impl;

import interfaces.Calculable;
import interfaces.Loggable;

public class ComplexCalculatorWithLog implements Calculable {

    private Loggable log;

    public ComplexCalculatorWithLog(Loggable log) {
        this.log = log;
    }
    // Сложение
    @Override
    public ComplexNumber addition(ComplexNumber number1, ComplexNumber number2) {
        double realPart = number1.getRealPart() + number2.getRealPart();
        double imaginaryPart = number1.getImaginaryPart() + number2.getImaginaryPart();
        ComplexNumber result = new ComplexNumber(realPart, imaginaryPart);
        log.log("Результат: " + result);
        return result;
    }
    // Вычитание
    @Override
    public ComplexNumber subtraction(ComplexNumber number1, ComplexNumber number2) {
        double realPart = number1.getRealPart() - number2.getRealPart();
        double imaginaryPart = number1.getImaginaryPart() - number2.getImaginaryPart();
        ComplexNumber result = new ComplexNumber(realPart, imaginaryPart);
        log.log("Результат: " + result);
        return result;
    }
    // Умножение
    @Override
    public ComplexNumber multiplication(ComplexNumber number1, ComplexNumber number2) {
        double realPart = (number1.getRealPart() * number2.getRealPart()) - (number1.getImaginaryPart() * number2.getImaginaryPart());
        double imaginaryPart = (number1.getRealPart() * number2.getImaginaryPart()) + (number1.getImaginaryPart() * number2.getRealPart());
        ComplexNumber result = new ComplexNumber(realPart, imaginaryPart);
        log.log("Результат: " + result);
        return result;
    }
    // Деление
    @Override
    public ComplexNumber division(ComplexNumber number1, ComplexNumber number2) {
        double divider = (number2.getRealPart() * number2.getRealPart()) + (number2.getImaginaryPart() * number2.getImaginaryPart());
        double realPart = ((number1.getRealPart() * number2.getRealPart()) + (number1.getImaginaryPart() * number2.getImaginaryPart())) / divider;
        double imaginaryPart = ((number1.getImaginaryPart() * number2.getRealPart()) - (number1.getRealPart() * number2.getImaginaryPart())) / divider;
        ComplexNumber result = new ComplexNumber(realPart, imaginaryPart);
        log.log("Результат: " + result);
        return result;
    }
}
