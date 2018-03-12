package com.gederin.functional.oop_vs_fp.salary_fp;


public class Main {
    public static void main(String[] args) {
        double basic = 1000;

        double netSalary = new SalaryCalculator()
                .with(SalaryRules::bonus)
                .with(SalaryRules::tax)
                .calculate(basic);

        System.out.println(netSalary);

        netSalary = new SalaryCalculator()
                .with(s -> s * 2)
                .calculate(netSalary);

        System.out.println(netSalary);
    }
}
