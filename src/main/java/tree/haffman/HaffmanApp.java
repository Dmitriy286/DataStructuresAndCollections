package tree.haffman;

public class HaffmanApp {

    public static void main(String[] args) {

        String input = "SUSIE SAYS IT IS EASY\nBOB SAYS IT IS HARD";


        Encode encode = new Encode(input);
        Tree tree = encode.getTree();
        String encodedString = encode.encode();

        System.out.println(encodedString);


        Decode decode = new Decode(tree);
        String decodedString = decode.decodeByteString(encodedString);

        System.out.println(decodedString);
    }
}
