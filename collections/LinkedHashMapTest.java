package br.com.charles.challenge.collections;

import br.com.charles.challenge.collections.model.Student;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        Student student1 = new Student("Jobscleber", 10);
        Student student2 = new Student("Josemara", 20);
        Student student3 = new Student("Mariane", 30);
        Student student4 = new Student("Ernani", 40);
        Student student5 = new Student("Claudete", 50);

        Map<Integer, Student> studentLinkedHashMap = new LinkedHashMap<>(Map.of(10, student1, 20, student2));
        studentLinkedHashMap.put(30,student3);
        studentLinkedHashMap.put(40,student4);
        studentLinkedHashMap.put(50,student5);

        System.out.println("\nExibindo Mapa\n");
        System.out.println(studentLinkedHashMap);
        System.out.println("--------------------------------------\n");

        System.out.println("forEach em lambda usando a matricula como keyset\n");
        studentLinkedHashMap.keySet().forEach(enroll -> System.out.println(studentLinkedHashMap.get(enroll)));
        System.out.println("--------------------------------------\n");

        System.out.println("forEach em lambda usando a matricula como keyset\n");

    }
}
