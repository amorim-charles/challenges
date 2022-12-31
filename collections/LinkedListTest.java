package br.com.charles.challenge.collections;

import br.com.charles.challenge.collections.model.Lesson;

import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        Lesson lesson1 = new Lesson("Primeira aula", 10);
        Lesson lesson2 = new Lesson("Segunda aula", 20);
        Lesson lesson3 = new Lesson("Terceira aula", 30);
        Lesson lesson4 = new Lesson("Quarta aula", 40);
        Lesson lesson5 = new Lesson("Quarta aula", 50);

        /*
        LinkedList permite valores duplicados e não garante a ordem de inserção na lista.
        É mais eficiente que ArrayList para add e remove, mas perde em get.
        */

        //Iinicializando com List.of ou Arrays.of
        List<Lesson> lessonList = new java.util.LinkedList<>(List.of(lesson1, lesson2));

        //Adcionando mais duas referências
        lessonList.add(lesson3);
        lessonList.add(lesson4);

        //adicionando referência duplicada
        lessonList.add(lesson4);

        System.out.println("\nExibindo a lista:\n");
        System.out.println(lessonList);
        System.out.println("--------------------------------------\n");

        System.out.println("forEach com method reference:\n");
        lessonList.forEach(System.out::println);
        System.out.println("--------------------------------------\n");

        System.out.println("forEach com Expressão Lambda:\n");
        lessonList.forEach(lesson -> System.out.println(lesson));
        System.out.println("--------------------------------------\n");

        System.out.println("Métodos de List\n");
        System.out.println(" - add = "  + lessonList.add(lesson5) + "\t\t Adiciona uma referência na lista (boolean)");
        System.out.println(" - remove = "  + lessonList.remove(lesson5) + "\t Remove uma referência da lista (boolean)");
        System.out.println(" - size = " + lessonList.size() + "\t\t\t Retorna o tamanho da lista (Integer)");
        System.out.println(" - contains = " + lessonList.contains(lesson1) + "\t Retorna se o objeto está na lista (boolean)");
        System.out.println(" - isEmpty = "  + lessonList.isEmpty() + "\t Retorna se a lista está vazia (boolean)");
        System.out.println(" - equals = "  + lessonList.equals(lessonList) + "\t Compara se duas lista são iguais (boolean)");
        System.out.println(" - subList = "  + lessonList.subList(1,3) + "\t Retorna uma sublista (list)");

    }
}
