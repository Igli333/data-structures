package StackQueue.Queue;

import LinkedList.Singly.ListNode;

public class ListQueue<AnyType> {
    private ListNode<AnyType> start, end;

    public ListQueue() {
        start = end = null;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public void makeEmpty(){
        start = end = null;
    }

    public void enqueue(AnyType x){
        ListNode<AnyType> newNode = new ListNode<>(x);
        end.next = newNode;
        end = end.next;
    }

    public AnyType dequeue(){
        ListNode<AnyType> old = start;
        start = start.next;
        return old.element;
    }


}
