package com.gederin.functional.monad.validation;


import java.util.function.Function;

public class Failure<L, A> extends Validation<L, A> {

    protected final L left;

    protected Failure(A value, L left) {
        super(value);

        this.left = left;
    }

    public static <L, A> Failure<L, A> failure(L left, A value) {
        return new Failure<>(value, left);
    }

    @Override
    public <B> Validation<L, B> map(Function<? super A, ? extends B> function) {
        return failure(left, function.apply(value));
    }

    @Override
    public <B> Validation<L, B> flatMap(Function<? super A, Validation<?, ? extends B>> function) {
        Validation<?, ? extends B> result = function.apply(value);

        return result.isSuccess() ? failure(left, result.value) : failure(((Failure<L, B>) result).left, result.value);
    }

    @Override
    public boolean isSuccess() {
        return false;
    }
}
