package RBTree;

public class Node {

    public int iData;
    public boolean isRed;
    public Node leftChild;
    public Node rightChild;

    public Node(int iData) {
        this.isRed = true;
        this.iData = iData;
    }

    public void displayNode() {

        if (isRed) {
            System.out.print("(" + iData + ")");
        } else {
            System.out.print("[" + iData + "]");
        }
    }
}
