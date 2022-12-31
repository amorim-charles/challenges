package br.com.charles.challenge.datastructures.array;

import java.util.Arrays;

public class Array {
    private String[] arrays = new String[10];
    private int totalElements = 0;

    public void add(String name) {
        moreSpaceArray();

        arrays[totalElements] = name;
        totalElements++;
    }

    public void add(int position, String name) {
        moreSpaceArray();

        for (int i = totalElements; i >= position; i--) {
            arrays[i+1] = arrays[i];
        }
        arrays[position] = name;
        totalElements++;
    }

    public String get(int position) {
        verifyPosition(position);
        return arrays[position-1];
    }

    public void remove(int position) {
        verifyPosition(position);
        for (int i = position; i < arrays.length -1; i++) {
            arrays[i] = arrays[i+1];
        }

        totalElements--;
    }

    public int length() {
        return totalElements;
    }

    public String[] getArrays() {
        return arrays;
    }
    private void verifyPosition(int position) {
        if (position <=0 || position > totalElements) {
            throw new ArrayIndexOutOfBoundsException("Posição inválida");
        }
    }

    private void moreSpaceArray () {
        if (totalElements == arrays.length) {
            String[] newArray = new String[arrays.length * 2];
            for (int i = 0; i < arrays.length; i++) {
                newArray[i] = arrays[i];
            }
            this.arrays = newArray;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arrays);
    }
}
