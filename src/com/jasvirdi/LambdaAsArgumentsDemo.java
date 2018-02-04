package com.jasvirdi;

@FunctionalInterface
interface StringFunc {
    String func(String str);
}

public class LambdaAsArgumentsDemo {

    /**
     * This method has a functional interface as the type of its first parameter,
     * thus it can be passed reference to any instance of that interface, including the
     * instance created by a lambda expression
     *
     * @param stringFunc
     * @param str
     * @return
     */
    static String stringOp(StringFunc stringFunc, String str) {
        return stringFunc.func(str);
    }

    public static void main(String[] args) {
        String inputStr = "Power of Lambdas";
        String outputStr;

        System.out.println("Input String is " + inputStr);
        // Passing simple lambda expression as parameter
        outputStr = stringOp((str) -> str.toUpperCase(), inputStr);
        System.out.println("The String in uppercase: " + outputStr);

        /*
        Lambda function to remove spaces in string
         */
        StringFunc removeSpaces = (str) -> {
            String result = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    result += str.charAt(i);
                }
            }
            return result;
        };

        outputStr = stringOp(removeSpaces, inputStr);
        System.out.println("The String without spaces " + outputStr);

    }

}
