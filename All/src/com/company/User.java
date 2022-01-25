package com.company;

public class User {
    private String name;
    private String lastName;
    private String email;
    private String avatar;
    private int id;

    public User() {
    }

    public User(String name, String lastName, int id) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String toString() {
        return "User{name='" + this.name + "', lastName='" + this.lastName + "'}";
    }
}
