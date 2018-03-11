package com.gederin.functional.monad.validation;


import static com.gederin.functional.monad.validation.Failure.failure;
import static com.gederin.functional.monad.validation.Success.success;

public class PersonValidationService {
    public static Validation<String, Person> validateAge(Person person) {
        return person.getAge() > 0 ? success(person) : failure("Age must be gt zero", person);
    }

    public static Validation<String, Person> validateName(Person person) {
        return Character.isUpperCase(person.getName().charAt(0)) ? success(person) : failure("Name must start with upper case", person);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Ruslan", 20);
        Person p2 = new Person("gederin", 20);
        Person p3 = new Person("Dima", -1);


        System.out.println(validateAge(p1).flatMap(PersonValidationService::validateName));
        System.out.println(validateAge(p3).flatMap(PersonValidationService::validateName));
        System.out.println(validateName(p2));
    }
}
