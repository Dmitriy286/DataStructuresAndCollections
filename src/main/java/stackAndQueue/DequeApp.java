package stackAndQueue;

public class DequeApp {
    public static void main(String[] args) {
        Deque deque = new Deque(6);

        deque.insertRight(10);
        System.out.println("After inserting 1 element:");
        deque.display();
        deque.insertLeft(20);

        System.out.println("After inserting 2 element at right:");
        deque.display();

        deque.insertRight(30);
        System.out.println("After inserting 3 element at left:");
        deque.display();

        deque.insertRight(40);
        deque.insertRight(50);

        deque.insertLeft(60);

        System.out.println("After inserting 6 elements:");
        deque.display();

        deque.insertRight(70);
        deque.insertLeft(80);

        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());

        System.out.println("After deleting 2 elements:");
        deque.display();

        deque.insertLeft(90);
        deque.insertLeft(100);

        System.out.println("After inserting 2 elements, cycle move:");
        deque.display();
        System.out.println("Array:");
        deque.displayArray();

        System.out.println(deque.removeLeft());

        deque.insertRight(110);
        deque.insertRight(120);
        deque.display();
        System.out.println("Array:");
        deque.displayArray();

        while (!deque.isEmpty()) {
            System.out.print(deque.removeLeft());
            System.out.print(" ");
        }
        System.out.println("");
    }
}
