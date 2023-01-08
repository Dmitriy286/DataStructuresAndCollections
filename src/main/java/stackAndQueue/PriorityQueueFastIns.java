package stackAndQueue;

public class PriorityQueueFastIns {
    private int maxSize;
    private long[] pQueueArray;
    private int nItems;

    public PriorityQueueFastIns(int maxSize) {
        this.maxSize = maxSize;
        this.pQueueArray = new long[maxSize];
        this.nItems = 0;
    }

    public void insert(long item) {
        pQueueArray[nItems++] = item;
    }

    public long remove() {
        int minIndex = findMinIndex();
        long returnValue = pQueueArray[minIndex];
        for (int i = minIndex; i < nItems - 1; i++) {
            pQueueArray[i] = pQueueArray[i + 1];
        }
        nItems--;
        return returnValue;
    }

    private int findMinIndex() {
        int minIndex = 0;
        for (int i = 1; i < nItems; i++) {
            if (pQueueArray[minIndex] > pQueueArray[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void display() {
        for (int i = 0; i < nItems; i++) {
            System.out.print(pQueueArray[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return nItems == 0;
    }
}
