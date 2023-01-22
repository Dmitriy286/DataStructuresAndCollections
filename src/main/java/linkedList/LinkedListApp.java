package linkedList;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(22, 2.99);
        linkedList.insertFirst(44, 4.99);
        linkedList.insertFirst(66, 6.99);

        linkedList.insertLast(11, 1.99);
        linkedList.insertLast(33, 3.99);
        linkedList.insertLast(55, 5.99);

        linkedList.displayLinkedList();

        linkedList.deleteFirst();
        linkedList.deleteFirst();

//        Node foundNode = linkedList.find(44);
//        if (foundNode != null) {
//            System.out.println("Found node with value: " + foundNode.getIntData());
//        } else {
//            System.out.println("Can't find node");
//        }
//
//        Node deletedNode = linkedList.delete(66);
//        if (deletedNode != null) {
//            System.out.println("Deleted node with value " + deletedNode.getIntData());
//        } else {
//            System.out.println("Can't find node");
//        }

//        while (!linkedList.isEmpty()) {
//            Node deletedNode = linkedList.deleteFirst();
//            System.out.print("Deleted: " + deletedNode);
//            System.out.println("");
//        }
        linkedList.displayLinkedList();
    }
}
