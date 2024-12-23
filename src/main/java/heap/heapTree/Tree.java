package heap.heapTree;


import java.util.Stack;

public class Tree {

    private Node root;

    private int size;

    public Tree() {
        root = null;
    }


    public Node insert(int id, double dd) {

        Node lastEmptyChild = findLastEmptyChild();

        lastEmptyChild.iData = id;
        lastEmptyChild.dData = dd;

        if (root == null) {
            root = lastEmptyChild;
        }

        size++;

        return lastEmptyChild;
    }

    public Node remove() {

        if (root == null) {

            return null;
        }

        int maxNodeData = root.iData;

        Node lastNode = findLastNode();

        root.iData = lastNode.iData;

        size--;

        return new Node(maxNodeData);
    }

    public Node findNodeByIndex(int index) {

        String path = getPath(index + 1);

        Node currentNode = root;

        for (int i = 1; i < path.length(); i++) {

            if (path.charAt(i) == '0') {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
        }

        return currentNode;
    }

    public void display() {

        Stack globalStack = new Stack();
        globalStack.push(root);

        int nBlanks = 32;

        boolean isRowEmpty = false;
        System.out.println(".....................................................................");

        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();

                if (temp != null) {
                    System.out.print(temp.iData);

                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null
                            ||
                            temp.rightChild != null) {

                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }


                for (int i = 0; i < nBlanks * 2 - 1; i++) {
                    System.out.print(" ");
                }
            }


            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }

        System.out.println(".....................................................................");
    }

    public Node getRoot() {
        return root;
    }

    private Node findNodeByBinaryPath(String path) {

        if (root == null) {
            return new Node();
        }

        Node currentNode = root;

        for (int i = 1; i < path.length(); i++) {

            System.out.println("===== " + path.charAt(i));

            if (path.charAt(i) == '0') {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = new Node();
                }

                currentNode.leftChild.parent = currentNode;
                currentNode = currentNode.leftChild;
            } else {
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = new Node();
                }

                currentNode.rightChild.parent = currentNode;
                currentNode = currentNode.rightChild;
            }
        }

        display();

        return currentNode;
    }

    private Node findLastEmptyChild() {

        String path = getPath(size + 1);

        return findNodeByBinaryPath(path);
    }

    private Node findLastNode() {

        String path = getPath(size);

        Node currentNode = root;
        Node lastNode = root;

        for (int i = 1; i < path.length(); i++) {

            System.out.println("===== " + path.charAt(i));

            if (path.charAt(i) == '0') {
                lastNode = currentNode.leftChild;


                if (i == path.length() - 1) {
                    currentNode.leftChild = null;
                } else {
                    currentNode = currentNode.leftChild;
                }
            } else {
                lastNode = currentNode.rightChild;


                if (i == path.length() - 1) {
                    currentNode.rightChild = null;
                } else {
                    currentNode = currentNode.rightChild;
                }
            }
        }

        return lastNode;
    }

    private String getPath(int size) {

        String path = "";

        while (size >= 1) {
            path = String.valueOf(size % 2) + path;
            size = size / 2;
        }

        System.out.println("path: " + path);

        return path;
    }
}
