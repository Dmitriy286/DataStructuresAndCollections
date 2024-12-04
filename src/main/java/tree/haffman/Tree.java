package tree.haffman;


import java.util.Objects;
import java.util.Stack;

public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    public void display() {
        Stack globalStack = new Stack();
        globalStack.push(root);

        int nBlanks = 16;

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
                    System.out.print(temp.literal + " ");

                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null  && !Objects.equals(temp.leftChild.literal, "*")
                            ||
                        temp.rightChild != null && !Objects.equals(temp.rightChild.literal, "*") ) {

                        isRowEmpty = false;
                    }
                } else {
                    System.out.print(" ");
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
    }
}
