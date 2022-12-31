package br.com.charles.challenge.datastructures.queue;

public class Queue {
    private Element start;
    private Element end;
    private int totalElement = 0;

    public void push(String value){
        Element newElement = new Element(value, null);
        if (totalElement >= 1) {
            Element actual = end;
            actual.setNext(newElement);
            this.end = newElement;
            totalElement++;
            return;
        }

        this.start = newElement;
        this.end = this.start;
        totalElement++;
    }

    public Element peek(){
        return start;
    }

    public void pop(){
        Element actual = start;
        Element next = actual.getNext();
        this.start = next;
        totalElement--;
    }

    @Override
    public String toString() {
        Element actual = start;
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < totalElement; i++) {
            builder.append(actual.getValue());
            builder.append(", ");
            actual = actual.getNext();
        }
        builder.append("]");
        return builder.toString();
    }
}
