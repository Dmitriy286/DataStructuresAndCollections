package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleApp {

    static int theNumber;

    public static void main(String[] args) throws IOException {

        System.out.println("Enter a number: ");

        theNumber = getInt();

        int theAnswer = triangle(theNumber);

        System.out.println("Triangle = " + theAnswer);
    }

    public static int triangle(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (n + triangle(n - 1));
        }
    }

    public static String getString() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String input = bufferedReader.readLine();

        return input;
    }

    private static int getInt() throws IOException {

        String input = getString();

        return Integer.parseInt(input);
    }
}
