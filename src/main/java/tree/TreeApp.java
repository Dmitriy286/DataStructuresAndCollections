package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TreeApp {

    public static void main(String[] args) throws IOException {

        String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

//        Tree stringDataBalancedTree = createStringDataBalancedTree(letters);
//        stringDataBalancedTree.display();

        Tree fullTree = createFullTree(letters);

        fullTree.display();

    }

    private static Tree createFullTree(String[] letters) {
        Tree tree = new Tree();
        Node node = new Node();
        tree.setRoot(node);

        fillNodeForFullTree(0, node, letters);

        return tree;
    }

    private static void fillNodeForFullTree(int index, Node node, String[] letters) {
        if (index >= letters.length) {
            return;
        }

        node.sData = letters[index];

        node.leftChild = new Node();
        fillNodeForFullTree((index + 1) * 2 - 1, node.leftChild, letters);

        node.rightChild = new Node();
        fillNodeForFullTree((index + 1) * 2, node.rightChild, letters);
    }

    private static Tree createStringDataBalancedTree(String[] letters) {

        List<Tree> forest = new ArrayList<>();

        for (int i = 0; i < letters.length; i++) {

            Tree tree = new Tree();

            Node node = new Node();
            node.sData = letters[i];

            tree.setRoot(node);

            forest.add(tree);
        }

        int forestLength;

        while (true) {

            forestLength = forest.size();

            for (int i = 0; i < forestLength; i+=2) {
                Tree tree = new Tree();

                Node node = new Node();
                node.sData = "+";

                node.leftChild = forest.get(i).getRoot();


                if (forest.size() > 1) {
                    if (i + 1 < forestLength) {
                        node.rightChild = forest.get(i + 1).getRoot();
                    }
                }

                tree.setRoot(node);

                forest.add(tree);
            }

            forest.forEach(Tree::display);

            for (int i = 0; i < forestLength; i++) {
                forest.remove(0);
            }

            if (forest.size() == 1) {
                return forest.get(0);
            }
        }
    }

    private static Tree createStringDataTree(String[] letters) {

        Tree[] forest = new Tree[letters.length];

        for (int i = 0; i < letters.length; i++) {

            Tree tree = new Tree();

            Node node = new Node();
            node.sData = letters[i];

            tree.setRoot(node);

            forest[i] = tree;
        }

        for (int i = 0; i < letters.length - 1; i++) {
            Tree tree = new Tree();

            Node node = new Node();
            node.sData = "+";

            node.leftChild = forest[i].getRoot();
            node.rightChild = forest[i + 1].getRoot();

            tree.setRoot(node);

            forest[i + 1] = tree;
        }

        return forest[forest.length - 1];
    }

    private static Tree createTree() {

        Tree tree = new Tree();

        tree.insert(50, 1.5);
        tree.insert(25, 1.2);
        tree.insert(75, 1.7);
        tree.insert(12, 1.5);
        tree.insert(37, 1.2);
        tree.insert(43, 1.7);
        tree.insert(30, 1.5);
        tree.insert(33, 1.2);
        tree.insert(87, 1.7);
        tree.insert(93, 1.5);
        tree.insert(97, 1.5);

        return tree;
    }

    private static void initInterface(Tree tree) throws IOException {
        int value;

        while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");

            int choice = getChar();

            switch (choice) {
                case 's':
                    tree.display();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();

                    tree.insert(value, value + 0.9);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();

                    Node found = tree.find(value, null, false);

                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    }
            }
        }
    }

    private static int getInt() throws IOException {

        String s = getString();

        return Integer.parseInt(s);
    }

    private static int getChar() throws IOException {

        String s = getString();

        return s.charAt(0);
    }

    private static String getString() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();

        return s;
    }
}
