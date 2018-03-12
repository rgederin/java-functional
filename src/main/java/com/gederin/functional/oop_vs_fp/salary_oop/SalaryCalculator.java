package com.gederin.functional.oop_vs_fp.salary_oop;


public class SalaryCalculator {
    public double plussAlowance (double d){
        return d * 1.2;
    }

    public double plusBonus (double d){
        return d * 1.2;
    }

    public double plusTax (double d){
        return d * 0.7;
    }

    public double plusSurcharge (double d){
        return d * 0.9;
    }

    public double calculate (double basic, boolean ... bs){
        double salary = basic;

        if (bs[0]) salary = plussAlowance(salary);
        if (bs[1]) salary = plusBonus(salary);
        if (bs[2]) salary = plusTax(salary);
        if (bs[3]) salary = plusSurcharge(salary);

        return salary;
    }
}
