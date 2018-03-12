package com.gederin.functional.oop_vs_fp.salary_fp;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public final class SalaryRules {
    public static double alowance (double d){
        return d * 1.2;
    }

    public static double bonus (double d){
        return d * 1.2;
    }

    public static double tax (double d){
        return d * 0.7;
    }

    public static double surcharge (double d){
        return d * 0.9;
    }
}
