package com.gederin.functional.oop_vs_fp.strategy_oop;

public abstract class AbstarctConverter implements Converter {
    @Override
    public double convert(double value) {
        return value * getConversionRate();
    }

    public abstract double getConversionRate();
}
