package tree.haffman;

public class Node {

    public char literal;
    public int frequency;

    public Node leftChild;
    public Node rightChild;

    public Node() {
        frequency = 0;
    }

    public void displayNode() {
        System.out.println("{");
        System.out.println(literal);
        System.out.println(", ");
        System.out.println(frequency);
        System.out.println("} ");
    }

    @Override
    public String toString() {
        return "Node{" +
                "literal=" + literal +
                ", frequency=" + frequency +
                '}';
    }
}
