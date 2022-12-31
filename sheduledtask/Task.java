package br.com.charles.challenge.sheduledtask;

public class Task {

    private int startTask;
    private int endTask;

    public Task(int startTask, int endTask) {
        this.startTask = startTask;
        this.endTask = endTask;
    }

    public int getStartTask() {
        return startTask;
    }

    public int getEndTask() {
        return endTask;
    }

    @Override
    public String toString() {
        return "{" + startTask +", " + endTask + '}';
    }
}