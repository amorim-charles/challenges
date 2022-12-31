package br.com.charles.challenge.datastructures;

import br.com.charles.challenge.datastructures.queue.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.push("primeira");
        System.out.println(queue);
        queue.push("Segundo");
        System.out.println(queue);
        queue.push("Terceiro");
        System.out.println(queue);
        queue.push("Quarto");
        System.out.println(queue);
        queue.push("Quinto");
        System.out.println(queue);

        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue);

    }
}
