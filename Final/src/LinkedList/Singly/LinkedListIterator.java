package LinkedList.Singly;

public class LinkedListIterator<AnyType> {
    public ListNode<AnyType> current;

    public LinkedListIterator(ListNode<AnyType> current) {
        this.current = current;
    }

    public boolean isValid() {
        return current != null;
    }

    public AnyType retrieve() {
        return current.element;
    }

    public void advance() {
        current = current.next;
    }
}
