package com.gederin.functional.immutability;


public class Immutability {
    public static void main(String[] args) {
        final Star star = new Star (10099999.99, "Name");
    }
}

final class Star {
    private final double mass;

    private final String name;

    public Star(double mass, String name) {
        this.mass = mass;
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }
}