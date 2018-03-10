package com.gederin.functional.functor.raw;


import com.gederin.functional.functor.Functor;

import java.util.function.Function;

/**
 * Simplest functor just holding a value. All you can
 * do with that value is transforming it inside map method, but there is no way to extract it.
 * This is considered beyond the scope of a pure functor.
 * The only way to interact with functor is by applying sequences of type-safe transformations
 */
class Identity<T> implements Functor<T, Identity<?>> {
    private final T value;

    Identity(T value) {
        this.value = value;
    }

    @Override
    public <R> Identity<R> map(Function<T, R> function) {
        R result = function.apply(value);

        return new Identity<>(result);
    }
}

class TestRunner {
    public static void main(String[] args) {
        Identity<String> idString = new Identity<>("abc");
        Identity<Integer> idInt = idString.map(String::length);
    }
}