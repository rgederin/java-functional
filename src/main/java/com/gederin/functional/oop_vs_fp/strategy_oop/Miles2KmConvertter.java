package com.gederin.functional.oop_vs_fp.strategy_oop;

public class Miles2KmConvertter extends AbstarctConverter {
    @Override
    public double getConversionRate() {
        return 1.609;
    }
}
