package academy.javapro.lab7;

public class AlternativeArithmetic {

    // Method to add two integers without using '+'
    public static int addWithoutPlus(int a, int b) {
        while (b != 0) {
            int carry = a & b;    // Find carry bits
            a = a ^ b;            // Add without carry
            b = carry << 1;       // Shift carry bits left
        }
        return a;
    }

    
    public static int divideWithoutDivideOperator(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);  
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long result = 0;

        // Bitwise division loop
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor, multiple = 1;

           
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= tempDivisor;
            result += multiple;
        }

        // Apply sign and prevent integer overflow
        result = isNegative ? -result : result;

        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        System.out.println("Testing addition without '+' operator:");
        System.out.println("5 + 3 = " + addWithoutPlus(5, 3));
        System.out.println("-2 + 7 = " + addWithoutPlus(-2, 7));
        System.out.println("0 + 0 = " + addWithoutPlus(0, 0));
        System.out.println("-5 + -3 = " + addWithoutPlus(-5, -3));
        System.out.println("100 + 200 = " + addWithoutPlus(100, 200));
        System.out.println("2147483647 + 1 = " + addWithoutPlus(2147483647, 1));
        System.out.println("-100 + 100 = " + addWithoutPlus(-100, 100));

        System.out.println("\nTesting division without '/' operator:");
        System.out.println("10 / 2 = " + divideWithoutDivideOperator(10, 2));
        System.out.println("15 / 3 = " + divideWithoutDivideOperator(15, 3));
        System.out.println("8 / 4 = " + divideWithoutDivideOperator(8, 4));
        System.out.println("7 / 2 = " + divideWithoutDivideOperator(7, 2));
        System.out.println("100 / 10 = " + divideWithoutDivideOperator(100, 10));
        System.out.println("-15 / 3 = " + divideWithoutDivideOperator(-15, 3));
        System.out.println("15 / -3 = " + divideWithoutDivideOperator(15, -3));
        System.out.println("0 / 5 = " + divideWithoutDivideOperator(0, 5));
        System.out.println("1024 / 2 = " + divideWithoutDivideOperator(1024, 2));
    }
}
