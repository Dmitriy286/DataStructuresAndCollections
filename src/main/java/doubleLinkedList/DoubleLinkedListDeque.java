package doubleLinkedList;

public class DoubleLinkedListDeque {

    private DoubleLinkedList doubleLinkedList;
    private int maxSize;

    public DoubleLinkedListDeque(int maxSize) {
        this.doubleLinkedList = new DoubleLinkedList();
        this.maxSize = maxSize;
    }

    public void insertRight(long item) {
        if (isFull()) {
            System.out.println("Error: deque is full");
            return;
        }

        doubleLinkedList.insertLast(item);
    }

    public void insertLeft(long item) {
        if (isFull()) {
            System.out.println("Error: deque is full");
            return;
        }

        doubleLinkedList.insertFirst(item);
    }

    public Long removeRight() {

        if (Boolean.FALSE.equals(isEmpty())) {
            long result = doubleLinkedList.getTailValue();

            doubleLinkedList.deleteFirst();

            return result;
        }

        System.out.println("Deque is empty");

        return null;
    }

    public Long removeLeft() {
        if (Boolean.FALSE.equals(isEmpty())) {
            long result = doubleLinkedList.getHeadValue();

            doubleLinkedList.deleteFirst();

            return result;
        }

        System.out.println("Deque is empty");

        return null;
    }

    public boolean isEmpty() {
        return doubleLinkedList.isEmpty();
    }

    public boolean isFull() {
        return maxSize == doubleLinkedList.size();
    }

    public void display() {
        doubleLinkedList.displayForward();
    }

}
