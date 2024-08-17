package linkedList;

public class LinkedListQueueApp {
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.insert(20);
        queue.insert(40);

        queue.display();

        queue.insert(60);
        queue.insert(80);

        queue.display();

        queue.remove();
        queue.remove();

        queue.display();
    }

}
