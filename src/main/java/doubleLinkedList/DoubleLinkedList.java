package doubleLinkedList;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void insertFirst(long value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            this.tail = newNode;
        } else {
            this.head.previous = newNode;
            newNode.next = this.head;
        }

        this.head = newNode;

        length++;
    }

    public void insertLast(long value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.previous = this.tail;
        }

        this.tail = newNode;

        length++;
    }

    public void insertAfter(int index, long value) {

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Optional<Node> currentNodeOptional = findByIndex(index);

        if (currentNodeOptional.isEmpty()) {
            System.out.println("Enter correct index");
            return;
        }

        Node currentNode = currentNodeOptional.get();
        Node newNode = new Node(value);

        if (Objects.isNull(currentNode.next)) {
            currentNode.next = newNode;
            newNode.previous = currentNode;
            this.tail = newNode;
        } else {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            newNode.next.previous = newNode;
            newNode.previous = currentNode;
        }

        length++;
    }

    public void deleteFirst() {

        if (isEmpty()) {
            System.out.println("No elements to delete");
            return;
        } else if (length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node secondNode = this.head.next;

            secondNode.previous = null;
            this.head = secondNode;
        }

        length--;
    }

    public void deleteLast() {

        if (isEmpty()) {
            System.out.println("No elements to delete");
            return;
        } else if (length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node previousBeforeLastNode = this.tail.previous;

            this.tail.previous = null;
            previousBeforeLastNode.next = null;
            this.tail = previousBeforeLastNode;
        }

        length--;
    }

    public void deleteByIndex(int index) {

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Optional<Node> optionalDeletedNode = findByIndex(index);

        if (optionalDeletedNode.isEmpty()) {
            System.out.println("Enter correct index");
            return;
        }

        if (index == 0) {
            deleteFirst();
        } else if (index == (length - 1)) {
            deleteLast();
        } else {

            Node currentNode = optionalDeletedNode.get();

            Node previousNode = currentNode.previous;
            Node nextNode = currentNode.next;

            currentNode.next = null;
            currentNode.previous = null;

            previousNode.next = nextNode;
            nextNode.previous = previousNode;

            length--;
        }
    }

    public void displayForward() {

        System.out.println("List (first --> last)");

        Iterator iterator = getIterator();

        for (int i = 0; i < length; i++) {
            System.out.print(iterator.next() + " --> ");
        }

        System.out.println();
    }

    public void displayBackward() {

        Node[] array = new Node[length];
        int index = 0;

        Node currentNode = tail;

        while (Objects.nonNull(currentNode)) {
            array[index++] = currentNode;
            currentNode = currentNode.previous;
        }

        System.out.println(Arrays.toString(array));
    }

    public long size() {

        return length;
    }

    public void clear() {
        Node current;

        Iterator iterator = getIterator();

        for (int i = 0; i < length; i++) {
            current = iterator.getCurrent();
            iterator.next();
            current.previous = null;
            current.next = null;
            current = null;
        }

        head = null;
        tail = null;
        length = 0;

        System.gc();
    }

    public void deleteKey(int value) {

        int index = getIndexByValue(value);

        if (index == -1) {
            System.out.println("No such value");
            return;
        }

        deleteByIndex(index);
    }

    public void insertAfterKey(int keyValue, int newValue) {

        int index = getIndexByValue(keyValue);

        if (index == -1) {
            System.out.println("No such value");
            return;
        }

        insertAfter(index, newValue);
    }

    public Iterator getIterator() {
        return new Iterator();
    }

    private Optional<Node> findByIndex(int index) {

        if (isEmpty()) {
            return Optional.empty();
        }

        if (index > (length - 1)) {
            return Optional.empty();
        }

        if (index == 0) {
            return Optional.ofNullable(head);
        }

        if (index == (length - 1)) {
            return Optional.ofNullable(tail);
        }

        Node foundNode = head;

        if (index < (length / 2)) {

            for (int i = 0; i < index; i++) {
                foundNode = foundNode.next;
            }
        } else {
            foundNode = tail;

            for (int i = (length - 1); i > index; i--) {
                foundNode = foundNode.previous;
            }
        }

        return Optional.ofNullable(foundNode);
    }

    private int getIndexByValue(long value) {
        int index = 0;

        Iterator iterator = getIterator();

        while (iterator.next().value != value) {
            index++;

            if (index >= length) {
                return -1;
            }
        }

        return index;
    }

    public long getHeadValue() {
        return Objects.isNull(head.value) ? null : head.value;
    }

    public long getTailValue() {
        return Objects.isNull(tail.value) ? null : tail.value;
    }

    private class Iterator {
        private Node previous;
        private Node current;

        public Iterator() {
            this.previous = Objects.isNull(head) ? null : head.previous;
            this.current = head;
        }

        public Node next() {
            Node nodeToReturn = this.current;

            if (hasNext()) {
                this.previous = this.current;
                this.current = this.current.next;

            } else {
                this.current = head;
            }

            return nodeToReturn;
        }

        public Node getCurrent() {
            return current;
        }

        private boolean hasNext() {
            if (Objects.isNull(this.current)) {
                return Boolean.FALSE;
            }

            return Objects.nonNull(this.current.next);
        }

        private void reset() {
            this.current = head;
            this.previous = head.previous;
        }
    }
}
