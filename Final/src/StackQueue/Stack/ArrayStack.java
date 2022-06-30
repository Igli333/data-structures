package StackQueue.Stack;

public class ArrayStack<AnyType> {
    private AnyType[] array;
    private int topOfStack;
    private static final int MIN_STACK = 40;

    public ArrayStack() {
        array = (AnyType[]) new Object[MIN_STACK];
        topOfStack = -1;
    }

    public boolean isEmpty() {
        return topOfStack == -1;
    }

    public void makeEmpty() {
        topOfStack = -1;
    }

    public void push(AnyType x) {
        array[++topOfStack] = x;
    }

    public AnyType pop() {
        AnyType x = array[topOfStack];
        topOfStack--;
        return x;
    }

    public AnyType top() {
        return array[topOfStack];
    }

    public int findLength() {
        return topOfStack + 1;
    }

    public void printStack() {
        for (int i = 0; i < topOfStack + 1; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void sort() {
        AnyType temp = null;
        for (int i = 0; i < topOfStack + 1; i++) {
            for (int j = i + 1; j < topOfStack + 1; j++) {
                if ((int) array[j] < (int) array[i]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public void putOnTop(int k) {
        ArrayStack<AnyType> stack = new ArrayStack<>();
        AnyType x = array[k - 1];
        for (int i = topOfStack; i > k - 1; i--) {
            stack.push(pop());
        }
        pop();
        while (!stack.isEmpty()) {
            push(stack.pop());
        }

        push(x);
    }



}
