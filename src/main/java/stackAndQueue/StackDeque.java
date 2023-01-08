package stackAndQueue;

public class StackDeque {
    private Deque stackDeque;

    public StackDeque(int maxSize) {
        stackDeque = new Deque(maxSize);
    }

    public void push(long item) {
        stackDeque.insertLeft(item);
    }

    public long pop() {
        return stackDeque.removeLeft();
    }

    public long peek() {
        long temp = stackDeque.removeLeft();
        stackDeque.insertLeft(temp);
        return temp;
    }

    public boolean isEmpty() {
        return stackDeque.isEmpty();
    }

    public boolean isFull() {
        return stackDeque.isFull();
    }
}
