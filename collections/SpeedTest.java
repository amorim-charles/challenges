package br.com.charles.challenge.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class SpeedTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        //Teste de velocidade de adição elementos (add)
        //-------------------------------------------------------------------

        //ArrayList (add)
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ArrayList ----- (add) = " + duration);

        //LinkedList (add)
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList ---- (add) = " + duration);

        //HashSet (add)
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashSet.add(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("HashSet ------- (add) = " + duration);

        //LinkedHashSet (add)
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedHashSet.add(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedHashSet - (add) = " + duration);
        System.out.println();


        //Teste de velocidade para trazer elementos (get)
        //-------------------------------------------------------------------

        //ArrayList (get)
        startTime = System.nanoTime();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList ----- (get) ---- = " + duration);

        //LinkedList (get)
        startTime = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList ---- (get) ---- = " + duration);

        //HashSet (iterator)
        startTime = System.nanoTime();
        for (int i = 0; i < hashSet.size(); i++) {
            hashSet.iterator().next();
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("HashSet ------- (iterator) = " + duration);

        //LinkedHashSet (iterator)
        startTime = System.nanoTime();
        for (int i = 0; i < linkedHashSet.size(); i++) {
            linkedHashSet.iterator().next();
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedHashSet - (iterator) = " + duration);
        System.out.println();


        //Teste de velocidade para remover elementos (remove)
        //-------------------------------------------------------------------

        //ArrayList (remove)
        startTime = System.nanoTime();
        for (int i = arrayList.size()-1; i > 0; i--) {
            arrayList.remove(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList ----- (remove) = " + duration);

        //LinkedList (remove)
        startTime = System.nanoTime();
        for (int i = linkedList.size()-1; i > 0; i--) {
            linkedList.remove(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList ---- (remove) = " + duration);

        //HashSet (remove)
        startTime = System.nanoTime();
        for (int i = hashSet.size()-1; i > 0; i--) {
            hashSet.remove(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("HashSet ------- (remove) = " + duration);

        //LinkedHashSet (remove)
        startTime = System.nanoTime();
        for (int i = linkedHashSet.size()-1; i > 0; i--) {
            linkedHashSet.remove(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedHashSet - (remove) = " + duration);

    }
}
