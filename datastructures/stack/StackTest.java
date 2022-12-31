package br.com.charles.challenge.datastructures;

import br.com.charles.challenge.datastructures.stack.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push("Prato1");
        System.out.println(stack);
        stack.push("Prato2");
        System.out.println(stack);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);

    }
}
