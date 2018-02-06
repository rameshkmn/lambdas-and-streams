package com.jasvirdi.examples.lambdas;

@FunctionalInterface
interface MyFunction<T> {
    int func(T[] vals, T v);
}

/**
 * This defines a method called countMatching() that returns the number of items
 * in an array.
 */
class MyArrayOps {
    static <T> int countMatching(T[] vals, T v2) {
        int count = 0;
        for (T v1 : vals) {
            if (v1 == v2) {
                count++;
            }
        }
        return count;
    }
}


public class GenericMethodReferenceDemo {
    private static <T> int myOps(MyFunction<T> myFunction, T[] vals, T v) {
        return myFunction.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 3, 4, 2, 3};
        String[] strs = {"One", "Two", "Three", "Two", "One"};
        int count;

        // Explicitly Passing the Integer type argument
        count = myOps(MyArrayOps::<Integer>countMatching, vals, 3);
        System.out.println("vals contains " + count + " 3s");
        // Passing the String type argument
        count = myOps(MyArrayOps::<String>countMatching, strs, "Two");
        System.out.println("strs contains " + count + " Twos");

        System.out.print("\n");

        // Inferred Integer type argument
        count = myOps(MyArrayOps::countMatching, vals, 3);
        System.out.println("vals contains " + count + " 3s");
        // Inferred the String type argument
        count = myOps(MyArrayOps::countMatching, strs, "Two");
        System.out.println("strs contains " + count + " Twos");
    }
}
