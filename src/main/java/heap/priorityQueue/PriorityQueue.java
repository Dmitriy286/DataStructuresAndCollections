package heap.priorityQueue;

import heap.descHeap.Heap;

public class PriorityQueue {
    private int maxSize;
    private Heap heap;
    private int nItems;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new Heap(maxSize);
        this.nItems = 0;
    }

    public void insert(int item) {

        if (maxSize == nItems) {
            System.out.println("Limit is reached");
            return;
        }

        heap.insert(item);

        nItems++;
    }

    public long remove() {

        nItems--;

        return heap.remove().getKey();
    }

    public long peekMax() {

        int temp = heap.remove().getKey();

        heap.insert(temp);

        return temp;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }
}
