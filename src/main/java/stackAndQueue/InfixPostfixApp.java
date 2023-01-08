package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixPostfixApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            InToPost transformator = new InToPost(input);
            output = transformator.doTransformation();
            System.out.println("Postfix is " + output);
        }
    }

    private static String getString() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader breader = new BufferedReader(reader);
        String s = breader.readLine();
        return s;
    }
}
