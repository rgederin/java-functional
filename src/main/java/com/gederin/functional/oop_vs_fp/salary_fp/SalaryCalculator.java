package com.gederin.functional.oop_vs_fp.salary_fp;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SalaryCalculator {
    private final List<Function<Double, Double>> functions = new ArrayList<>();

    public SalaryCalculator with(Function<Double, Double> function) {
        functions.add(function);
        return this;
    }

    public double calculate(double basic) {
        return functions.stream()
                .reduce(Function.identity(), Function::andThen)
                .apply(basic);
    }
}
