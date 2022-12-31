package br.com.charles.challenge.datastructures.listlinkeddoubly;

public class Element {
    private Element previous;
    private Object object;
    private Element next;

    public Element(Element previous, Object object, Element next) {
        this.next = next;
        this.object = object;
        this.previous = previous;
    }

    public Element getNext() {
        return next;
    }

    public Object getObject() {
        return object;
    }

    public Element getPrevious() {
        return previous;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public void setPrevious(Element previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "[" + object + "]";
    }
}
