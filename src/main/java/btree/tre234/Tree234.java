package btree.tre234;

import java.util.Arrays;

public class Tree234 {

    private Node root = new Node();

    private long[] arr;


    public int find(long key) {
        Node current = root;

        int childNumber;

        while (true) {

            childNumber = current.findItem(key);

            if (childNumber != -1) {
                return childNumber;
            } else if (current.isLeaf()) {
                return -1;
            } else {
                current = getNextChild(current, key);
            }
        }
    }

    public void insert(long value) {
        Node current = root;
        DataItem item = new DataItem(value);

        while (true) {

            if (current.isFull()) {
                split(current);
                current = current.getParent();

                current = getNextChild(current, value);
            } else if (current.isLeaf()) {
                break;
            } else {
                current = getNextChild(current, value);
            }
        }

        current.insertItem(item);
    }

    public void split(Node thisNode) {
        DataItem itemB, itemC;

        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();

        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);

        Node newRight = new Node();

        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }

        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int i = n - 1; i > itemIndex; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i + 1, temp);
        }

        parent.connectChild(itemIndex + 1, newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    public long findMin() {

        Node current = root;

        while (true) {
            if (current.isLeaf()) {
                System.out.println("Min value: " + current.getItem(0).data);

                return current.getItem(0).data;
            }

            current = getNextChild(current, 0);
        }
    }

    public long[] sort(long[] array) {

        Arrays.stream(array).forEach(this::insert);

        long[] sortedArray = new long[array.length];
        arr = new long[array.length];
        traverseSort(root, sortedArray);

        System.out.println();

        return arr;
    }

    public void traverse() {
       inOrder(root);
    }

    public int size() {

        return countItems(root);
    }

    private int countItems(Node localRoot) {
        if (localRoot.isLeaf()) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i <= localRoot.getNumItems(); i++) {
                count += countItems(localRoot.getChild(0));
            }

            return count + 1;
        }
    }

    private void traverseSort(Node localRoot, long[] sortedArray) {

        if (localRoot != null) {
            for (int i = 0; i <= localRoot.getNumItems(); i++) {

                traverseSort(localRoot.getChild(i), sortedArray);

                if (!localRoot.isLeaf() && i != localRoot.getNumItems()) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == 0) {
                            arr[j] = localRoot.getItem(i).data;
                            System.out.print(localRoot.getItem(i).data + " ");
                            break;
                        }
                    }
                }
            }

            if (localRoot.isLeaf()) {

                for (int i = 0; i < localRoot.getNumItems(); i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == 0) {
                            arr[j] = localRoot.getItem(i).data;
                            System.out.print(localRoot.getItem(i).data + " ");
                            break;
                        }
                    }
                }
            }
        }
    }

    private void inOrder(Node localRoot) {

        if (localRoot != null) {
            for (int i = 0; i <= localRoot.getNumItems(); i++) {

                inOrder(localRoot.getChild(i));

                if (!localRoot.isLeaf() && i != localRoot.getNumItems()) {
                    System.out.print(localRoot.getItem(i).data + " ");
                }
            }

            if (localRoot.isLeaf()) {

                for (int i = 0; i < localRoot.getNumItems(); i++) {
                    System.out.print(localRoot.getItem(i).data + " ");
                }
            }
        }
    }

    private Node getNextChild(Node node, long value) {
        int i;

        int numItems = node.getNumItems();

        for (i = 0; i < numItems; i++) {
            if (value < node.getItem(i).data) {
                return node.getChild(i);
            }
        }

        return node.getChild(i);
    }

    public void display() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.print("Level: " + level + ", Child: " + childNumber + " ");
        thisNode.display();

        int numItems = thisNode.getNumItems();

        for (int i = 0; i < numItems + 1; i++) {
            Node nextNode = thisNode.getChild(i);

            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, i);
            } else {
                return;
            }
        }
    }
}
