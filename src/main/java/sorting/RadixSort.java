package sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {

    public static void main(String[] args) {

        int[] numberArray = new int[]{421, 240, 35, 532, 305, 430, 124};

        prepareToSort(numberArray, 10);


        int[] binaryNumberArray = new int[numberArray.length];

        for (int i = 0; i < binaryNumberArray.length; i++) {
            String s = convertToBinary(numberArray[i]);

            int binaryNumber = Integer.parseInt(s);

            binaryNumberArray[i] = binaryNumber;
        }

        for (int i = 0; i < binaryNumberArray.length; i++) {

            System.out.print(numberArray[i] + " --> " + binaryNumberArray[i]);

            System.out.println();
        }

        prepareToSort(binaryNumberArray, 2);



        int[] hexNumberArray = new int[]{0x01A5, 0x00F0, 0x0023, 0x0214, 0x0131, 0x01AE, 0x007C};

        for (int i = 0; i < binaryNumberArray.length; i++) {

            System.out.print(numberArray[i] + " --> " + Integer.toHexString(hexNumberArray[i]));

            System.out.println();
        }

        prepareToSort(hexNumberArray, 16);
    }

    private static void prepareToSort(int[] binaryNumberArray, int numberSystem) {

        List<int[]> charNumberList = new ArrayList<>();

        int maxSize = 0;

        maxSize = calculateDigitArraysAndGetMaxSize(binaryNumberArray, charNumberList, maxSize);

        LinkedList[] sortList = getSortingArray(numberSystem);

        sort(maxSize, charNumberList, sortList);
    }

    private static void sort(int maxSize, List<int[]> charNumberList, LinkedList[] sortList) {

        for (int i = maxSize - 1; i >= 0; i--) {

            for (int j = 0; j < charNumberList.size(); j++) {
                sortByRadix(charNumberList, j, maxSize, i, sortList);
            }


            charNumberList.clear();

            for (int j = 0; j < sortList.length; j++) {

                copySortedDigitsToMainList(charNumberList, sortList[j]);
            }
        }

        charNumberList.forEach(e -> System.out.print(Arrays.toString((int[]) e) + " "));

        System.out.println();
    }

    private static int calculateDigitArraysAndGetMaxSize(int[] numberArray, List<int[]> charNumberList, int maxSize) {
        for (int i = 0; i < numberArray.length; i++) {
            int[] arrayFromNumber = createArrayFromNumber(numberArray[i]);

            charNumberList.add(arrayFromNumber);

            if (arrayFromNumber.length > maxSize) {
                maxSize = arrayFromNumber.length;
            }

        }

        return maxSize;
    }

    private static int[] createArrayFromNumber(Integer digit) {

        String stringNumber = String.valueOf(digit);

        int size = stringNumber.length();


        int[] arrayNumber = new int[size];

        int count = size - 1;

        while (digit > 0) {
            arrayNumber[count--] = digit % 10;

            digit = digit / 10;
        }

        return arrayNumber;
    }

    private static LinkedList[] getSortingArray(int numberSystem) {
        LinkedList[] sortList = new LinkedList[numberSystem];

        for (int i = 0; i < numberSystem; i++) {

            LinkedList linkedList = new LinkedList();

            sortList[i] = linkedList;

        }
        return sortList;
    }

    private static void sortByRadix(List<int[]> charNumberList, int j, int maxSize, int i, LinkedList[] sortList) {

        int[] chars = charNumberList.get(j);

        if (maxSize > chars.length) {
            int additionalSize = maxSize - chars.length;
            int[] extendedChars = new int[maxSize];

            for (int k = additionalSize, l = 0; k < maxSize; k++, l++) {
                extendedChars[k] = chars[l];
            }

            chars = extendedChars;
        }

        int literal;

        try {
            literal = chars[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            literal = 0;
        }

        sortList[literal].add(chars);
    }

    private static void copySortedDigitsToMainList(List<int[]> charNumberList, LinkedList sortList) {
        LinkedList<int[]> numberList = sortList;

        numberList.forEach(number -> charNumberList.add(number));

        numberList.clear();
    }

    private static int[] simpleConvertToBinary(int number) {
        int[] binaryArray = new int[1_000_001];

        int index = 1_000_000;

        for (int i = 0; i < number; i++) {
            if (binaryArray[index] == 0) {
                binaryArray[index] = 1;
            } else {
                binaryArray[index] = 0;

                for (int j = 1_000_000; j >= 0; j--) {
                    if (binaryArray[j - 1] == 0) {
                        binaryArray[j - 1] = 1;
                        break;
                    } else {
                        binaryArray[j - 1] = 0;
                    }
                }
            }
        }

        return binaryArray;
    }

    private static String convertToBinary(int number) {

        String binaryNumber = "";

        int newNumber = number;

        while (newNumber >= 1) {
            int digit = newNumber % 2;

            binaryNumber = digit + binaryNumber;

            newNumber = newNumber / 2;
        }

        return binaryNumber;
    }

    private static int convertToDecimal(int number, int base) {

        int decN = 0;
        int position = 0;

        if (base == 16) {

            String s = Integer.toHexString(number);

            for (int i = s.length() - 1; i >= 0; i--, position++) {
                int value = Integer.parseInt(String.valueOf(s.charAt(i)), 16);
                decN = decN + (value * power(base, position));
            }

            return decN;
        }

        int newNumber = number;

        while (newNumber >= 1) {
            int digit = newNumber % 10;

            decN = decN + (digit * power(base, position));

            newNumber = newNumber / 10;

            position++;
        }

        return decN;
    }

    private static int power(int x, int y) {

        if (y == 0) {
            return 1;
        }

        if (y == 1) {
            return x;
        }

        if (y % 2 != 0) {
            return power(x * x, y /2) * x;
        }

        return power(x * x, y /2);
    }
}
