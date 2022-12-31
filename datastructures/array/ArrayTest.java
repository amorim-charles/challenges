package br.com.charles.challenge.datastructures;

import br.com.charles.challenge.datastructures.array.Array;

public class ArrayTest {
    public static void main(String[] args) {
        Array array = new Array();
        array.add("Carlos");
        array.add("Maria");
        array.add("João");
        array.add("Cleber");
        array.add("Josefina");

        System.out.println("Lista com nomes: \n" + array);
        System.out.println("Tamanho do Array: " + array.getArrays().length + "\nQuantidade de elementos: " + array.length());

        //adicionando elemento no meio da lista
        array.add(2, "AQUI");
        System.out.println("\nAdicionando AQUI na posição 2: \n" + array);
        System.out.println("Tamanho do Array: " + array.getArrays().length + "\nQuantidade de elementos: " + array.length());

        //removendo elemento no meio da lista
        array.remove(3);
        System.out.println("\nRemovendo João: \n" + array);
        System.out.println("Tamanho do Array: " + array.getArrays().length + "\nQuantidade de elementos: " + array.length());

        //Adicionando elementos até a lista aumentar de tamanho
        array.add("Joaquim");
        array.add("Mariane");
        array.add("Cassio");
        array.add("Godofredo");
        array.add("Carla");
        array.add("ESSE NÃO CABERIA");

        System.out.println("\nAdicionando um elemento a mais que o tamanho do array \n" + array);
        System.out.println("Tamanho do Array: " + array.getArrays().length + "\nQuantidade de elementos: " + array.length());
    }
}
