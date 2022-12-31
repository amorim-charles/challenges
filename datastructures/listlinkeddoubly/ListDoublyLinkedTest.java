package br.com.charles.challenge.datastructures;

import br.com.charles.challenge.datastructures.listlinkeddoubly.ListDoublyLinked;

public class ListDoublyLinkedTest {
    public static void main(String[] args) {
        ListDoublyLinked array = new ListDoublyLinked();

        System.out.println(array);
        array.add("Santos");
        System.out.println(array);
        array.add("Samuel");
        System.out.println(array);
        array.add("Samara");
        System.out.println(array);
        array.add("Severina");
        System.out.println(array);

        array.add("MEIO2",2);
        System.out.println(array);

        System.out.println(array.get(4));

        array.remove(4);
        System.out.println(array);

    }
}
