package br.com.charles.challenge.datastructures.stack;

public class Stack {
    private Element start = null;
    private Element end = null;
    private int totalElements = 0;

    public void push(String status) {
        Element newElement = new Element(status, null);
        if (totalElements == 0) {
            this.start = newElement;
            this.end = this.start;
            totalElements++;
            return;
        }

        this.end.setNext(newElement);
        this.end = newElement;
        totalElements++;
    }

    public Element peek() {
        Element actual = start;
        for (int i = 0; i < totalElements - 1; i++) {
            actual = actual.getNext();
        }
        return actual;
    }

    public void pop() {
        Element actual = start;
        for (int i = 0; i < totalElements; i++) {
            if (actual.getNext() == end) {
                actual.setNext(null);
                this.end = actual;
                totalElements--;
                break;
            }
            actual = actual.getNext();
        }
    }

    @Override
    public String toString() {
        Element actual = start;
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < totalElements; i++) {
            builder.append(actual.getValue());
            builder.append(", ");
            actual = actual.getNext();
        }

        builder.append("]");
        return builder.toString();
    }
}
