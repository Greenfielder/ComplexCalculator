package interfaces;

import impl.ComplexNumber;
public interface Calculable {
    ComplexNumber addition(ComplexNumber number1, ComplexNumber number2);
    ComplexNumber subtraction(ComplexNumber number1, ComplexNumber number2);
    ComplexNumber multiplication(ComplexNumber number1, ComplexNumber number2);
    ComplexNumber division(ComplexNumber number1, ComplexNumber number2);
}
