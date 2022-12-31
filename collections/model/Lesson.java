package br.com.charles.challenge.collections.model;

public class Lesson {
    private String title;
    private int duration;

    public Lesson(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "{title=" + title + ", duration=" + duration +"}";
    }
}
