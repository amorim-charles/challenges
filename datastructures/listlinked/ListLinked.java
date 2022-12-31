package br.com.charles.challenge.datastructures.listlinked;

public class ListLinked {
    public Element start = null;
    private Element end = null;
    private int totalElements = 0;

    public void add(String value) {
        if (this.totalElements == 0) {
            addStart(value);
            return;
        }

        addEnd(value);
    }

    public void add(String value, int position) {
        if (position == 0) {
            addStart(value);
            return;
        }

        if (position == this.totalElements) {
            addEnd(value);
            return;
        }

        Element actual = get(position - 1);
        actual.setNext(new Element(value, actual.getNext()));
        totalElements++;
    }

    public Element get(int position) {
        if (!invalidPosition(position)) {
            throw new IllegalArgumentException("Posicao inválida");
        }

        Element actual = start;

        for (int i = 0; i < position; i++) {
            actual = actual.getNext();
        }

        return actual;
    }

    public void remove(int position) {
        if (!(totalElements > 0)){
            throw new IllegalArgumentException("Lista vazia");
        }

        if (position == 0) {
            removeStart();
            return;
        }

        if (position == totalElements) {
            removeEnd(position);
            return;
        }

        Element previous = get(position - 1);
        Element actual = get(position);
        for (int i = position; i < totalElements; i++) {
            previous.setNext(actual.getNext());
        }

        totalElements--;
    }

    public boolean contains(String value) {
        Element actual = start;
        for (int i = 0; i < totalElements; i++) {
            if (actual.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private void addStart(String value) {
        Element element = new Element(value, start);
        this.start = element;
        this.end = this.start;
        this.totalElements++;
    }

    private void addEnd(String value) {
        Element element = new Element(value, null);
        this.end.setNext(element);
        this.end = element;
        this.totalElements++;
    }

    private void removeStart() {
        this.start = this.start.getNext();
        totalElements--;
        this.end = null;
    }

    private void removeEnd(int position) {
        Element previous = get(position);
        previous.setNext(null);
        totalElements--;
    }

    private boolean invalidPosition(int position) {
        return position >= 0 && position < this.totalElements;
    }

    @Override
    public String toString() {
        Element actual = start;
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < totalElements; i++) {
            builder.append(actual.getValue());
            builder.append(", ");
            actual = actual.getNext();
        }

        builder.append("]");
        return builder.toString();
    }
}
