package com.gederin.functional.monad.optional;


import java.util.function.Function;

import lombok.Data;
import lombok.Setter;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class MOptional<T> {
    private static final MOptional EMPTY = new MOptional<>(null);

    private final T value;

    private MOptional(T value) {
        this.value = value;
    }

    public <U> MOptional<U> map(Function<? super T, ? extends U> function) {
        return isNull(value) ? EMPTY : new MOptional(function.apply(value));
    }
    
    public <U> MOptional<U> flatMap(Function<? super T, MOptional<U>> f) {
        return isNull(value) ? EMPTY : f.apply(value);
    }

    public T orElse(T other) {
        return nonNull(value) ? value : other;
    }

    public static <T> MOptional<T> of(T a) {
        return new MOptional<T>(a);
    }
}

class PersonService {
    public static String getCarInsuranceName(Person person) {
        return MOptional.of(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInjurance)
                .map(Insurance::getInsuranceName)
                .orElse("unknown");
    }
}

@Setter
class Person {
    private Car car;

    public MOptional<Car> getCar() {
        return MOptional.of(car);
    }
}

@Setter
class Car {
    private Insurance insurance;

    public MOptional<Insurance> getInjurance() {
        return MOptional.of(insurance);
    }
}

@Data
class Insurance {
    private String insuranceName;
}