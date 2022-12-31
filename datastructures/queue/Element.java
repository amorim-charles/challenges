package br.com.charles.challenge.datastructures.queue;

public class Element {
    private String value;
    private Element next;

    public Element(String value, Element next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" + value + "}";
    }
}
