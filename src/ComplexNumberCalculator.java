import java.util.logging.Level;
import java.util.logging.Logger;

public class ComplexNumberCalculator implements Calculator {

    private final Logger logger;

    public ComplexNumberCalculator() {
        logger = Logger.getLogger(ComplexNumberCalculator.class.getName());
    }

    @Override
    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        logger.log(Level.INFO, "First number: " + num1.toString());
        logger.log(Level.INFO, "Second number: " + num2.toString());
        logger.log(Level.INFO, "Addition in process...");

        ComplexNumber result = new ComplexNumber(
                num1.getReal() + num2.getReal(),
                num1.getImaginary() + num2.getImaginary()
        );

        logger.log(Level.INFO, "Result of addition: " + result);

        return result;
    }

    @Override
    public ComplexNumber subtract(ComplexNumber num1, ComplexNumber num2) {
        logger.log(Level.INFO, "First number: " + num1.toString());
        logger.log(Level.INFO, "Second number: " + num2.toString());
        logger.log(Level.INFO, "Subtraction in process...");

        ComplexNumber result = new ComplexNumber(
                num1.getReal() - num2.getReal(),
                num1.getImaginary() - num2.getImaginary()
        );

        logger.log(Level.INFO, "Result of subtraction: " + result);

        return result;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        logger.log(Level.INFO, "First number: " + num1.toString());
        logger.log(Level.INFO, "Second number: " + num2.toString());
        logger.log(Level.INFO, "Multiplication in process...");

        ComplexNumber result = new ComplexNumber(
                num1.getReal() * num2.getReal() - num1.getImaginary() * num2.getImaginary(),
                num1.getReal() * num2.getImaginary() + num1.getImaginary() * num2.getReal()
        );

        logger.log(Level.INFO, "Result of multiplication: " + result);

        return result;
    }

    @Override
    public ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        logger.log(Level.INFO, "First number: " + num1.toString());
        logger.log(Level.INFO, "Second number: " + num2.toString());
        logger.log(Level.INFO, "Division in process...");

        double denominator = num2.getReal() * num2.getReal() + num2.getImaginary() * num2.getImaginary();
        ComplexNumber result = new ComplexNumber(
                (num1.getReal() * num2.getReal() + num1.getImaginary() * num2.getImaginary()) / denominator,
                (num1.getImaginary() * num2.getReal() - num1.getReal() * num2.getImaginary()) / denominator
        );

        logger.log(Level.INFO, "Result of division: " + result);

        return result;
    }
}
