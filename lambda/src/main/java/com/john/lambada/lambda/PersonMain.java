package com.john.lambada.lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author John
 */
public class PersonMain {
    public static void main(String[] args) {
        List<Person> roster = Lists.newArrayList(new Person());
        //approach 3 Specify Search Criteria Code in a Local Class
        PersonMain.printPersons(roster, new CheckPersonEligibleForSelectiveService());

        //approach 4 Specify Search Criteria Code in an Anonymous Class
        PersonMain.printPersons(roster, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });

        //Approach 5: Specify Search Criteria Code with a Lambda Expression
        printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );

        printPersonsWithPredicate(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );

        processPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::printPerson
        );

        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getEmailAddress,
                System.out::println
        );

        //使用泛型
        processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getEmailAddress,
                System.out::println
        );

        // Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters
        roster.stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(Person::getEmailAddress)
                .forEach(System.out::println);

    }

    /**
     * approach 1
     */
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    /**
     * approach 2
     * Create More Generalized Search Methods
     * 创建更加通用的方法
     */
    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    /**
     * approach 3
     * Specify Search Criteria Code in a Local Class
     * To use this class, you create a new instance of it and invoke the printPersons method:
     * printPersons(roster, new CheckPersonEligibleForSelectiveService());
     */
    private static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /**
     * Approach 6: Use Standard Functional Interfaces with Lambda Expressions
     */
    private static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /**
     * Approach 7: Use Lambda Expressions Throughout Your Application
     */
    private static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    /**
     * What if you want to do more with your members' profiles than printing them out.
     * Suppose that you want to validate the members' profiles or retrieve their contact information? In this case,
     * you need a functional interface that contains an abstract method that returns a value. The Function<T,R> interface contains the method R apply(T t).
     * The following method retrieves the data specified by the parameter mapper, and then performs an action on it specified by the parameter block:
     */
    private static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    /**
     * Approach 8: Use Generics More Extensively
     *
     */
    private static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

}
