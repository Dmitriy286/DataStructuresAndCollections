package stackAndQueue;

public class QueueApp {
    public static void main(String[] args) {
        Queue queue = new Queue(7);

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.insert(60);
        System.out.println("Display before cycle move");
        queue.display();
        System.out.println("Front: ");
        System.out.println(queue.peekFront());
        System.out.println("Rear: ");
        System.out.println(queue.peekRear());

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println("Display after removing");
        queue.display();
        System.out.println("Front: ");
        System.out.println(queue.peekFront());
        System.out.println("Rear: ");
        System.out.println(queue.peekRear());


        queue.insert(70);
        queue.insert(80);
        queue.insert(90);
        queue.insert(100);
        queue.insert(110);
        System.out.println("Display after cycle move");
        queue.display();
        System.out.println("Front: ");
        System.out.println(queue.peekFront());
        System.out.println("Rear: ");
        System.out.println(queue.peekRear());

//        while (!queue.isEmpty()) {
//            System.out.print(queue.remove());
//            System.out.print(" ");
//        }
//        System.out.println("");

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println("Display with one element");
        queue.display();
        System.out.println("Front: ");
        System.out.println(queue.peekFront());
        System.out.println("Rear: ");
        System.out.println(queue.peekRear());

        queue.remove();
        System.out.println("Display after removing all");
        queue.display();
        System.out.println("Front: ");
        System.out.println(queue.peekFront());
        System.out.println("Rear: ");
        System.out.println(queue.peekRear());
    }
}
