package com.gederin.functional.oop_vs_fp.strategy_fp;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Converter implements BiFunctionToFunction<Double, Double, Double> {
    @Override
    public Double apply(Double conversionRate, Double value) {
        return conversionRate * value;
    }
}

interface BiFunctionToFunction<T, U, R> extends BiFunction<T, U, R> {
    default Function<U, R> curry(T t) {
        return u -> apply(t, u);
    }
}

class TestRunner {
    private static final double MILES_TO_KM_RATE = 1.609;

    public static void main(String[] args) {
        Converter converter = new Converter();


        Function<Double, Double> mile2KmConverter = converter.curry(MILES_TO_KM_RATE);
        double tenMilesInKm = mile2KmConverter.apply(10.0);

        System.out.println(tenMilesInKm);

        List<Double> converted = Stream.of(10.0, 20.0, 50.0)
                .map(mile2KmConverter)
                .collect(toList());

        System.out.println(converted);

        Function<Double, Double> c2Fconverter = new Converter().curry(9.0 / 5).andThen(n -> n + 32);

        System.out.println(c2Fconverter.apply(10.0));
    }
}