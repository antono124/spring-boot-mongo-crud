package com.antogeo.springbootmongocrud.model;

public class Account {

    private String id;

    private String email;

    private String firstName;

    private int age;

    public Account(String id, String email, String firstName, int age) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
