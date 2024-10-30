package recursion;

public class Calculator {

    public static void main(String[] args) {

//        int result = mult(5, 6);
        int result = power(3, 18);

        System.out.println("Result: " + result);
    }

    private static int mult(int x, int y) {

        if (y == 1) {
            return x;
        } else {
            return x + mult(x, y - 1);
        }
    }

    private static int power(int x, int y) {

        if (y == 1) {
            return x;
        }

        if (y % 2 != 0) {
            return power(x * x, y /2) * x;
        }

        return power(x * x, y /2);
    }
}
