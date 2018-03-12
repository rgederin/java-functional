package com.gederin.functional.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Functions {
    public static void main(String[] args) {
        Integer initial = 5;

        Integer inverted = compute(Functions::invert, initial);

        System.out.println("Inverted value with HoF: " + inverted);

        Integer multiplied = compute(a -> a * 5, initial);

        System.out.println("Multiplied value with lamda: " + multiplied);

        BiFunction<Integer, Integer, String> convertToString = (a, b) -> "Converted string: " + a + "," + b;

        System.out.println(convertToString.apply(initial, multiplied));


        // Pure and impure functions example
        List<Integer> pureFunctions = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            pureFunctions.add(pureFunction(i));
        }

        List<Integer> impureFunctions = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            impureFunctions.add(impureFunction(i));
        }

        System.out.println(pureFunctions);
        System.out.println(impureFunctions);

    }

    /**
     * HoF which allow to make some computation with integer
     */
    public static Integer compute(Function<Integer, Integer> function, Integer value) {
        return function.apply(value);
    }

    /**
     * Pure function which inverts given integer
     */
    private static Integer invert(Integer value) {
        return -value;
    }

    public static Integer pureFunction(Integer value) {
        return value * value;
    }

    public static Integer impureFunction(Integer value) {
        return value * new Random().nextInt(100);
    }
}