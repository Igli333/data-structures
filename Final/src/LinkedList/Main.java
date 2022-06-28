package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.insert(4);
        list.insert(6);
        list.insert(2);
        list.insert(1);
        list.insert(7);
        list.insert(5);

        LinkedList<Integer> l = new LinkedList<Integer>();
        l.insert(2);
        l.insert(7);

        LinkedList.printList(list);
        list.reverse();

        System.out.println();
        LinkedList.printList(list);


    }
}
