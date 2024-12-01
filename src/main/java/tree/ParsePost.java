package tree;

import java.util.Stack;

public class ParsePost {

    private Stack stack;
    private String input;

    public ParsePost(String input) {
        this.input = input;
    }

    public PostfixTree doParse() {

        stack = new Stack();

        char ch;

        PostfixTree operand1, operand2;

        for (int i = 0; i < input.length(); i++) {

            ch = input.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                PostfixTree tree = new PostfixTree();
                Node node = new Node();
                node.sData = String.valueOf(ch);
                tree.setRoot(node);

                stack.push(tree);

            } else {
                operand2 = (PostfixTree) stack.pop();
                operand1 = (PostfixTree) stack.pop();

                PostfixTree tree = new PostfixTree();
                Node node = new Node();
                node.sData = String.valueOf(ch);
                tree.setRoot(node);

                node.leftChild = operand1.getRoot();
                node.rightChild = operand2.getRoot();

                stack.push(tree);
            }
        }

        return (PostfixTree) stack.pop();
    }
}
