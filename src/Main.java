import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ComplexNumberCalculator calculator = new ComplexNumberCalculator();
        Scanner scanner = new Scanner(System.in);
        ComplexNumber result = null;

        System.out.println("Enter the first complex number");
        ComplexNumber num1 = EnterComplexNumber(scanner);

        System.out.println("Enter the second complex number");
        ComplexNumber num2 = EnterComplexNumber(scanner);

        int operation = EnterOperation(scanner);
        switch (operation) {
            case 1:
                result = calculator.add(num1, num2);
                break;
            case 2:
                result = calculator.subtract(num1, num2);
                break;
            case 3:
                result = calculator.multiply(num1, num2);
                break;
            case 4:
                try {
                    result = calculator.divide(num1, num2);
                } catch (Exception e) {
                    System.out.println("Division by zero is not allowed.");
                }
                break;
        }

        if (result != null) {
            System.out.println("The result: " + result);
        } else {
            System.out.println("Something went wrong.");
        }
    }

    private static ComplexNumber EnterComplexNumber(Scanner scanner) {
        double real = 0;
        double imaginary = 0;
        boolean isValid = false;

        do {
            System.out.println("Real part: ");
            if (scanner.hasNextDouble()) {
                real = scanner.nextDouble();
                isValid = true;
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Invalid Input. Try Again.");
            }
        } while (!isValid);

        isValid = false;
        do {
            System.out.println("Imaginary part: ");
            if (scanner.hasNextDouble()) {
                imaginary = scanner.nextDouble();
                isValid = true;
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Invalid Input. Try Again.");
            }
        } while (!isValid);

        return new ComplexNumber(real, imaginary);
    }

    private static int EnterOperation(Scanner scanner) {
        int operation = 1;
        boolean isValid = false;

        System.out.println("Choose the operation (Enter its number):");
        System.out.println("1) Addition");
        System.out.println("2) Subtraction");
        System.out.println("3) Multiplication");
        System.out.println("4) Division");

        do {
            if (scanner.hasNextInt()) {
                operation = scanner.nextInt();
                if (operation > 0 && operation < 5) {
                    isValid = true;
                } else {
                    System.out.println("No such number. Try Again.");
                }
            } else {
                scanner.nextLine();
                System.out.println("Invalid Input. Try Again.");
            }
        } while (!isValid);

        return operation;
    }
}