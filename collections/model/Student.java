package br.com.charles.challenge.collections.model;

import java.util.Objects;

public class Student {
    private String name;
    private int enroll;

    public Student(String name, int enroll) {
        this.enroll = enroll;
        this.name = name;
    }

//    @Override
//    public boolean equals(Object obj) {
//        Student student = (Student) obj;
//        return this.enroll == student.enroll;
//    }

//    @Override
//    public int hashCode() {
//        return this.name.hashCode();
//    }

    @Override
    public String toString() {
        return "Student {name=" + name + ", enroll=" + enroll + "}";
    }
}
