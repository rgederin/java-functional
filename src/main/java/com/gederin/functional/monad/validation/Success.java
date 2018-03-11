package com.gederin.functional.monad.validation;

import java.util.function.Function;

public class Success<L, A> extends Validation<L, A> {

    protected Success(A value) {
        super(value);
    }

    public static <L, A> Success<L, A> success(A value) {
        return new Success<>(value);
    }

    @Override
    public <B> Validation<L, B> map(Function<? super A, ? extends B> function) {
        return success(function.apply(value));
    }

    @Override
    public <B> Validation<L, B> flatMap(Function<? super A, Validation<?, ? extends B>> function) {
        return (Validation<L, B>) function.apply(value);
    }

    @Override
    public boolean isSuccess() {
        return true;
    }
}
