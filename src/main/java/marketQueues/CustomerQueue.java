package marketQueues;

public class CustomerQueue {
    private int maxSize;
    private Customer[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public CustomerQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queArray = new Customer[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public int getNItems() {
        return nItems;
    }

    public void insert(Customer j) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public Customer remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return new Customer(0);
        }
        Customer temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public Customer peekFront() {
        return queArray[front];
    }

    public Customer peekRear() {
        return queArray[rear];
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

    public void display() {
        int j = 0;
        for (int i = 0; i < nItems; i++) {
            int index = front + i < maxSize ? front + i : j++;
            System.out.print(queArray[index] + " ");
        }
        System.out.println("");
    }

}


