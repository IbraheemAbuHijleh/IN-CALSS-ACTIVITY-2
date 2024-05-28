package com.example.in_class_activity_drsamer_28_5;

public class Employee {
    private String name;
    private String Email;


    public Employee(String Name ,String Eame ) {
        this.name=Name;
        this.Email=Eame;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return Email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
