# Core information about functional programming
In this repo I collected several useful termins, examples and other things which are related to functional programming

## Fuctions 

Here is [code examples](https://github.com/rgederin/java-functional/blob/master/src/main/java/com/gederin/functional/functions/Functions.java) for different function types.

### Pure/impure functions

**Characteristics of Pure Function**

* The return value of the pure func­tions solely depends on its arguments Hence, if you call the pure functions with the same set of argu­ments, you will always get the same return values.
* They do not have any side effects like net­work or data­base calls
* They do not mod­ify the argu­ments which are passed to them

The most significant characteristic of pure functions is that they don't modify any state. This includes state on the arguments provided to the function, global state, or even state external to the program itself. Functional programmers like to say that non-pure functions can really do anything they want, and there's no way to know at the call site that there won't be side-effects at the call site. One amusing example is that calling a non-pure function may launch a missile somewhere. Certainly not likely, but how can you guarantee that calling some arbitrary procedure won't actually do this without investigating the code yourself? If the function is pure, then it cannot launch any missiles, by definition.

**Characteristics of Impure functions**

* The return value of the impure func­tions does not solely depend on its arguments Hence, if you call the impure func­tions with the same set of argu­ments, you might get the dif­fer­ent return values For exam­ple, Math.random(), Date.now()
* They may have any side effects like net­work or data­base calls
* They may mod­ify the argu­ments which are passed to them


### High-order and first-class functions

The main concept behind functional programming is that data and behaviors can be treated and manipulated uniformly and in the same way. In practical terms this means that it is possible to pass to a method both values and functions and in the same way the method itself can return either a value or a function. With this regard a function accepting one or more functions as argument and/or returning another function as result is called an **higher-order function**. 

Since Java 8 version we have suppourt of high-order functions in Java via lambdas and functional interfaces.

### First-class functions

Values in a language that are handled uniformly throughout are called "first class". They may be stored in data structures, passed as arguments, or used in control structures.

Languages which support values with function types, and treat them the same as non-function values, can be said to have "first class functions".

### High-order functions

One of the consequences of having first class functions is that you should be able to pass a function as an argument to another function. The latter function is now "higher order". It is a function that takes a function as an argument.


## Mutability vs Immutability

### Mutability

**Mutable object** (changeable object) is an object which can be modified after it is created.

Mutation can happen on two levels: reference mutation and value mutation. Reference mutation happens when you assign a new reference to an existing variable:

```
 private static void referenceMutation (){
        MutablePerson person1 = new MutablePerson("Ruslan", "27");
        MutablePerson person2 = person1;
        
        //Reference mutation
        person1 = new MutablePerson("Dima", "35");

        System.out.println(person1); //MutablePerson(name=Dima, age=35)
        System.out.println(person2); //MutablePerson(name=Ruslan, age=27
    }
```

In this example, the reference person1 was mutated, but the object it was pointing to was not, so the value pointed to by person2 was not changed.

Value mutation happens when you modify an existing object:

```
private static void valueMutation (){
        MutablePerson person1 = new MutablePerson("Ruslan", "27");
        MutablePerson person2 = person1;

        //Value mutation
        person1.setName("Igor");

        System.out.println(person1); //MutablePerson(name=Igor, age=27)
        System.out.println(person2); //MutablePerson(name=Igor, age=27)
    }
```

Here, even though person2 was not directly modified, it is referencing the same object as person1, and the value of its name property was changed.

What Is Wrong With Mutability?

* Hard to reason
* Hard to make concurrent/parallelize
* Leads to errors

**Classes/objects should be immutable unless there’s a very good reason to make them mutable. If a class cannot be made immutable, limit its mutability as much as possible.** (c) Josh Bloch

### Immutability

An immutable object is an object whose state cannot be changed once it has been created.

Rules for making classes/objects immutable (Java)

* All fields must be private and final. If a field is private, it cannot be externally changed. If, as a bonus, it's also final, you cannot accidentally change it.
* Do not provide a setter. Combine this with the previous point. If the fields are private and there is no setter provided, this class fields will always remain the same.
* Subclasses should not be able to override methods. Otherwise, they can trick our immutability. This is easy. Just declare the class as final.
* Do not change the state of the objects in any methods of the clas

Benefits of programming with immutable objects.

* Immutable objects are thread-safe so you will not have any synchronization issues.
* Immutable objects are good Map keys and Set elements, since these typically do not change once created.
* Immutability makes it easier to write, use and reason about the code (class invariant is established once and then unchanged)
* Immutability makes it easier to parallelize your program as there are no conflicts among objects.
* The internal state of your program will be consistent even if you have exceptions.
* References to immutable objects can be cached as they are not going to change.

## Functor

Here is [some code examples](https://github.com/rgederin/java-functional/blob/master/src/main/java/com/gederin/functional/functor) for functors.

A functor is a typed data structure that encapsulates some value(s). From a syntactic perspective a functor is a container with the following API:

```
interface Functor<T> {
    <R> Functor<R> map(Function<T, R> f);
}
```

The only operation that functor provides is map() that takes a function f. This function receives whatever is inside a box, transforms it and wraps the result as-is into a second functor. Please read that carefully. Functor<T> is always an immutable container, thus map never mutates the original object it was executed on. Instead, it returns the result (or results - be patient) wrapped in a brand new functor, possibly of different type R. Additionally functors should not perform any actions when identity function is applied, that is map(x -> x). Such a pattern should always return either the same functor or an equal instance.

Often Functor<T> is compared to a box holding instance of T where the only way of interacting with this value is by transforming it. However, there is no idiomatic way of unwrapping or escaping from the functor. The value(s) always stay within the context of a functor. Why are functors useful? They generalize multiple common idioms like collections, promises, optionals, etc. with a single, uniform API that works across all of them.

## Monads

Here is [some code examples](https://github.com/rgederin/java-functional/blob/master/src/main/java/com/gederin/functional/monad) for monads.

A monad is a pattern in software development. The monad is about putting a value in computational context in order to hide the complexity of computational context.

In native Java 8 API we have three examples of the monads - Optional, Stream and CompletableFuture.

Context for Optional is that value could be there or not, for Stream monad - that you could have multiple values, for CompletableFuture - something will be ready in the future.

Here is example of self-writed Optional monad:

```
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
```

And typical usage of monad:

```
public static String getCarInsuranceName(Person person) {
        return MOptional.of(person)
                .flatMap(Person::getCar)            //flatMap defines monad's policy for monads composition
                .flatMap(Car::getInjurance)
                .map(Insurance::getInsuranceName)   //map defines monad's policy for function application
                .orElse("unknown");
    }
```

**The Optional monad** makes the possibility of missing data expicit in the type system, while hiding the boilerplate of "if non-null" logic.
**The Stream monad** makes the possibility of multiple data explicit in the type system, while hidind the boilerplate of nested loops.
**The Completable future monad** makes asynchronous computation explicit in the type system, while hiding the boilerplate thread logic.

**Alternative Monads Definitions**

Monads are parametric types with two operations flatMap and unit that obey some algebraic laws.

Monads are structures that represent computations defined as sequences of steps.
 
Monads are chainable containers types that confine values defining how to transform and combine them.
 
## Semigroups, Monoids, Group

### Semigroups

A semigroup is an associative binary operation across at least two instances of the same type. It can be represented by JDK interfaces such as BinaryOperator and BiFunction:

```
BinaryOperator<T>
BinaryFunction<T,T,T>
```

**Associativity**

Associativity implies that the order of application is not significant:

```
BinaryOperator<T> fn;
fn.apply(fn.apply(a,b),c) = fn.apply(a,fn.apply(b,c))
```

**Examples of semigroups**

String concatenation

```
BinaryOperator<String> concat = (a,b)->a+b;

concat.apply(concat.apply("hello","world"),"c") = "helloworldc"
concat.apply("hello",concat.apply("world","c")) = "helloworldc"
```

List concatenation

```
BinaryOperator<List<T>> concat = (a,b)->{
                                          a.addAll(b);
                                          return a;
                                         };
List<T> listA;
List<T> listB;

concat.apply(listA,listB);
```

Other types if semigroups

```
BinaryOperator<Integer> intSum = (a, b) -> a + b;

BinaryOperator<Boolean> booleanConjunction = (a, b) -> a && b;

BinaryOperator<Boolean> booleanDisjunction = (a, b) -> a || b;
```

**Semigroups are not commutative**

```
BinaryOperator<T> fn;
fn.apply(a,b) != fn.apply(b,a)
```

**Semigroups are in Java APIs already**

```
Stream.of(1,2,3)
      .reduce(0,(a,b)->a+b); 
```

**Interface for Semigroup**

```
/**
 * An (associative) binary operation for combining values.
 * Implementations should obey associativity laws.
 *
 * @param <T> Data type of elements toNested be combined
 */
@FunctionalInterface
public interface Semigroup<T> extends BinaryFunctionn<T>,BinaryOperator<T> {
    
    /* (non-Javadoc)
     * @see java.util.function.BiFunction#applyHKT(java.lang.Object, java.lang.Object)
     */
    @Override
    T apply(T t, T u);
  
}
```