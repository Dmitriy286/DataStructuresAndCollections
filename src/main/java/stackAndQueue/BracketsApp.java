package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketsApp {
    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.println("Enter string containing delimiters: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            BracketChecker bracketChecker = new BracketChecker(input);
            bracketChecker.check();
        }
    }

    private static String getString() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader breader = new BufferedReader(reader);
        String s = breader.readLine();
        return s;
    }
}
