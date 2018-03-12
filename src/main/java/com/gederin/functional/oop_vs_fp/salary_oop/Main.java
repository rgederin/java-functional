package com.gederin.functional.oop_vs_fp.salary_oop;

public class Main {
    public static void main(String[] args) {
        double basic = 1000;

        double netSalary = new SalaryCalculatorBuilder()
                .withBonus()
                .withTax()
                .calculate(basic);

        System.out.println(netSalary);
    }
}
