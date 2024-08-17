package linkedList;

public class CycleLinkedList {

    private Node current;
    private int length;

    public CycleLinkedList() {

    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void insert(int value) {
        Node newNode = new Node(value, 0);

        if (isEmpty()) {
            this.current = newNode;
            this.current.setNext(newNode);
        } else if (length == 1) {
            this.current.setNext(newNode);
            newNode.setNext(this.current);
            next();
        } else {
            newNode.setNext(current.getNext());
            this.current.setNext(newNode);
            next();
        }

//        System.out.println("current: " + current);

        length++;
    }

    public Node delete() {

        Node deletedNode = current.getNext();

        this.current.setNext(deletedNode.getNext());

        length--;

        return deletedNode;
    }

    public Node find(int value) {

        for (int i = 0; i < length; i++) {
            if (current.getIntData() == value) {
                return current;
            }

            next();
        }

        return null;
    }

    public void next() {
        this.current = current.getNext();
    }


    public void display() {

        for (int i = 0; i < length; i++) {
            System.out.print(current);

            next();
        }

        System.out.println();
    }

    public Node getCurrent() {
        return current;
    }

    public void infiniteDisplay() throws InterruptedException {

        Thread.sleep(1000);

        System.out.println(current);

        next();

        infiniteDisplay();
    }
}
