package com.jasvirdi;

@FunctionalInterface
interface FactoryFunction<R, T> {
    R fun(T n);
}

/**
 * A simple generic class
 *
 * @param <T>
 */
class MyClass1<T> {
    private T val;

    MyClass1(T v) {
        this.val = v;
    }

    MyClass1() {
        this.val = null;
    }

    T getVal() {
        return this.val;
    }
}

/**
 * A simple non-generic class
 */
class MyClass2 {
    String str;

    MyClass2(String str) {
        this.str = str;
    }

    MyClass2() {
        this.str = "";
    }

    String getVal() {
        return this.str;
    }

}


/**
 * Simple class factor using constructor reference
 */
public class ConstructorReferenceDemo {

    static <R, T> R myClassFactory(FactoryFunction<R, T> cons, T v) {
        return cons.fun(v);
    }

    public static void main(String[] args) {

        // Creates a reference to a MyClass constructor. In this case, new refer to constructor that takes an argument
        FactoryFunction<MyClass1<Double>, Double> myClassCons = MyClass1<Double>::new;

        // Create instance of class by use of the factory method
        MyClass1<Double> myClass1 = myClassFactory(myClassCons, 100.1);

        System.out.println("Val in myClass1 " + myClass1.getVal());

        FactoryFunction<MyClass2, String> myClassCons2 = MyClass2::new;

        MyClass2 myClass2 = myClassFactory(myClassCons2, "Lambdas");

        System.out.println("String in mc2 is " + myClass2.getVal());
    }
}
