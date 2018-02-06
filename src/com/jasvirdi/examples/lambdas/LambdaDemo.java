/**
 * A Simple Lambda Expression
 */
package com.jasvirdi.examples.lambdas;

/**
 * A Functional interface
 */
@FunctionalInterface
interface MyNumber {
    double getValue();
}

/**
 * A Functional interface
 */
@FunctionalInterface
interface NumericTest {
    boolean test(int number);
}


/**
 * A functional interface
 */
@FunctionalInterface
interface NumericTest2 {
    boolean test(int n1, int n2);
}

public class LambdaDemo {

    public static void main(String[] args) {

        /*
        Declare an instance reference of  MyNumber Interface
         */
        MyNumber myNumber;

        /**
         * Here, the lambda expression is simply a constant expression
         * When it's assigned to myNumber, a class instance is constructed in which the lambda expression implements
         * the getValue() method in MyNumber;
         */
        myNumber = () -> 123.45;

        System.out.println("A Fixed Value: " + myNumber.getValue());

        myNumber = () -> Math.random() * 10;

        System.out.println("A Random value: " + myNumber.getValue());

        /*
        A Lambda expression that tests if a number is even
         */
        NumericTest isEven = (number) -> (number % 2) == 0;

        if (isEven.test(10))
            System.out.println("10 is even");
        if (!isEven.test(5))
            System.out.println("5 is not even");

        /*
        A lambda expression to test if number is non negative
         */
        NumericTest isNonNegative = (number) -> number >= 0;

        if (isNonNegative.test(10))
            System.out.println("10 is non negative");
        if (!isNonNegative.test(-10))
            System.out.println("-10 is negative");


        /*
        A lambda expression to test if a number is factor of another
         */
        NumericTest2 isFactor = (n1, n2) -> (n1 % n2) == 0;

        if (isFactor.test(10, 2))
            System.out.println("2 is factor of 10");

    }
}
