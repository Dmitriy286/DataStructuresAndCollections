package hashtable.treeHashTable;

import java.util.Objects;
import java.util.Stack;

public class Tree {

    private Node root;

    private int size;

    public Tree() {
        root = null;
    }

    public Node find(int key, Node parent, boolean isLeftChild) {

        Node current = root;

        if (current == null) {
            return null;
        }

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

        size++;
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

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != deletedNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = deletedNode.rightChild;
        }

        return successor;
    }

    public void traverse(int traverseType) {

        switch (traverseType) {
            case 1:
                preOrder(root);
                break;
            case 2:
                inOrder(root);
                break;
            case 3:
                postOrder(root);
                break;
        }

        System.out.println();
    }

    private void preOrder(Node localRoot) {

        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        inOrder(localRoot.leftChild);
        System.out.print(localRoot.iData + " ");
        inOrder(localRoot.rightChild);
    }

    private void postOrder(Node localRoot) {
        postOrder(localRoot.leftChild);
        postOrder(localRoot.rightChild);
        System.out.print(localRoot.iData + " ");
    }

    public void display() {
        Stack globalStack = new Stack();
        globalStack.push(root);

        int treeSize = countTreeSize(root);

        int nBlanks = 1;

        while (true) {
            nBlanks = 2 * nBlanks;

            if (nBlanks * 2 > treeSize) {
                nBlanks = nBlanks * 4;
                break;
            }
        }

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
                    System.out.print(temp.sData);

                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null  && !Objects.equals(temp.leftChild.sData, "*")
                            ||
                        temp.rightChild != null && !Objects.equals(temp.rightChild.sData, "*") ) {

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

    public void setRoot(Node root) {
        this.root = root;
        size++;
    }

    public int getSize() {
        return size;
    }

    public int getTreeSize(Node rootNode) {

        return countTreeSize(rootNode);
    }

    private int countTreeSize(Node rootNode) {

        if (rootNode != null && !Objects.equals(rootNode.sData, "*")) {

            int leftSize = countTreeSize(rootNode.leftChild);
            int rightSize = countTreeSize(rootNode.rightChild);

            return 1 + leftSize + rightSize;
        }

        return 0;
    }
}
