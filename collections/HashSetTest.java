package br.com.charles.challenge.collections;

import br.com.charles.challenge.collections.model.Lesson;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Lesson lesson1 = new Lesson("Primeira aula", 10);
        Lesson lesson2 = new Lesson("Segunda aula", 20);
        Lesson lesson3 = new Lesson("Terceira aula", 30);
        Lesson lesson4 = new Lesson("Quarta aula", 40);
        Lesson lesson5 = new Lesson("Quarta aula", 50);

        /*
         * Interface Set
         * HashSet não permite referências duplicadas, também não garante a ordem de inserção na lista.
        */

        //Iinicializando com List.of ou Arrays.of
        Set<Lesson> lessonSet = new HashSet<>(Set.of(lesson1, lesson2));

        //Adicionando mais referências
        lessonSet.add(lesson3);
        lessonSet.add(lesson4);
        lessonSet.add(lesson5);


        //Adicionando referência duplicada
        lessonSet.add(lesson4);

        System.out.println("\nExibindo a lista:\n");
        System.out.println(lessonSet);
        System.out.println("--------------------------------------\n");

        System.out.println("forEach com method reference:\n");
        lessonSet.forEach(System.out::println);
        System.out.println("--------------------------------------\n");

        System.out.println("forEach com Expressão Lambda:\n");
        lessonSet.forEach(lesson -> System.out.println(lesson));
        System.out.println("--------------------------------------\n");

        System.out.println("Métodos de Set\n");
        System.out.println(" - add = "  + lessonSet.add(lesson5) + "\t\t Adiciona uma referência na lista (boolean)");
        System.out.println(" - iterator.next = "  + lessonSet.iterator().next() + "\t Retorna um referência tipo get");
        System.out.println(" - remove = "  + lessonSet.remove(lesson5) + "\t Remove uma referência da lista (boolean)");
        System.out.println(" - size = " + lessonSet.size() + "\t\t\t Retorna o tamanho da lista (Integer)");
        System.out.println(" - contains = " + lessonSet.contains(lesson1) + "\t Retorna se o objeto está na lista (boolean)");
        System.out.println(" - isEmpty = "  + lessonSet.isEmpty() + "\t Retorna se a lista está vazia (boolean)");
        System.out.println(" - equals = "  + lessonSet.equals(lessonSet) + "\t Compara se duas lista são iguais (boolean)");
    }
}
