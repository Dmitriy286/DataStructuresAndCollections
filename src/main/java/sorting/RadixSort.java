package sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {

    public static void main(String[] args) {

        //TODO number system

        int numberSystem = 10;

        int[] numberArray = new int[]{421, 240, 35, 532, 305, 430, 124};

        List<int[]> charNumberList = new ArrayList<>();

        int maxSize = 0;

        maxSize = calculateDigitArraysAndGetMaxSize(numberArray, charNumberList, maxSize);

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
}
