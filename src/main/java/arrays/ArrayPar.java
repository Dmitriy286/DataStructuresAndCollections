package arrays;

public class ArrayPar {

    private long[] theArray;
    private int nElems;

    public ArrayPar(int max) {
        theArray = new long[max];

        nElems= 0;
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

        System.out.print("Pivot is " + pivot);


        while (true) {
            while (theArray[++leftPtr] < pivot) {}

            while (rightPtr > left && theArray[--rightPtr] > pivot) {}

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

    public void display() {

        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }

        System.out.println("");
    }
}
