package sorting;

public class ArrayPar {

    private long[] theArray;
    private int nElems;

    public ArrayPar(int max) {
        theArray = new long[max];

        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public int size() {
        return nElems;
    }

    public int partitionIt(int left, int right) {
        int leftPtr = left - 1;
        int rightPtr = right;

        long pivot = theArray[right];

        while (true) {
            while (theArray[++leftPtr] < pivot) {
            }

            while (rightPtr > left && theArray[--rightPtr] > pivot) {
            }

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }

        swap(leftPtr, right);

        return leftPtr;
    }

    private void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

    public void median() {

        int middleIndex = theArray.length / 2;

        long median;
        if (nElems % 2 == 0) {

            long medianA = calculateMedian(middleIndex - 1, 0, size() - 1);
            long medianB = calculateMedian(middleIndex, 0, size() - 1);

            median = (medianA + medianB) / 2;
        } else {
            median = calculateMedian(middleIndex, 0, size() - 1);
        }

        System.out.println("Median is: " + median);
    }

    private long calculateMedian(int middleIndex, int left, int right) {

        int pivot = partitionIt(left, right);

        if (pivot == middleIndex) {

            return theArray[pivot];
        }

        if (pivot < middleIndex) {
            return calculateMedian(middleIndex, pivot + 1, right);
        } else {
            return calculateMedian(middleIndex, left, pivot - 1);
        }
    }

    public void display() {

        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }

        System.out.println("");
    }
}
