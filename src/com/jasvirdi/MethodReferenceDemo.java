package com.jasvirdi;

/**
 * A functional interface for String operators
 */
@FunctionalInterface
interface StrFunction {
    String func(String str);
}

/**
 * Class defining a static method to reverse a string
 */
class MyStringOps {
    static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

/**
 * This class defines an instance method
 */
class MyStrOps {
    String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

/**
 * Method reference is a way to refer to a method without executing it
 * It requires a target type context that consists of a compatible functional interface
 * Types of method references
 * Method reference to static method
 * Method reference to instance method
 */
public class MethodReferenceDemo {

    static String stringOp(StrFunction strFunction, String str) {
        return strFunction.func(str);
    }

    public static void main(String[] args) {
        String inputString = "Powerful Lambdas";
        String outputString;

        /*
         * Reference to strReverse is passes to stringOp(), this is legal because,
         * strReverse is compatible with the String functional interface.
         * Thus MyStringOps::strReverse evaluates to a reference to an object in which
         * strReverse provides the implementation of abstract method func(String str) defined in StrFunction
         *
         */
        outputString = stringOp(MyStringOps::strReverse, inputString);

        System.out.println("Original String: " + inputString);
        System.out.println("String reversed using static method reference : " + outputString);

        // Method reference to instance method
        MyStrOps strOps = new MyStrOps();
        outputString = stringOp(strOps::strReverse, inputString);
        System.out.println("Original String: " + inputString);
        System.out.println("String reversed using method reference to instance method: " + outputString);

    }

}
