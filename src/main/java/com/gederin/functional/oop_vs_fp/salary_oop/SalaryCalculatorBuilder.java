package com.gederin.functional.oop_vs_fp.salary_oop;


public class SalaryCalculatorBuilder extends SalaryCalculator {
    private boolean hasAlowance;
    private boolean hasBonus;
    private boolean hasTax;
    private boolean hasSurcharge;

    public SalaryCalculatorBuilder withAllowance() {
        hasAlowance = true;
        return this;
    }

    public SalaryCalculatorBuilder withBonus() {
        hasBonus = true;
        return this;
    }

    public SalaryCalculatorBuilder withTax() {
        hasTax = true;
        return this;
    }

    public SalaryCalculatorBuilder withSurcharge() {
        hasSurcharge = true;
        return this;
    }

    public double calculate(double basic) {
        return super.calculate(basic, hasAlowance, hasBonus, hasTax, hasSurcharge);
    }
}
