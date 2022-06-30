package LinkedList.Doubly;

public class DoublyLinkedList<AnyType> {
    public DoublyListNode<AnyType> header;
    public DoublyListNode<AnyType> trailer;

    public DoublyLinkedList() {
        header = new DoublyListNode<>();
        trailer = new DoublyListNode<>();

        header.next = trailer;
        trailer.previous = header;
    }

    public boolean isEmpty() {
        return header.next == trailer;
    }

    public void makeEmpty() {
        header.next = trailer;
        trailer.previous = header;
    }

    public void insert(AnyType x) {
        DoublyListNode<AnyType> newNode = new DoublyListNode<>(x);

        newNode.previous = trailer.previous;
        newNode.next = trailer;
        trailer.previous.next = newNode;
        trailer.previous = newNode;
    }

    public static <AnyType> void printList(DoublyLinkedList<AnyType> l) {
        DoublyListNode<AnyType> itr = l.header.next;

        while (itr != l.trailer) {
            System.out.print(itr.element + " ");
            itr = itr.next;
        }
    }

    public void remove(AnyType x) {
        DoublyListNode<AnyType> itr = header.next;

        while (itr != trailer) {
            if (itr.element == x) {
                itr.previous.next = itr.next;
                itr.next.previous = itr.previous;
                return;
            }
            itr = itr.next;
        }

    }

    public void reverse() {
        DoublyListNode<AnyType> temp = null;
        DoublyListNode<AnyType> itr = header.next;

        while (itr != null) {
            temp = itr.next;
            itr.next = itr.previous;
            itr.previous = temp;

            itr = itr.previous;
        }

        temp = trailer;
        trailer = header;
        header = temp;

    }

    public boolean palindrome() {
        DoublyListNode<AnyType> itr1 = header.next;
        DoublyListNode<AnyType> itr2 = trailer.previous;

        while (itr1 != itr2 || itr2.next != itr1) {
            if (itr1.element != itr2.element) {
                return false;
            }

            itr1 = itr1.next;
            itr2 = itr2.previous;
        }

        return true;
    }

    public void switchUp(AnyType x) {
        DoublyListNode<AnyType> itr = header.next;
        DoublyListNode<AnyType> temp = null;

        while (itr != trailer) {
            if (itr.element == x) {
                temp = itr.next;
                itr.next.next.previous = itr;
                itr.next = itr.next.next;
                temp.previous = itr.previous;
                temp.next = itr;
                itr.previous.next = temp;
                itr.previous = temp;

                return;
            }

            itr = itr.next;
        }
    }
}
