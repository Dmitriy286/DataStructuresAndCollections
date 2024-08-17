package linkedList;

public class SortedLinkedListApp {
    public static void main(String[] args) {
        mySortedList();
//        laforesSortedList();

    }

    public static void mySortedList() {
        LinkedList sortedLinkedList = new LinkedList();

        sortedLinkedList.sortingInsert(20);
        sortedLinkedList.sortingInsert(40);

        sortedLinkedList.displayLinkedList();

        sortedLinkedList.sortingInsert(10);
        sortedLinkedList.sortingInsert(30);
        sortedLinkedList.sortingInsert(50);

        sortedLinkedList.displayLinkedList();

        sortedLinkedList.deleteFirst();

        sortedLinkedList.displayLinkedList();
    }

    public static void laforesSortedList() {
        LinkedList sortedLinkedList = new LinkedList();

        sortedLinkedList.sortingInsertFromLafore(20);
        sortedLinkedList.sortingInsertFromLafore(40);

        sortedLinkedList.displayLinkedList();

        sortedLinkedList.sortingInsertFromLafore(10);
        sortedLinkedList.sortingInsertFromLafore(30);
        sortedLinkedList.sortingInsertFromLafore(50);

        sortedLinkedList.displayLinkedList();

        sortedLinkedList.deleteFirst();

        sortedLinkedList.displayLinkedList();

    }
}
