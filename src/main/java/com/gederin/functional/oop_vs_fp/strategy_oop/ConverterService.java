package com.gederin.functional.oop_vs_fp.strategy_oop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterService {
    public static List<Double> convertValues (List<Double> values, Converter converter){
        List<Double> converted = new ArrayList<>();

        for (double value : values){
            converted.add(converter.convert(value));
        }

        return converted;
    }

    public static void main(String[] args) {
        List<Double> values = Arrays.asList(10.0,20.0,30.0);

        List<Double> convertedDistances = convertValues(values, new Miles2KmConvertter());
        List<Double> convertedWeight = convertValues(values, new Ou2GrConverter());

        System.out.println(convertedDistances);
        System.out.println(convertedWeight);
    }
}
