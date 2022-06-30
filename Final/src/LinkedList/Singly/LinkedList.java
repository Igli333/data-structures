package LinkedList.Singly;

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

    public void reverse() {
        ListNode<AnyType> previous = null;
        ListNode<AnyType> current = header.next;
        ListNode<AnyType> next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        header.next = previous;
    }

    public boolean palindrome() {
        ListNode<AnyType> start = header.next;
        ListNode<AnyType> end = header.next;

        while (end.next != null) {
            end = end.next;
        }

        while (start != end || end == header.next) {
            if (!start.element.equals(end.element)) {
                return false;
            }
            start = start.next;
            end = findPrevious(end);
        }

        return true;
    }

    private ListNode<AnyType> findPrevious(ListNode<AnyType> node) {
        ListNode<AnyType> itr = header.next;
        while (itr != null) {
            if (itr.next == node) {
                return itr;
            }
            itr = itr.next;
        }

        return null;

    }

    public void insert2(AnyType x) {
        ListNode<AnyType> itr = header;
        ListNode<AnyType> newNode = new ListNode<>(x);

        if (header.next == null) {
            header.next = new ListNode<>(x);
            return;
        }

        while (itr.next != null) {
            if ((int) itr.next.element >= (int) x) {
                newNode.next = itr.next;
                itr.next = newNode;
                return;
            }

            itr = itr.next;
        }

        itr.next = newNode;

    }

    public void switchUp(AnyType x) {
        ListNode<AnyType> itr = header;

        while (itr.next != null) {
            if (itr.next.element.equals(x)) {
                ListNode<AnyType> temp = itr.next;
                itr.next = itr.next.next;
                temp.next = itr.next.next;
                itr.next.next = temp;
                break;
            }
            itr = itr.next;
        }
    }

    public void removeEven() {
        ListNode<AnyType> itr = header;

        while (itr.next != null) {
            if ((int) itr.next.element % 2 == 0) {
                itr.next = itr.next.next;
                continue;
            }

            itr = itr.next;
        }
    }

    public void removeIndex(LinkedList<AnyType> pList) {
        ListNode<AnyType> l = header;
        ListNode<AnyType> p = pList.header.next;
        int c = 1;

        while (l.next != null && p != null) {
            if (c == (int) p.element) {
                l.next = l.next.next;
                c++;
                p = p.next;
                continue;
            }
            c++;
            l = l.next;
        }

    }

    public LinkedList<AnyType> join(LinkedList<AnyType> list2) {
        LinkedList<AnyType> listBashkuar = new LinkedList<>();
        LinkedListIterator<AnyType> itr1 = this.first();
        LinkedListIterator<AnyType> itr2 = list2.first();
        LinkedListIterator<AnyType> itrBashkuar = listBashkuar.zeroth();

        while (itr1.isValid() && itr2.isValid()) {
            if ((int) itr1.current.element >= (int) itr2.current.element) {
                itrBashkuar.current.next = new ListNode<>(itr2.retrieve(), new ListNode<>(itr2.retrieve()));
            } else {
                itrBashkuar.current.next = new ListNode<>(itr1.retrieve(), new ListNode<>(itr2.retrieve()));
            }
            itr1.advance();
            itr2.advance();
            itrBashkuar.advance();
            itrBashkuar.advance();
        }

        if (itr1.isValid()) {
            while (itr1.isValid()) {
                itrBashkuar.current.next = new ListNode<>(itr1.retrieve());
                itr1.advance();
                itrBashkuar.advance();
            }
        } else if (itr2.isValid()) {
            while (itr2.isValid()) {
                itrBashkuar.current.next = new ListNode<>(itr2.retrieve());
                itr2.advance();
                itrBashkuar.advance();
            }
        }

        return listBashkuar;
    }

    //Needs fixing
    public void sort() {
        ListNode<AnyType> itr = header;
        ListNode<AnyType> itr2 = null;
        ListNode<AnyType> temp = null;

        while (itr.next != null) {
            if (itr.next.next != null) {
                itr2 = itr.next.next;
            }

            while (itr2.next != null) {
                if ((int) itr.next.element >= (int) itr2.next.element) {
                    temp = itr2.next;
                    itr2.next = itr2.next.next;
                    temp.next = itr.next;
                    itr.next = temp;
                    itr = itr.next.next;
                    itr2 = itr2.next;
                    continue;
                }
                itr2 = itr2.next;
            }
            itr = itr.next;
        }
    }


}
