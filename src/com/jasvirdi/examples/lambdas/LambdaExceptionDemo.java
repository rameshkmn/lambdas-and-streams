package com.jasvirdi.examples.lambdas;

/**
 * Functional interface with an abstract method which throws custom exception
 */
@FunctionalInterface
interface DoubleNumericArrayFunction {
    double func(double[] n) throws EmptyArrayException;

    class EmptyArrayException extends Exception {
        EmptyArrayException() {
            super("Empty Array");
        }
    }
}

/**
 * Lambda expression can throw an exception which is compatible with
 * the exceptions listed in the throw clause of abstract method of functional interface
 */
public class LambdaExceptionDemo {

    public static void main(String[] args) throws DoubleNumericArrayFunction.EmptyArrayException {
        double[] inputValues = {12.3, 34.23, 45.66, 34.0};

        /*
        Lambda block to compute average
         */
        DoubleNumericArrayFunction average = (n) -> {
            double sum = 0;
            if (n.length == 0) {
                throw new DoubleNumericArrayFunction.EmptyArrayException();
            }
            for (double val : inputValues) {
                sum += val;
            }
            return sum / n.length;
        };
        System.out.println("The Average is " + average.func(inputValues));

        //Empty array will throw custom exception
        System.out.println("The Average is " + average.func(new double[0]));

    }
}
