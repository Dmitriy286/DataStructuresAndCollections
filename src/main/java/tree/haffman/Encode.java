package tree.haffman;


public class Encode {

    Tree tree;
    String input;
    Character[] alphabet;
    String[] byteTable;
    Node[] frequencyTable;
    int initialForestSize = 0;

    public Encode(String input) {
        this.input = input;
        this.alphabet = createAlphabetTable();
        this.byteTable = new String[alphabet.length];
        this.tree = createHaffmanTree();
    }

    public Tree getTree() {
        return tree;
    }

    public String encode() {

        String code = "";

        fillByteTable(tree.getRoot(), code);

        String encodedString = translateMessage();

        return encodedString;
    }

    private void fillByteTable(Node root, String code) {

        if (root.leftChild == null && root.rightChild == null) {

            int index = getLiteralCode(root.literal);

            byteTable[index] = code;

            return;
        }

        String leftCode = new String(code);
        leftCode += '0';

        fillByteTable(root.leftChild, leftCode);

        String rightCode = new String(code);
        rightCode += '1';

        fillByteTable(root.rightChild, rightCode);
    }

    private String translateMessage() {
        String encodedString = "";

        for (int i = 0; i < input.length(); i++) {
            char literal = input.charAt(i);

            int literalCode = getLiteralCode(literal);

            for (int j = 0; j < byteTable[literalCode].length(); j++) {
                encodedString += byteTable[literalCode].charAt(j);
            }
        }

        return encodedString;
    }

    private Character[] createAlphabetTable() {
        return new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '\n'};
    }

    private int getLiteralCode(char literal) {

        if (literal == 's') {
            literal = ' ';
        }

        if (literal == 'n') {
            literal = '\n';
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == literal) {
                return i;
            }
        }

        return -1;
    }

    private void calculateLiteralFrequency() {

        frequencyTable = new Node[alphabet.length];

        for (int i = 0; i < input.length(); i++) {
            char literal = input.charAt(i);

            int literalCode = getLiteralCode(literal);

            if (frequencyTable[literalCode] == null) {
                frequencyTable[literalCode] = new Node();

                if (alphabet[literalCode] == ' ') {
                    frequencyTable[literalCode].literal = 's';
                } else if (alphabet[literalCode] == '\n') {
                    frequencyTable[literalCode].literal = 'n';
                } else {
                    frequencyTable[literalCode].literal = literal;
                }

                frequencyTable[literalCode].frequency++;

                initialForestSize++;
            } else {
                frequencyTable[literalCode].frequency++;
            }
        }
    }

    private Tree createHaffmanTree() {
        calculateLiteralFrequency();

        PriorityQueue priorityQueue = new PriorityQueue(initialForestSize);

        for (int i = 0; i < frequencyTable.length; i++) {
            if (frequencyTable[i] != null) {
                Tree tree = new Tree();
                tree.setRoot(frequencyTable[i]);
                priorityQueue.insert(tree);
            }
        }

        while (true) {
            Tree treeOne = priorityQueue.remove();
            Tree treeTwo = priorityQueue.remove();

            Node parentNode = new Node();
            parentNode.literal = '*';
            parentNode.frequency = treeOne.getRoot().frequency + treeTwo.getRoot().frequency;
            parentNode.leftChild = treeOne.getRoot();
            parentNode.rightChild = treeTwo.getRoot();

            Tree parentTree = new Tree();
            parentTree.setRoot(parentNode);

            priorityQueue.insert(parentTree);

            if (priorityQueue.size() == 1) {
                return priorityQueue.remove();
            }
        }
    }
}
