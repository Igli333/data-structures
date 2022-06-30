package StackQueue.Stack;

import LinkedList.Singly.ListNode;

public class ListStack<AnyType> {
    private ListNode<AnyType> topOfStack;

    public ListStack() {
        topOfStack = null;
    }

    public boolean isEmpty() {
        return topOfStack == null;
    }

    public void makeEmpty() {
        topOfStack = null;
    }

    public void push(AnyType x) {
        ListNode<AnyType> newNode = new ListNode<>(x);
        if (isEmpty()){
            topOfStack = newNode;
            return;
        }

        newNode.next = topOfStack;
        topOfStack = newNode;
    }

    public AnyType pop() {
        ListNode<AnyType> oldNode = topOfStack;
        topOfStack = topOfStack.next;
        return oldNode.element;
    }

    public AnyType top() {
        return topOfStack.element;
    }

    public void printStack() {
        ListNode<AnyType> itr = topOfStack;
        while (itr != null) {
            System.out.print(itr.element + " ");
            itr = itr.next;
        }
    }

    public int size(){
        ListNode<AnyType> itr = topOfStack;
        int s = 0;
        while (itr != null){
            s++;
            itr = itr.next;
        }
        return s;
    }

    public void sort() {
        ListNode<AnyType> itr = topOfStack;
        ListNode<AnyType> itr2 = null;
        AnyType temp;

        while (itr != null) {
            itr2 = itr.next;

            while (itr2 != null) {
                if ((int) itr.element > (int) itr2.element) {
                    temp = itr.element;
                    itr.element = itr2.element;
                    itr2.element = temp;
                }

                itr2 = itr2.next;
            }
            itr = itr.next;
        }
    }

    public void putOnTop(int k){
        int index = size() - k + 1;
        ListNode<AnyType> itr = topOfStack;
        ListNode<AnyType> temp = null;
        int c = 1;
        while (itr != null){
            if (c == index - 1){
                break;
            }
            itr = itr.next;
            c++;
        }

        ListNode<AnyType> last = itr.next;
        itr.next = itr.next.next;
        push(last.element);
    }
}
