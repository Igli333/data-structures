package LinkedList;

import LinkedList.Singly.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.insert(2);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);

        LinkedList<Integer> pist = new LinkedList<>();
        pist.insert(1);
        pist.insert(2);
        pist.insert(4);

        list.join(pist);
        LinkedList.printList(list);


    }
}
