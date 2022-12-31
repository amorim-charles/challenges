package br.com.charles.challenge.datastructures.listlinkeddoubly;

public class ListDoublyLinked {
    private Element start = null;
    private Element end = null;
    private int totalElements = 0;

    public void add(Object object) {
        if (totalElements == 0) {
            addStart(object);
            return;
        }

        addEnd(object);
    }

    public void add(Object object, int position) {
        if (position > totalElements) {
            throw new ArrayIndexOutOfBoundsException("Posição inválida");
        }
        if (position == 0) {
            addStart(object);
            return;
        }

        if (position == totalElements) {
            addEnd(object);
            return;
        }

        Element actual = get(position-1);
        Element newElement = new Element(actual, object, actual.getNext());
        actual.setNext(newElement);
        totalElements++;
    }

    private void addStart(Object object) {
        Element newElement = new Element(null, object, start);
        this.start = newElement;
        this.end = this.start;
        totalElements++;
    }

    private void addEnd(Object object) {

        Element actual = new Element(end, object, null);
        this.end.setNext(actual);
        this.end = actual;
        totalElements++;
    }

    public Element get(int position) {
        if (position >= totalElements || position < 0) {
            throw new ArrayIndexOutOfBoundsException("Posição inválida");
        }

        Element actual = start;
        for (int i = 0; i < position; i++) {
            actual = actual.getNext();
        }
        return actual;
    }

    public void remove(int position) {
        if (position >= totalElements || position < 0) {
            throw new ArrayIndexOutOfBoundsException("Posição inválida");
        }

        Element actual = get(position);
        if (position == 0) {
            this.start = actual.getNext();
            totalElements--;
            return;
        }

        Element previous = actual.getPrevious();
        previous.setNext(actual.getNext());
        totalElements--;
    }

    @Override
    public String toString() {
        Element actual = start;
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < totalElements; i++) {
            builder.append(actual.getObject());
            builder.append(", ");
            actual = actual.getNext();
        }

        builder.append("]");
        return builder.toString();
    }
}

