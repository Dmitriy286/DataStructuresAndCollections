package tree.haffman;

public class PriorityQueue {
    private int maxSize;
    private Tree[] queArray;
    private int nItems;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queArray = new Tree[maxSize];
        this.nItems = 0;
    }

    public void insert(Tree item) {

        if (maxSize == nItems) {
            System.out.println("Limit is reached");
            return;
        }

        int i;
        if (nItems == 0) {
            queArray[nItems++] = item;
        } else {
            for (i = nItems - 1; i >= 0; i--) {
                if (item.getRoot().frequency > queArray[i].getRoot().frequency) {
                    queArray[i + 1] = queArray[i];
                } else {
                    break;
                }
            }
            queArray[i + 1]  = item;
            nItems++;
        }
    }

    public Tree remove() {
        return queArray[--nItems];
    }

    public Tree peekMin() {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }
}
