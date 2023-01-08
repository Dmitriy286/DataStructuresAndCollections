package stackAndQueue;


//Создайте класс Deque по описанию деков (двусторонних очередей) в этой главе.
//Класс должен содержать методы
//        insertLeft(),
//        insertRight(),
//        removeLeft(),
//         removeRight(),
//        isEmpty() и
//        isFull().
//Также в нем должна быть реализована поддержка циклического переноса индексов, по аналогии с очередями.

public class Deque {
    private int maxSize;
    private long[] dequeArray;
    private int front;
    private int rear;
    private int nItems;

    public Deque(int maxSize) {
        this.maxSize = maxSize;
        this.dequeArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insertRight(long item) {
        if (!insertInFullOrEmpty(item)) {
            return;
        } else {
            if (rear == nItems - 1) {
                rear = -1;
            }
            dequeArray[++rear] = item;
        }
        nItems++;
    }

    public void insertLeft(long item) {
        if (!insertInFullOrEmpty(item)) {
            return;
        } else {
            if (front == 0) {
                front = maxSize;
            }
            dequeArray[--front] = item;
        }
        nItems++;
    }

    private boolean insertInFullOrEmpty(long item) {
        if (isFull()) {
            System.out.println("Error: deque is full");
            return false;
        } else if (isEmpty()) {
            dequeArray[front] = item;
            rear++;
            nItems++;
            return false;
        }
        return true;
    }

    public long removeRight() {
        long returnValue = dequeArray[rear--];
        if (rear == -1) {
            rear = maxSize - 1;
        }
        nItems--;
        return returnValue;
    }

    public long removeLeft() {
        long returnValue = dequeArray[front++];
        nItems--;
        if (front == maxSize) {
            front = 0;
        }
        return returnValue;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public void display() {
        int j = 0;
        for (int i = 0; i < nItems; i++) {
            int index = front + i < maxSize ? front + i : j++;
            System.out.print(dequeArray[index] + " ");
        }
        System.out.println("");
    }

    public void displayArray() {
        for (int i = 0; i < maxSize; i++) {
            System.out.print(dequeArray[i] + " ");
        }
        System.out.println("");
    }
}
