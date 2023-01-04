package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.println("Enter a string:");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            Reverser reverser = new Reverser(input);
            output = reverser.doReverse();
            System.out.println("Reversed: " + output);
        }
    }

    private static String getString() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader breader = new BufferedReader(reader);
        String s = breader.readLine();
        return s;
    }
}
