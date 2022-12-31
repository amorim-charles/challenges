package br.com.charles.challenge.collections;

import br.com.charles.challenge.collections.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EqualsHashCodTest {
    public static void main(String[] args) {
        Student student1 = new Student("Jobscleber", 10);
        Student student11 = new Student("Jobscleber", 10);

        ArrayList arrayList = new ArrayList<>(List.of(student1, student11));
        HashSet hashSet = new HashSet(Set.of(student1));

        /*
        Comparando as referências com equals:
        O método equals e hashcode estão comentados na classe Student.
        Ao descomentar apenas o equals, o resultado de arraylist passará a ser true
        Ao descomentar o equals e hashcode o resultado de hashSet passará a ser true
         */

        System.out.println(arrayList.get(0).equals(arrayList.get(1)));
        System.out.println(hashSet.contains(student11));

    }

}
