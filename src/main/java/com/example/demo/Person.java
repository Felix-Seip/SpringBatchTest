package com.example.demo;

public class Person {
    private String firstName = "";
    private String lastName = "";
    private long age = 0;

    public Person() {
        // default constructor
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return this.lastName + ", " + this.firstName + " " + this.age;
    }
}
