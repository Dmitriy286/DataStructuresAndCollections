package sorting;

public class ArrayIns {

    private long[] theArray;
    private int nElems;

    private int copyQuantity;
    private int comparisonQuantity;
    private int swapQuantity;

    public ArrayIns(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {

        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }

        System.out.println("");
    }

    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    private void recQuickSort(int left, int right){
        int size = right - left + 1;

//        if (size < 10) {
//            insertionSort(left, right);
        if (size <= 3) {
            manualSort(left, right);
        } else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);

            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private long medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (theArray[left] > theArray[center]) {
            swap(left, center);
        }
        comparisonQuantity++;

        if (theArray[left] > theArray[right]) {
            swap(left, right);
        }
        comparisonQuantity++;

        if (theArray[center] > theArray[right]) {
            swap(center, right);
        }
        comparisonQuantity++;

        swap(center, right - 1);


        return theArray[right - 1];
    }

    private void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;

        copyQuantity += 3;
        ++swapQuantity;
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {

            while (theArray[++leftPtr] < pivot) {
                comparisonQuantity++;
            }
            comparisonQuantity++;


            while (theArray[--rightPtr] > pivot) {
                comparisonQuantity++;
            }
            comparisonQuantity++;


            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }

        swap(leftPtr, right - 1);

        return leftPtr;
    }

    public void manualSort(int left, int right) {

        int size = right - left + 1;

        if (size <= 1) {
            return;
        }

        if (size == 2) {
            if (theArray[left] > theArray[right]) {

                swap(left, right);
            }
            comparisonQuantity++;

            return;
        } else {
            if (theArray[left] > theArray[right - 1]) {

                swap(left, right - 1);
            }
            comparisonQuantity++;

            if (theArray[left] > theArray[right]) {

                swap(left, right);
            }
            comparisonQuantity++;

            if (theArray[right - 1] > theArray[right]) {

                swap(right - 1, right);
            }
            comparisonQuantity++;
        }


    }

    public void insertionSort(int left, int right) {

        int in;
        int out;

        for (out = left + 1; out <= right; out++) {

            long temp = theArray[out];
            in = out;

            while (temp <= theArray[in - 1] && in > left) {
                comparisonQuantity++;

                theArray[in] = theArray[in - 1];

                --in;
            }

            comparisonQuantity++;

            theArray[in] = temp;
        }
    }

    public void showStatistics() {
        System.out.println("Copy operations: " + copyQuantity);
        System.out.println("Comparison operations: " + comparisonQuantity);
        System.out.println("Swap operations: " + swapQuantity);
    }

}
