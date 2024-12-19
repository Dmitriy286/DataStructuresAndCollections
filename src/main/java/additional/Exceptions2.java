package additional;

import java.io.IOException;
import java.util.Scanner;

public class Exceptions2 {
    public static void main(String[] args) throws ScannerException {
        try {
            test();
        } catch (IOException | ScannerException e) {
            throw new ScannerException("Not 0");

        }
    }

    public static void test() throws IOException, ScannerException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = Integer.parseInt(scanner.nextLine());
            if (i != 0) {
                throw new ScannerException("Not 0");
            }
            System.out.println("After exception");
        }
    }
}
