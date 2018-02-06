package com.jasvirdi.examples.lambdas;

/**
 * Functional interface that takes 2 reference arguments and returns a boolean value
 *
 * @param <T>
 */
@FunctionalInterface
interface MyFunc<T> {
    boolean fun(T v1, T v2);
}

/**
 * Class that stores the High temp for a day
 */
class HighTemp {

    private final int highTemp;

    HighTemp(int highTemp) {
        this.highTemp = highTemp;
    }

    /**
     * @param highTempObj
     * @return true if invoking HighTemp obj has the temperature
     */
    boolean sameTemp(HighTemp highTempObj) {
        return this.highTemp == highTempObj.highTemp;
    }

    /**
     * @param highTempObj
     * @return true if invoking HighTemp has a less temperature
     */
    boolean lessThanTemp(HighTemp highTempObj) {
        return this.highTemp < highTempObj.highTemp;
    }
}

/**
 * Instance method reference with different objects
 */
public class InstanceMethodWithObjectReference {

    /**
     * Method that retuns the number of occurrences of an object
     * for which some criteria, as specified by MyFunc parameter is true
     *
     * @param vals
     * @param myFunc
     * @param v2
     * @param <T>
     * @return
     */
    private static <T> int counter(T[] vals, MyFunc<T> myFunc, T v2) {
        int counter = 0;

        for (T v1 : vals) {
            if (myFunc.fun(v1, v2)) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int counter;

        HighTemp[] weekDayHighs = {
                new HighTemp(87), new HighTemp(83),
                new HighTemp(90), new HighTemp(87),
                new HighTemp(85), new HighTemp(87),
                new HighTemp(83), new HighTemp(90)
        };

        counter = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(87));
        System.out.println(counter + " days had a high temp of 87");

        counter = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(85));
        System.out.println(counter + " days had a high of less than 85");
    }


}
