package recursion;

import java.util.Arrays;
import java.util.stream.Stream;

public class BinaryTree {

    private static String[] line;

    public static void main(String[] args) {

        int lineLength = 16;

        int steps = getNumberOfSteps(lineLength);

        line = new String[lineLength];

        for (int step = 1; step <= steps; step++) {
            initFillArray(line);
            makeBranches(step, 0, lineLength - 1);
            display();
        }
    }

    private static int getNumberOfSteps(int i) {

        return (int) (Math.log(i) / Math.log(2)) + 1;
    }

    private static void makeBranches(int step, int left, int right) {

        int delimiter = getDelimiter(step);

        int requiredLength = line.length / delimiter;
        int length = right - left + 1;

        if (length == requiredLength) {
            int index = left + ((right - left) / 2);
            line[index] = "X";

            return;
        }

        makeBranches(step, left, (right - left) / 2 + left);
        makeBranches(step, (right - left) / 2 + left + 1, right);
    }

    private static int getDelimiter(int step) {

        int count = 1;

        for (int i = 1; i < step; i++) {
            count *= 2;
        }

        return count;
    }

    private static void initFillArray(String[] line) {
        Arrays.fill(line, "_");
    }

    private static void display() {

        Stream.of(line).forEach(System.out::print);
        System.out.println();
    }

    private static boolean isPowOf2(int number) {

        if (number < 2 || ((number % 2) != 0)) {
            return false;
        }

        if (number / 2 == 1) {
            return true;
        }

        return isPowOf2(number / 2);
    }
}
