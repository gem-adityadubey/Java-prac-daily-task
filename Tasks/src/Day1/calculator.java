package Day1;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose options!");
        System.out.println("# - Addition");
        System.out.println("$ - Subtraction");
        System.out.println("% - Multiplication");
        System.out.println("^ - Division");
        System.out.println("& - Modulus");
        System.out.println("* - Exponentiation");
        System.out.print("Enter the operation sign: ");
        char operation = scanner.next().charAt(0);
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        double result = 0;
        switch (operation) {
            case '#':
                result = num1 + num2;
                break;
            case '$':
                result = num1 - num2;
                break;
            case '%':
                result = num1 * num2;
                break;
            case '^':
                if (num2 != 0)
                    result = num1 / num2;
                else
                    System.out.println("Cannot divide by zero!");
                break;
            case '&':
                if (num2 != 0)
                    result = num1 % num2;
                else
                    System.out.println("Cannot divide by zero!");
                break;
            case '*':
                result = Math.pow(num1, num2);
                break;
            default:
                System.out.println("Invalid operation!");
                return;
        }

        System.out.println("Result: " + result);
    }
}