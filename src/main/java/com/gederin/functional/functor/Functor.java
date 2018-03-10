package com.gederin.functional.functor;

import java.util.function.Function;

/**
 * The only operation that functor provides is map() that takes a function f. This function receives
 * whatever is inside a box, transforms it and wraps the result as-is into a second functor. Please
 * read that carefully. Functor<T> is always an immutable container, thus map never mutates the
 * original object it was executed on. Instead, it returns the result (or results - be patient)
 * wrapped in a brand new functor, possibly of different type R.
 *
 * Additionally functors should not
 * perform any actions when identity function is applied, that is map(x -> x). Such a pattern should
 * always return either the same functor or an equal instance.
 *
 * Often Functor<T> is compared to a box holding instance of T where the only way of interacting
 * with this value is by transforming it. However, there is no idiomatic way of unwrapping or
 * escaping from the functor. The value(s) always stay within the context of a functor.
 *
 * interface Functor<T> {
 * <R> Functor<R> map(Function<T, R> f);
 * }
 */
public interface Functor<T, F extends Functor<?, ?>> {
    <R> F map(Function<T, R> function);
}