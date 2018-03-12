# Core information about functional programming
In this repo I collected several useful termins, examples and other things which are related to functional programming

## Pure/impure functions

Characteristics of Pure Function:

* The return value of the pure func­tions solely depends on its arguments Hence, if you call the pure functions with the same set of argu­ments, you will always get the same return values.
* They do not have any side effects like net­work or data­base calls
* They do not mod­ify the argu­ments which are passed to them

Characteristics of Impure functions

* The return value of the impure func­tions does not solely depend on its arguments Hence, if you call the impure func­tions with the same set of argu­ments, you might get the dif­fer­ent return values For exam­ple, Math.random(), Date.now()
* They may have any side effects like net­work or data­base calls
* They may mod­ify the argu­ments which are passed to them


## High-order and first-class functions

The main concept behind functional programming is that data and behaviors can be treated and manipulated uniformly and in the same way. In practical terms this means that it is possible to pass to a method both values and functions and in the same way the method itself can return either a value or a function. With this regard a function accepting one or more functions as argument and/or returning another function as result is called an **higher-order function**. 

Since Java 8 version we have suppourt of high-order functions in Java via lambdas and functional interfaces.
### First-class functions

Values in a language that are handled uniformly throughout are called "first class". They may be stored in data structures, passed as arguments, or used in control structures.

Languages which support values with function types, and treat them the same as non-function values, can be said to have "first class functions".

### High-order functions

One of the consequences of having first class functions is that you should be able to pass a function as an argument to another function. The latter function is now "higher order". It is a function that takes a function as an argument.
