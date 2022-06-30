package StackQueue;

import StackQueue.Stack.ArrayStack;
import StackQueue.Stack.ListStack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(6);
        stack.push(3);
        stack.push(9);
        stack.push(10);

        stack = sort(stack);

        stack.printStack();

    }

    public static String decToHex(int a) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        while (a % 16 != 0) {
            stack.push(a % 16);
            a = a / 16;
        }

        String[] hexes = {"A", "B", "C", "D", "E", "F"};
        String result = "";
        while (!stack.isEmpty()) {
            if (stack.top() > 9) {
                result += hexes[stack.top() - 10];
            } else {
                result += stack.top().toString();
            }
            stack.pop();
        }

        return result;
    }

    public static ArrayStack<Integer> sort(ArrayStack<Integer> stack) {
        ArrayStack<Integer> newStack = new ArrayStack<>();
        int temp;

        while (!stack.isEmpty()) {
            temp = stack.pop();

            if(newStack.isEmpty()){
                newStack.push(temp);
                continue;
            }
            if (temp < newStack.top()) {
                while (!newStack.isEmpty()) {
                    stack.push(newStack.pop());
                    if (newStack.isEmpty() || newStack.top() < temp) {
                        newStack.push(temp);
                        break;
                    }
                }
            } else {
                newStack.push(temp);
            }
        }
        return newStack;
    }
}
