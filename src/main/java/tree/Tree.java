package tree;

public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    public Node find(int key, Node parent, boolean isLeftChild) {

        Node current = root;

        while (current.iData != key) {

            parent = current;

            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }

        return current;
    }

    public void insert(int id, double dd) {

        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;

                if (id < current.iData) {
                    current = current.leftChild;

                    if (current == null) {
                        parent.leftChild = newNode;

                        return;
                    }
                } else {
                    current = current.rightChild;

                    if (current == null) {
                        parent.rightChild = newNode;

                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {

        Node parent = root;
        boolean isLeftChild = true;
        Node current = find(key, parent, isLeftChild);

        if (current == null) {
            return false;
        }

        if (current.leftChild == null && current.rightChild == null) {

            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {

            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {

            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {

            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
        }

        return true;
    }

    private Node getSuccessor(Node deletedNode) {

        Node successorParent = deletedNode;
        Node successor = deletedNode;
        Node current = deletedNode.rightChild;



    }


}
