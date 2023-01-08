package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostfixCalcApp {
    public static void main(String[] args) throws IOException {
        String input;
        int output;

        while (true) {
            System.out.print("Enter postfix ex:");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            ParsePost parsePost = new ParsePost(input);
            output = parsePost.doParse();
            System.out.println("Evaluates to " + output);
        }
    }

    private static String getString() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader breader = new BufferedReader(reader);
        String s = breader.readLine();
        return s;
    }
}
