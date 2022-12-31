package br.com.charles.challenge.datastructures;

import br.com.charles.challenge.datastructures.listlinked.ListLinked;

public class ListLinkedTest {
    public static void main(String[] args) {
        ListLinked listLinked = new ListLinked();

        System.out.println(listLinked);
        listLinked.add("Carlos");
        System.out.println(listLinked);
        listLinked.add("Douglas");
        System.out.println(listLinked);
        listLinked.add("Fábio");
        System.out.println(listLinked);
        listLinked.add("Daniel");
        System.out.println(listLinked);

        listLinked.add("meio1", 1);
        listLinked.add("meio3", 3);
        listLinked.add("meio5", 5);
        System.out.println(listLinked);

        listLinked.remove(0);
        System.out.println(listLinked);
        System.out.println(listLinked.contains("meio1"));

    }
}
