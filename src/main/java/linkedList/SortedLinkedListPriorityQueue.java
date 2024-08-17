package linkedList;

public class SortedLinkedListPriorityQueue {

    private LinkedList linkedList;
    private int maxSize;

    public SortedLinkedListPriorityQueue(int maxSize) {
        this.linkedList = new LinkedList();
        this.maxSize = maxSize;
    }

    public void insert(int data) {

        if (this.linkedList.size() == maxSize) {
            System.out.println("Reached full capacity");

            return;
        }

        this.linkedList.sortingInsert(data);
    }

    public int remove() {
        return this.linkedList.deleteFirst().getIntData();
    }

    public int peek() {
        int result = this.linkedList.deleteFirst().getIntData();

        this.linkedList.sortingInsert(result);

        return result;
    }

    public void print() {
        this.linkedList.displayLinkedList();
    }

    public boolean isFull() {
        return this.linkedList.size() == maxSize;
    }

    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }
}
