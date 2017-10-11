package com.example.administrator.sql;


public class Student {
    public String name;
    public  int age;
    public String sex;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
