package com.baeldung.orika;

public class PersonContainer {
    private Name name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public PersonContainer(Name name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonContainer(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

}
