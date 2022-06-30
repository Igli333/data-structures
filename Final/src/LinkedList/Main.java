package LinkedList;

import LinkedList.Doubly.DoublyLinkedList;
import LinkedList.Singly.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.insert(2);
        list.insert(6);
        list.insert(3);
        list.insert(3);
        list.insert(9);
        list.insert(10);

        list.sort();

        LinkedList.printList(list);




    }
}
