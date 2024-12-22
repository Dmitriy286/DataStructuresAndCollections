package heap.binaryTreePriorityQueue;

public class Node {

    public int iData;
    public double dData;
    public String sData = "*";
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.println("{");
        System.out.println(iData);
        System.out.println(", ");
        System.out.println(dData);
        System.out.println("} ");
    }
}
