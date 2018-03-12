package com.gederin.functional.immutability;


import lombok.AllArgsConstructor;
import lombok.Data;

public class Mutability {
    public static void main(String[] args) {
        referenceMutation();

        System.out.println( "\n----------\n");

        valueMutation();
    }

    private static void referenceMutation (){
        MutablePerson person1 = new MutablePerson("Ruslan", "27");
        MutablePerson person2 = person1;

        //Reference mutation
        person1 = new MutablePerson("Dima", "35");

        System.out.println(person1); //MutablePerson(name=Dima, age=35)
        System.out.println(person2); //MutablePerson(name=Ruslan, age=27
    }

    private static void valueMutation (){
        MutablePerson person1 = new MutablePerson("Ruslan", "27");
        MutablePerson person2 = person1;

        //Value mutation
        person1.setName("Igor");

        System.out.println(person1); //MutablePerson(name=Igor, age=27)
        System.out.println(person2); //MutablePerson(name=Igor, age=27)
    }
}

@AllArgsConstructor
@Data
class MutablePerson {
    private String name;
    private String age;
}
