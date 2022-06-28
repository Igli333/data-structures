package LinkedList;

public class LinkedList<AnyType> {

    private ListNode<AnyType> header;

    public LinkedList() {
        this.header = new ListNode<AnyType>();
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public void makeEmpty() {
        header.next = null;
    }

    public LinkedListIterator<AnyType> zeroth() {
        return new LinkedListIterator<AnyType>(header);
    }

    public LinkedListIterator<AnyType> first() {
        return new LinkedListIterator<AnyType>(header.next);
    }

    public LinkedListIterator<AnyType> find(AnyType x) {
        LinkedListIterator<AnyType> itr = first();

        while (itr.isValid()) {
            if (itr.retrieve().equals(x)) {
                return itr;
            }
            itr.advance();
        }

        return zeroth();
    }

    public LinkedListIterator<AnyType> findPrevious(AnyType x) {
        LinkedListIterator<AnyType> itr = first();

        while (itr.isValid()) {
            if (itr.current.next.equals(x)) {
                return itr;
            }
            itr.advance();
        }

        return zeroth();
    }

    public static <AnyType> void printList(LinkedList<AnyType> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        ListNode<AnyType> itr = list.header.next;
        while (itr != null) {
            System.out.print(itr.element + " ");
            itr = itr.next;
        }
    }

    public void insert(AnyType x, LinkedListIterator<AnyType> itr) {
        ListNode<AnyType> newNode = new ListNode<AnyType>(x);
        if (itr.current.next != null) {
            newNode.next = itr.current.next;
        }
        itr.current.next = newNode;
    }

    public void insert(AnyType x) {
        ListNode<AnyType> itr = header;
        while (itr != null) {
            if (itr.next == null) {
                itr.next = new ListNode<AnyType>(x);
                return;
            }
            itr = itr.next;
        }
    }

    public void remove(AnyType x) {
        ListNode<AnyType> itr = header;
        while (itr.next != null) {
            if (itr.next.element.equals(x)) {
                itr.next = itr.next.next;
                return;
            }
            itr = itr.next;
        }
    }

    public int sum() {
        ListNode<AnyType> itr = header.next;
        int s = 0;
        while (itr != null) {
            s += (int) itr.element;
            itr = itr.next;
        }

        return s;
    }

    public int length() {
        ListNode<AnyType> itr = header.next;
        int l = 0;
        while (itr != null) {
            l++;
        }

        return l;
    }

    public AnyType findValue(int k) {
        ListNode<AnyType> itr = header.next;
        int count = 0;
        while (itr != null) {
            count++;
            if (count == k) {
                return itr.element;
            }
        }
        return null;
    }

    public void insertAt(AnyType x, int j) {
        ListNode<AnyType> itr = header.next;
        ListNode<AnyType> newNode = new ListNode<>(x);
        int count = 1;
        while (itr != null) {
            count++;
            if (j == count) {
                newNode.next = itr.next;
                itr.next = newNode;
                return;
            }

            itr = itr.next;

        }
    }

    public int lengthBetween(ListNode<AnyType> a, ListNode<AnyType> b) {
        int length = 0;
        ListNode<AnyType> start = a;

        if (start.next != b) {
            length++;
            start = start.next;
        }

        return length;
    }

    public void maxToStartAndMinToEnd() {
        maxToStart();
        minToEnd();
    }

    private void minToEnd() {
        ListNode<AnyType> itr = header.next;
        ListNode<AnyType> min = header.next, minPrevious = header;

        while (itr.next != null) {
            if ((int) itr.next.element < (int) min.element) {
                min = itr.next;
                minPrevious = itr;
            }

            itr = itr.next;
        }

        minPrevious.next = minPrevious.next.next;

        itr.next = min;
        min.next = null;
    }

    private void maxToStart() {
        ListNode<AnyType> itr = header.next;
        ListNode<AnyType> max = header.next, maxPrevious = header;

        while (itr.next != null) {
            if ((int) itr.next.element > (int) max.element) {
                maxPrevious = itr;
                max = itr.next;
            }

            itr = itr.next;
        }

        maxPrevious.next = maxPrevious.next.next;

        max.next = header.next;
        header.next = max;
    }

    public void deleteOf(LinkedList<AnyType> l) {
        ListNode<AnyType> itr1 = header.next, itr2;
        while (itr1 != null) {
            itr2 = l.header.next;
            while (itr2 != null) {
                if (itr1.element.equals(itr2.element)) {
                    remove(itr1.element);
                    break;
                }
                itr2 = itr2.next;
            }
            itr1 = itr1.next;
        }
    }

    public void reverse(){
        ListNode<AnyType> previous = null;
        ListNode<AnyType> current = header.next;
        ListNode<AnyType> next = null;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        header.next = previous;
    }

}
