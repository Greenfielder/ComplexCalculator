package util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import impl.ComplexNumber;
import interfaces.Calculable;
import util.Operators;


public class View {
    private final Calculable calculator;
    private final List<String> validOperators;

    public View(Calculable calculator) {
        this.calculator = calculator;
        this.validOperators = Arrays.stream(Operators.values())
                .map(Operators::operator)
                .collect(Collectors.toList());
    }

    public void run() {
        while (true) {
            prepare();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    private void prepare() {
        double realPart1 = promptInt("Действительная часть первого числа: ");
        double imagPars1 = promptInt("Мнимая часть первого числа: ");
        ComplexNumber a = new ComplexNumber(realPart1, imagPars1);

        String operator = getOperator();

        double realPart2 = promptInt("Действительная часть второго числа: ");
        double imagPars2 = promptInt("Мнимая часть второго числа: ");
        ComplexNumber b = new ComplexNumber(realPart2, imagPars2);



        if (operator.equals("*")) {
            calculator.multiplication(a, b);
        }

        if (operator.equals("+")) {
            calculator.addition(a, b);
        }

        if (operator.equals("/")) {
            calculator.division(a, b);
        }

        if (operator.equals("-")) {
            calculator.subtraction(a, b);
        }
    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }

    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the math operation (*, +, /, -) : ");
        String operator = in.nextLine();
        while (true) {
            if (isInvalidOperator(operator)) {
                System.err.println("Entered invalid math operator. " + "Enter the math operation (*, +, /, -) : ");
                operator = in.nextLine();
            } else return operator;
        }
    }

    private boolean isInvalidOperator(String operator) {
        return !validOperators.contains(operator);
    }

    private  int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        int result = -1;
        try {
            result = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Not number was enter. Please enter number");
            promptInt(message);
        }
        return result;
    }
}
