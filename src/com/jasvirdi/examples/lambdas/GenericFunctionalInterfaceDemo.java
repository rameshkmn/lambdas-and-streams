package com.jasvirdi.examples.lambdas;

/**
 * A generic functional interface
 *
 * @param <T>
 */
@FunctionalInterface
interface GenericFunction<T> {
    T fun(T t);
}

public class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {

        /*
        String base version of genericFunction
         */
        GenericFunction<String> reverse = (str) -> {
            String result = "";

            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Generic Interface reverse is " + reverse.fun("Generic Interface"));
    /*
    Integer base function of GenericFunction
     */
        GenericFunction<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result += result * i;
            }
            return result;
        };
        System.out.println("The Factorial of 7 is " + factorial.fun(7));
    }


}
