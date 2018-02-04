package com.jasvirdi;

@FunctionalInterface
interface SomeFunction {
    int func(int n);
}

/**
 * Lambda expression can use an instance or static variable defined by its enclosing class
 * Lambda expression also has access to this
 * Lambda expression may only use local variables which are effectively final, means whose value doesn't change after first assigned
 * Note: Lambda expression can't modify local variable doing so will remove the effective final status of that variable
 */
public class VariableCaptureDemo {

    public static void main(String[] args) {

        // local variable
        int localVariable = 10;

        SomeFunction lambda = (n) -> {
            // Legal because this is not modifying local variable
            int value = localVariable + n;

            // This would be illegal because this
            //localVariable++

            return value;
        };

        // This is also illegal, because it would remove the effective final status from localVariable
        //localVariable = 15;
    }

}
