package heap.binaryTreePriorityQueue;

import heap.descHeap.Heap;

public class PriorityQueue {
    private int maxSize;
    private Tree tree;
    private int nItems;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.tree = new Tree();
        this.nItems = 0;
    }

    public void insert(int item) {

        if (maxSize == nItems) {
            System.out.println("Limit is reached");
            return;
        }

        tree.insert(item, item);

        nItems++;

//        tree.traverse(1);
        tree.display();
    }

    public int remove() {

        tree.display();

        nItems--;

        return tree.removeMax().iData;
    }

    public long peekMax() {

        int temp = tree.removeMax().iData;

        tree.insert(temp, temp);

        return temp;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }
}
