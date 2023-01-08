package stackAndQueue;

public class PriorityQueueFastInsApp {
    public static void main(String[] args) {
        PriorityQueueFastIns priorityQueueFastIns = new PriorityQueueFastIns(10);

        priorityQueueFastIns.insert(10);
        priorityQueueFastIns.insert(20);
        priorityQueueFastIns.insert(30);
        priorityQueueFastIns.insert(40);
        priorityQueueFastIns.insert(50);
        priorityQueueFastIns.insert(60);

        priorityQueueFastIns.display();

        priorityQueueFastIns.insert(45);

        priorityQueueFastIns.display();

        long remove = priorityQueueFastIns.remove();
        System.out.println(remove);


        priorityQueueFastIns.insert(5);
        priorityQueueFastIns.insert(35);

        priorityQueueFastIns.display();

        long remove1 = priorityQueueFastIns.remove();
        System.out.println(remove1);

        priorityQueueFastIns.display();

        while (!priorityQueueFastIns.isEmpty()) {
            System.out.print(priorityQueueFastIns.remove());
            System.out.print(" ");
        }
        System.out.println();

        priorityQueueFastIns.display();
        priorityQueueFastIns.insert(7);
        priorityQueueFastIns.display();
    }


}
