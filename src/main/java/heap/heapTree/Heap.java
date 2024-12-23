package heap.heapTree;

public class Heap {

    private Tree tree;
    private int maxSize;
    private int currentSize;

    public Heap(int mx) {
        this.maxSize = mx;
        this.currentSize = 0;
        this.tree = new Tree();
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {

        if (currentSize == maxSize) {
            return false;
        }

        Node insertedNode = tree.insert(key, key);

        trickleUp(insertedNode);

        currentSize++;

        return true;
    }

    public Node remove() {
        Node maxNode = tree.remove();

        if (maxNode == null) {
            System.out.println("Heap is empty");
        }

        trickleDown(tree.getRoot());

        return maxNode;
    }

    private void trickleUp(Node node) {

        int bottomData = node.iData;

        Node parent = node.parent;

        Node bottom = node;

        while (node != tree.getRoot() && parent != null && parent.iData < bottomData) {

            bottom.iData = parent.iData;
            bottom = parent;
            parent = bottom.parent;
        }

        bottom.iData = bottomData;
    }

    private void trickleDown(Node localRoot) {

        Node largerChild = null;
        int topData = localRoot.iData;
        Node top = localRoot;

        while (top.leftChild != null || top.rightChild != null) {

            if (top.rightChild == null) {
                largerChild = top.leftChild;
            } else if (top.leftChild == null){
                largerChild = top.rightChild;
            } else if (top.rightChild != null && top.leftChild != null && top.leftChild.iData < top.rightChild.iData) {
                largerChild = top.rightChild;
            } else {
                largerChild = top.leftChild;
            }

            if (topData >= largerChild.iData) {
                break;
            }

            top.iData = largerChild.iData;
            top = largerChild;
        }

        if (largerChild == null) {
            return;
        }

        largerChild.iData = topData;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }

        Node nodeByIndex = tree.findNodeByIndex(index);
        int oldValue = nodeByIndex.iData;

        nodeByIndex.iData = newValue;

        if (oldValue < newValue) {
            trickleUp(nodeByIndex);
        } else {
            trickleDown(nodeByIndex);
        }

        return true;
    }

    public void display() {

        tree.display();
    }
}
