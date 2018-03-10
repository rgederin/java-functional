package com.gederin.functional.functor.optional;

import com.gederin.functional.functor.Functor;

import java.util.function.Function;

import static java.util.Objects.isNull;

/**
 * An FOptional<T> functor may hold a value, but just as well it might be empty. It's a type-safe
 * way of encoding null.
 *
 * There are two ways of constructing FOptional - by supplying a value or creating an empty()
 * instance.
 *
 * In both cases, just like with Identity, FOptional is immutable and we can only interact with the
 * value from inside.
 *
 * What differs FOptional is that the transformation function f may not be applied to any value if
 * it is empty.
 *
 * This means functor may not necessarily encapsulate exactly one value of type T
 */
class FOptional<T> implements Functor<T, FOptional<?>> {
    private final T valueOrNull;

    private FOptional(T valueOrNull) {
        this.valueOrNull = valueOrNull;
    }

    @Override
    public <R> FOptional<R> map(Function<T, R> function) {
        return isNull(valueOrNull) ? empty() : of(function.apply(valueOrNull));
    }

    public static <T> FOptional<T> of(T a) {
        return new FOptional<>(a);
    }

    public static <T> FOptional<T> empty() {
        return new FOptional<>(null);
    }
}

class TestRunner {
    public static void main(String[] args) {
        FOptional<Integer> integerFOptional = FOptional.of(5);

        FOptional<Long> toLong = integerFOptional
                .map(n -> n * n)
                .map(Integer::longValue);

        System.out.println(integerFOptional);
    }
}