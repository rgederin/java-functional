# Core information about functional programming
In this repo I collected several useful termins, examples and other things which are related to functional programming

## Fuctions 

Here is [code examples](https://github.com/rgederin/java-functional/blob/master/src/main/java/com/gederin/functional/functions/Functions.java) for different function types.

### Pure/impure functions

Characteristics of Pure Function:

* The return value of the pure func­tions solely depends on its arguments Hence, if you call the pure functions with the same set of argu­ments, you will always get the same return values.
* They do not have any side effects like net­work or data­base calls
* They do not mod­ify the argu­ments which are passed to them

The most significant characteristic of pure functions is that they don't modify any state. This includes state on the arguments provided to the function, global state, or even state external to the program itself. Functional programmers like to say that non-pure functions can really do anything they want, and there's no way to know at the call site that there won't be side-effects at the call site. One amusing example is that calling a non-pure function may launch a missile somewhere. Certainly not likely, but how can you guarantee that calling some arbitrary procedure won't actually do this without investigating the code yourself? If the function is pure, then it cannot launch any missiles, by definition.

Characteristics of Impure functions

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

*Classes should be immutable unless there’s a very good reason to make them mutable. If a class cannot be made immutable, limit its mutability as much as possible.* (c) Josh Bloch