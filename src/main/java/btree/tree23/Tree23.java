package btree.tree23;


public class Tree23 {

    private Node root = new Node();


    public int find(long key) {
        Node current = root;

        int childNumber;

        while (true) {

            childNumber = current.findItem(key);

            if (childNumber != -1) {
                return childNumber;
            } else if (current.isLeaf()) {
                return -1;
            } else {
                current = getNextChild(current, key);
            }
        }
    }

    public void insert(long value) {
        Node current = root;
        DataItem item = new DataItem(value);

        while (true) {

            if (current.isLeaf()) {
                break;
            } else {
                current = getNextChild(current, value);
            }
        }

        if (current.isFull()) {
            split(current, item);
        } else {
            current.insertItem(item);
        }
    }

    public Node split(Node fullNode, DataItem newItem) {

        DataItem itemA, itemB;

        Node parent, child2, child3;

        itemB = fullNode.removeItem();
        itemA = fullNode.removeItem();

        DataItem[] sortedItems = sort(new DataItem[]{itemA, itemB, newItem});

        fullNode.insertItem(sortedItems[0]);

        Node newRightNode = new Node();
        newRightNode.insertItem(sortedItems[2]);

        if (fullNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, fullNode);
            root.connectChild(1, newRightNode);
        } else {
            parent = fullNode.getParent();
        }

        if (parent.isFull()) {

            if (fullNode == parent.getChild(0)) {
                child2 = parent.disconnectChild(1);
                child3 = parent.disconnectChild(2);

                parent.connectChild(1, newRightNode);

                Node parentNewRightNode = split(parent, sortedItems[1]);

                parentNewRightNode.connectChild(0, child2);
                parentNewRightNode.connectChild(1, child3);
            } else if (fullNode == parent.getChild(1)) {
                child3 = parent.disconnectChild(2);

                parent.connectChild(1, fullNode);

                Node parentNewRightNode = split(parent, sortedItems[1]);

                parentNewRightNode.connectChild(0, newRightNode);
                parentNewRightNode.connectChild(1, child3);
            } else {
                parent.disconnectChild(2);

                Node parentNewRightNode = split(parent, sortedItems[1]);

                parentNewRightNode.connectChild(0, fullNode);
                parentNewRightNode.connectChild(1, newRightNode);
            }
        } else {
            parent.insertItem(sortedItems[1]);

            if (fullNode == parent.getChild(0)) {
                child2 = parent.disconnectChild(1);
                parent.connectChild(1, newRightNode);
                parent.connectChild(parent.getNumItems(), child2);
            } else if (fullNode == parent.getChild(1)) {

                parent.connectChild(2, newRightNode);
            }
        }

        return newRightNode;
    }

    private DataItem[] sort(DataItem[] items) {

        for (int i = 0; i < items.length; i++) {
            for (int j = items.length - 1; j > 0; j--) {
                if (items[j].data < items[j - 1].data) {
                    DataItem temp = items[j];
                    items[j] = items[j - 1];
                    items[j - 1] = temp;
                }
            }
        }

        return items;
    }

    public void display() {
        recDisplayTree(root, 0, 0);
    }

    public void traverse() {
        inOrder(root);
    }

    private Node getNextChild(Node node, long value) {

        int i;
        int numItems = node.getNumItems();

        Node newNode = new Node();

        for (i = 0; i < numItems; i++) {
            if (value < node.getItem(i).data) {

                if (node.getChild(i) == null) {
                    node.connectChild(i, newNode);
                }

                return node.getChild(i);
            }
        }

        if (node.getChild(i) == null) {
            node.connectChild(i, newNode);
        }

        return node.getChild(i);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber) {

        System.out.print("Level: " + level + ", Child: " + childNumber + " ");
        thisNode.display();

        int numItems = thisNode.getNumItems();

        for (int i = 0; i < numItems + 1; i++) {
            Node nextNode = thisNode.getChild(i);

            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, i);
            } else {
                return;
            }
        }
    }

    private void inOrder(Node localRoot) {

        if (localRoot != null) {
            for (int i = 0; i <= localRoot.getNumItems(); i++) {

                inOrder(localRoot.getChild(i));

                if (!localRoot.isLeaf() && i != localRoot.getNumItems()) {
                    System.out.print(localRoot.getItem(i).data + " ");
                }
            }

            if (localRoot.isLeaf()) {

                for (int i = 0; i < localRoot.getNumItems(); i++) {
                    System.out.print(localRoot.getItem(i).data + " ");
                }
            }
        }
    }
}
