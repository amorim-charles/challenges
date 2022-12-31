package br.com.charles.challenge.sheduledtask;

import java.util.Stack;

public class SheduledTask {

    private Stack<Task> scheduled = new Stack<>();

    public boolean markTask(Task input) {
        if (input == null) {
            return false;
        }

        if (!scheduled.isEmpty()) {
            for (int i = 0; i >= scheduled.size()-1; i++) {
                if (input.getStartTask() >= scheduled.get(i).getStartTask()
                        && input.getStartTask() <= scheduled.get(i).getEndTask()
                        || input.getEndTask() >= scheduled.get(i).getStartTask()
                        && input.getEndTask() <= scheduled.get(i).getEndTask()) {
                    return false;
                }
            }
        }

        scheduled.add(input);
        System.out.println(scheduled);
        return true;
    }
}
