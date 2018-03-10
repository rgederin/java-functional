package com.gederin.functional.functor.list;

import com.google.common.collect.ImmutableList;

import com.gederin.functional.functor.Functor;

import java.util.ArrayList;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;

import static java.util.Arrays.asList;

class FList<T> implements Functor<T, FList<?>> {

    private final ImmutableList<T> list;

    FList(Iterable<T> value) {
        list = ImmutableList.copyOf(value);
    }

    @Override
    public <R> FList<?> map(Function<T, R> function) {
        ArrayList<R> result = new ArrayList<>(list.size());

        list.forEach(element -> result.add(function.apply(element)));

        return new FList<>(result);
    }
}

class TestRunner {
    public static void main(String[] args) {

        FList<Customer> customers = new FList<>(asList(new Customer(new Address("str1")),
                new Customer(new Address("str2"))));

        FList<?> address = customers
                .map(Customer::getAddress);
    }
}

@Data
@AllArgsConstructor
class Customer {
    private Address address;
}

@Data
@AllArgsConstructor
class Address {
    private String street;

    static String street() {
        return street();
    }
}

