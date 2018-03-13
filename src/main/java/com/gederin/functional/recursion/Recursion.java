package com.gederin.functional.recursion;


public class Recursion {

    private static int iterativeSum(int n) {
        int sum = 0;

        for (int i = 0; i < n; i++)
            sum += i;

        return sum;
    }

    private static int recursiveSum(int n) {
        if (n == 0)
            return 0;

        return n + recursiveSum(n - 1);
    }

    private static int tailRecursionSum(int n, int sum) {
        if (n == 0)
            return sum;

        return tailRecursionSum(n - 1, sum + n);
    }
}
