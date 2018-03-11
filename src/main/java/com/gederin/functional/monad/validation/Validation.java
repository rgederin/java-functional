package com.gederin.functional.monad.validation;


import java.util.function.Function;


public abstract class Validation<L, A> {
    protected final A value;

    protected Validation (A value){
        this.value = value;
    }

    public abstract <B> Validation<L, B> map(Function<? super A, ? extends B> function);

    public abstract <B> Validation<L, B> flatMap(Function<? super A, Validation<?, ? extends B>> function);

    public abstract boolean isSuccess();
}
