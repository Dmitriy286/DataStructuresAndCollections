package RBTree;

public class RBApp {

    public static void main(String[] args) {

//        tryWithExternalGrandson();

        tryWithInternalGrandson();
    }

    private static void tryWithExternalGrandson() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(50);
        tree.checkBlackHeight();

        tree.insert(25);
        tree.checkBlackHeight();


        tree.insert(75);
        tree.checkBlackHeight();


        tree.display();

        tree.insert(12);
        tree.checkBlackHeight();

        tree.insert(37);
        tree.checkBlackHeight();

        tree.display();

        tree.insert(6);
        tree.checkBlackHeight();

        tree.display();

        tree.insert(18);
        tree.checkBlackHeight();

        tree.insert(3);
        tree.checkBlackHeight();

        tree.traverse(1);

        tree.display();

        tree.insert(8);
        tree.checkBlackHeight();

        tree.display();

        tree.insert(1);

        tree.display();
        tree.checkBlackHeight();
    }


    private static void tryWithInternalGrandson() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(50);
        tree.checkBlackHeight();

        tree.insert(25);
        tree.checkBlackHeight();

        tree.insert(75);
        tree.checkBlackHeight();

        tree.display();

        tree.insert(12);
        tree.checkBlackHeight();

        tree.insert(37);
        tree.checkBlackHeight();

        tree.display();

        tree.insert(31);
        tree.checkBlackHeight();

        tree.display();

        tree.insert(43);
        tree.checkBlackHeight();

        tree.insert(28);
//        tree.insert(45);

        tree.traverse(1);

        tree.display();
        tree.checkBlackHeight();

        System.out.println("Found: " + tree.find(43).iData);
    }
}
