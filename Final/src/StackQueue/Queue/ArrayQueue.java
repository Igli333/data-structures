package StackQueue.Queue;

public class ArrayQueue<AnyType> {
    private AnyType[] array;
    private int start, end;

    public ArrayQueue() {
        array = (AnyType[]) new Object[20];
    }

    public boolean isEmpty() {
        return start == end + 1;
    }

}
