package tree.haffman;


public class Decode {

    Tree tree;

    String decodedMessage = "";

    public Decode(Tree tree) {
        this.tree = tree;
    }

    public String decodeByteString(String input) {

        for (int i = 0; i < input.length(); ) {

            Node current = tree.getRoot();

            while (true) {
                if (current.leftChild == null && current.rightChild == null) {

                    if (current.literal == 's') {
                        decodedMessage += ' ';
                    } else if (current.literal == 'n') {
                        decodedMessage += '\n';
                    } else {
                        decodedMessage += current.literal;
                    }

                    break;
                }

                if (input.charAt(i) == '0') {
                    current = current.leftChild;
                } else if (input.charAt(i) == '1') {
                    current = current.rightChild;
                }

                i++;
            }
        }

        return decodedMessage;
    }


}
