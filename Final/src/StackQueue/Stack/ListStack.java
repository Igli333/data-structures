package StackQueue.Stack;

import LinkedList.Singly.ListNode;

public class ListStack<AnyType> {
    private ListNode<AnyType> topOfStack;

    public ListStack() {
        topOfStack = new ListNode<>();
    }

    public boolean isEmpty() {
        return topOfStack.element == null;
    }

    public void makeEmpty() {
        topOfStack.next = null;
        topOfStack.element = null;
    }

    public void push(AnyType x) {
        ListNode<AnyType> newNode = new ListNode<>(x);
        newNode.next = topOfStack;
        topOfStack = newNode;
    }

    public AnyType pop() {
        ListNode<AnyType> oldNode = topOfStack;
        topOfStack = topOfStack.next;
        return oldNode.element;
    }

    public void printStack() {
        ListNode<AnyType> itr = topOfStack;
        while (itr.next != null) {
            System.out.print(itr.element + " ");
            itr = itr.next;
        }
    }
}
