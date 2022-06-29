package LinkedList.Doubly;

public class DoublyListNode<AnyType> {
    public AnyType element;
    public DoublyListNode<AnyType> previous;
    public DoublyListNode<AnyType> next;

    public DoublyListNode(AnyType element) {
        this.element = element;
    }
}
