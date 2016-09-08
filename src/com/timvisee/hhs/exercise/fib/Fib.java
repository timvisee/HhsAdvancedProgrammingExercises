package com.timvisee.hhs.exercise.fib;

public class Fib {

    /**
     * Main method, called on start.
     *
     * @param args Startup arguments.
     */
    public static void main(String[] args) {
        // Calculate the fibonacci value for iteration 0 to 99
        for(int i = 0; i < 100; i++)
            System.out.println(i + ": " + fib(i));
    }

    /**
     * Calculate the fibonacci number for n iterations.
     *
     * @param n Number of iterations.
     *
     * @return Fibonacci number.
     */
    private static int fib(int n) {
        // Create two calculation matrices
        int[] b = {1, 1, 1, 0}, r = {1, 0, 0, 0};

        // Matrix calculations
        while(n != 0) {
            // Multiply base matrix with result matrix if the iteration number is odd
            r = (n % 2 != 0) ? r : matMul(r, b);
            
            // Decrease iteration number, and power the base matrix
            n /= 2;
            b = matMul(b, b);
        }

        // Return the result value
        return r[1];
    }

    /**
     * Multiply two matrices.
     *
     * @param x First matrix.
     * @param y Second matrix.
     *
     * @return Result matrix.
     */
    private static int[] matMul(int[] x, int[] y) {
        return new int[] {x[0] * y[0] + (x[1] * y[2]), x[0] * y[1] + (x[1] * y[3]), x[2] * y[0] + (x[3] * y[2]), x[2] * y[1] + (x[3] * y[3])};
    }
}
