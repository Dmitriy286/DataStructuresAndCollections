package btree.tree23;


public class Node {

    private static final int ORDER = 3;
    private int numItems;
    private Node parent;
    private Node[] children = new Node[ORDER];
    private DataItem[] items = new DataItem[ORDER - 1];

    public void connectChild(int childNum, Node child) {
        children[childNum] = child;

        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum) {
        Node child = children[childNum];

        children[childNum] = null;

        return child;
    }

    public Node getChild(int childNum) {
        return children[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return children[0] == null;
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int itemNum) {
        return items[itemNum];
    }

    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    public int findItem(long key) {
        for (int i = 0; i < ORDER - 1; i++) {

            if (items[i] == null) {
                break;
            } else if (items[i].data == key) {
                return i;
            }
        }
        return -1;
    }

    public int insertItem(DataItem newItem) {
        numItems++;
        long newKey = newItem.data;

        for (int i = ORDER - 2; i >= 0; i--) {
            if (items[i] == null) {
                continue;
            } else {
                long itsKey = items[i].data;

                if (newKey < itsKey) {
                    items[i + 1] = items[i];
                } else {
                    items[i + 1] = newItem;

                    return i + 1;
                }
            }
        }

        items[0] = newItem;

        return 0;
    }

    public DataItem removeItem() {
        DataItem deletedItem = items[numItems - 1];

        items[numItems - 1] = null;
        numItems--;

        return deletedItem;
    }

    public void display() {

        for (int i = 0; i < numItems; i++) {
            items[i].displayItem();
        }

        System.out.println("/");
    }
}
