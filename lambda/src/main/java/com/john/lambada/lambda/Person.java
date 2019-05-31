package com.john.lambada.lambda;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author John
 */
@Data
public class Person {

    public void printPerson() {
        System.out.println("w t");
    }

    public enum Sex {
        /**
         * 性别
         */
        MALE, FEMALE
    }

    private String name;

    private LocalDate birthday;

    private Sex gender;

    private String emailAddress;

    private int age;


}
