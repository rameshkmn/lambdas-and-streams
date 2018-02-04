package com.jasvirdi;

@FunctionalInterface
interface NumericFunction {
    int func(int n);
}

@FunctionalInterface
interface StringFunction {
    String func(String str);
}

public class BlockLambdaDemo {
    public static void main(String[] args) {

        /*
        Lambda expression calculates the factorial of int value
         */
        NumericFunction factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };

        System.out.println("The Factorial of 5 is " + factorial.func(5));

        /*
        Lambda expression to reverse the string
         */
        StringFunction reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("Lambda reverse is " + reverse.func("Lambda"));
    }
}
