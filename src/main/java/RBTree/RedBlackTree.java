package RBTree;

import java.util.Stack;

public class RedBlackTree {

    private Node root;

    public RedBlackTree() {
        root = null;
    }

    public Node find(int key) {

        Node current = root;

        while (current.iData != key) {

            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }

        return current;
    }

    public void insert(int iData) {

        System.out.println("Inserting: " + iData);

        Node newNode = new Node(iData);

        if (root == null) {
            root = newNode;
            changeColor(root);
        } else {
            Node current = root;
            Node parent = root;
            Node ancestor = root;
            Node grandAncestor = root;

            boolean isCurrentLeft = true;
            boolean isParentLeft = true;
            boolean isAncestorLeft = true;

            while (true) {

                boolean isExternalGrandson = true;

                if ((isParentLeft && isCurrentLeft) || (!isParentLeft && !isCurrentLeft)) {
                    isExternalGrandson = true;
                } else if ((isParentLeft && !isCurrentLeft) || (!isParentLeft && isCurrentLeft)) {
                    isExternalGrandson = false;
                } else {
                    System.out.println("Unable to define isExternalGrandson");
                }

                if (current.isRed == false && current.leftChild != null && current.rightChild != null &&
                        current.leftChild.isRed == true && current.rightChild.isRed == true) {
                    switchColors(current);
                }

                if (parent != root) {
                    if (checkRuleThree(parent, current) == false) {
                        rotateTree(grandAncestor, ancestor, parent, current, isAncestorLeft, isExternalGrandson);
                    }
                }

                grandAncestor = ancestor;
                ancestor = parent;
                parent = current;

                isAncestorLeft = isParentLeft;
                isParentLeft = isCurrentLeft;

                if (iData < current.iData) {

                    isCurrentLeft = true;

                    if (current.leftChild == null) {

                        current.leftChild = newNode;

                        current = current.leftChild;

                        if (checkRuleThree(parent, current) == false) {
                            rotateTree(grandAncestor, parent, current, current, isAncestorLeft, true);
                        }

                        return;

                    } else {
                        current = current.leftChild;
                    }

                } else {
                    isCurrentLeft = false;

                    if (current.rightChild == null) {
                        current.rightChild = newNode;

                        current = current.rightChild;

                        if (checkRuleThree(parent, current) == false) {
                            rotateTree(grandAncestor, parent, current, current, isAncestorLeft, false);
                        }

                        return;

                    } else {
                        current = current.rightChild;
                    }
                }
            }
        }
    }

    private void rotateTree(Node grandAncestor, Node ancestor, Node parent, Node current, boolean isAncestorLeft, boolean isExternalGrandson) {

//  переключить цвет предка (дедушки) ТУ (текущего узла)
        changeColor(ancestor);

// если внешний внук
        if (isExternalGrandson) {
//  переключить цвет родителя ТУ
            changeColor(parent);

//  правый поворот, верхний узел - предок ТУ:
            if (currentIsLeftGrandSon(parent, current)) {
                rotateRight(grandAncestor, ancestor, parent, current, isAncestorLeft);
            } else {
                rotateLeft(grandAncestor, ancestor, parent, current, isAncestorLeft);
            }

// если внутренний внук
        } else {
//  переключить цвет ТУ
            changeColor(current);

            if (!currentIsLeftGrandSon(parent, current)) {
//  левый поворот, верхний узел - родитель ТУ:
                smallRotateLeft(ancestor, parent, current);

                current = parent;
                parent = ancestor.leftChild;

//  правый поворот
                rotateRight(grandAncestor, ancestor, parent, current, isAncestorLeft);

            } else {

                smallRotateRight(ancestor, parent, current);

                current = parent;
                parent = ancestor.rightChild;

                rotateLeft(grandAncestor, ancestor, parent, current, isAncestorLeft);
            }
        }
    }

    /**
     * Условно названные малый левый и правый поворот выполняются перед обычными поворотами в случае, если внук является внутренним
     */
    private void smallRotateLeft(Node ancestor, Node parent, Node current) {

//  левый потомок ТУ становится правым потомком бывшего родителя ТУ
        parent.rightChild = current.leftChild;

//  ТУ становится родителем родителя ТУ, ссылка от бывшего родителя ТУ к ТУ удаляется
        current.leftChild = parent;

//  предок ТУ становится родителем ТУ
        ancestor.leftChild = current;
    }

    private void smallRotateRight(Node ancestor, Node parent, Node current) {

//  правый потомок ТУ становится левым потомком бывшего родителя ТУ
        parent.leftChild = current.rightChild;

//  ТУ становится родителем родителя ТУ, ссылка от бывшего родителя ТУ к ТУ удаляется
        current.rightChild = parent;

//  предок ТУ становится родителем ТУ
        ancestor.rightChild = current;
    }

    private void rotateRight(Node grandAncestor, Node ancestor, Node parent, Node current, boolean isAncestorLeft) {

//  родитель ТУ становится родителем предка ТУ (предок ТУ - правый потомок)
        Node temp = parent.rightChild;

        parent.rightChild = ancestor;

//  удалить ссылку от предка к родителю (новый левый потомок)
//  правый потомок родителя ТУ становится левым потомком предка
        ancestor.leftChild = temp;

//  родитель предка становится родителем родителя ТУ
        if (grandAncestor != null && grandAncestor != current && grandAncestor != parent && grandAncestor != ancestor) {
            if (isAncestorLeft) {
                grandAncestor.leftChild = parent;
            } else {
                grandAncestor.rightChild = parent;
            }
        }

        if (ancestor == root) {
            root = parent;
        }
    }

    private void rotateLeft(Node grandAncestor, Node ancestor, Node parent, Node current, boolean isAncestorLeft) {

//  родитель ТУ становится родителем предка ТУ (предок ТУ - левый потомок)
        Node temp = parent.leftChild;

        parent.leftChild = ancestor;

//  удалить ссылку от предка к родителю (новый правый потомок)
//  левый потомок родителя ТУ становится правым потомком предка
        ancestor.rightChild = temp;

//  родитель предка становится родителем родителя ТУ
        if (grandAncestor != null && grandAncestor != current && grandAncestor != parent && grandAncestor != ancestor) {

            if (isAncestorLeft) {
                grandAncestor.leftChild = parent;
            } else {
                grandAncestor.rightChild = parent;
            }
        }

        if (ancestor == root) {
            root = parent;
        }
    }

    private boolean currentIsLeftGrandSon(Node parent, Node current) {

        return parent.leftChild == current;
    }

    private boolean checkRuleThree(Node parent, Node current) {

        return (!parent.isRed || !current.isRed) || (parent == current);
    }

    private void switchColors(Node current) {
        if (current != root) {
            current.isRed = true;
        }

        changeColor(current.leftChild);
        changeColor(current.rightChild);
    }

    private void changeColor(Node node) {
        node.isRed = !node.isRed;
    }

    public void checkBlackHeight() {

        int leftBlackHeight = calculateBlackHeight(root.leftChild);
        int rightBlackHeight = calculateBlackHeight(root.rightChild);

        boolean isOK = leftBlackHeight == rightBlackHeight;

        System.out.println("BLACK HEIGHT IS OK: " + isOK);
        System.out.println("LEFT BLACK HEIGHT: " + leftBlackHeight);
        System.out.println("RIGHT BLACK HEIGHT: " + rightBlackHeight);
    }

    private int calculateBlackHeight(Node node) {

        if (node == null) {
            return 0;
        }

        int count = node.isRed ? 0 : 1;

        if (calculateBlackHeight(node.leftChild) > calculateBlackHeight(node.rightChild)) {
            return count + calculateBlackHeight(node.leftChild);
        } else {
            return count + calculateBlackHeight(node.rightChild);
        }
    }

    public void traverse(int traverseType) {

        switch (traverseType) {
            case 1:
                System.out.println("Preorder traversal:");
                preOrder(root);
                break;
            case 2:
                System.out.println("Inorder traversal:");
                inOrder(root);
                break;
            case 3:
                System.out.println("Postorder traversal:");
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

        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {

        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void display() {
        Stack globalStack = new Stack();
        globalStack.push(root);

        int treeSize = countTreeSize(root);

        int nBlanks = 1;
//        int nBlanks = 32;

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
                    temp.displayNode();

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

                for (int i = 0; i < nBlanks; i++) {
                    System.out.print("  ");
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

    private int countTreeSize(Node rootNode) {

        if (rootNode != null) {

            int leftSize = countTreeSize(rootNode.leftChild);
            int rightSize = countTreeSize(rootNode.rightChild);

            return 1 + leftSize + rightSize;
        }

        return 0;
    }
}
