package StackQueue;

import StackQueue.Stack.ArrayStack;
import StackQueue.Stack.ListStack;

public class Main {
    public static void main(String[] args) {
        ListStack<Integer> stack = new ListStack<>();
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(1);

        stack.printStack();

        stack.pop();
        stack.printStack();

    }
}
