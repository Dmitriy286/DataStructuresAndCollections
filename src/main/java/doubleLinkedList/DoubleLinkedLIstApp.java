package doubleLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedLIstApp {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        System.out.println(doubleLinkedList.isEmpty());


        doubleLinkedList.insertFirst(22);
        doubleLinkedList.insertFirst(44);
        doubleLinkedList.insertFirst(66);

        doubleLinkedList.insertLast(11);
        doubleLinkedList.insertLast(33);
        doubleLinkedList.insertLast(55);

        doubleLinkedList.displayForward();
        doubleLinkedList.displayBackward();

        doubleLinkedList.deleteFirst();
        doubleLinkedList.deleteLast();
        doubleLinkedList.deleteKey(111);

        doubleLinkedList.displayForward();

        doubleLinkedList.insertAfterKey(11, 77);
        doubleLinkedList.insertAfterKey(33, 88);
        doubleLinkedList.insertAfterKey(33, 99);

        doubleLinkedList.displayForward();

        doubleLinkedList.clear();

//        doubleLinkedList.deleteByIndex(2);
//        System.out.println(doubleLinkedList.size());
//        System.out.println(doubleLinkedList.isEmpty());

        doubleLinkedList.displayForward();
        doubleLinkedList.displayBackward();
        System.out.println(doubleLinkedList.size());
    }
}
