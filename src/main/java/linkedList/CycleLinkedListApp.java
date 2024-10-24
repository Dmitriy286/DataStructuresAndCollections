package linkedList;

public class CycleLinkedListApp {
    public static void main(String[] args) throws InterruptedException {
        CycleLinkedList cycleLinkedList = new CycleLinkedList();

        cycleLinkedList.insert(1);
        cycleLinkedList.display();

        cycleLinkedList.insert(2);
        cycleLinkedList.display();

        cycleLinkedList.insert(3);
        cycleLinkedList.display();

        cycleLinkedList.insert(4);

        cycleLinkedList.display();

        System.out.println("found: " + cycleLinkedList.find(2));

        cycleLinkedList.delete();
        cycleLinkedList.display();

        cycleLinkedList.delete();
        cycleLinkedList.display();

        cycleLinkedList.delete();
        cycleLinkedList.display();
    }
}
