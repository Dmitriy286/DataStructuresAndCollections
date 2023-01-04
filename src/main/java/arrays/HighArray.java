package arrays;

import java.util.Random;

public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int getNElems() {
        return nElems;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }

        if (j == nElems) {
            return false;
        } else {
            return true;
        }
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void setElementByIndex(int index, long value) {
        a[index] = value;
    }

    public int size() {
        return nElems;
    }

    public void noDups() {
        Random r = new Random();
        Long flag;
        do {
            flag = r.nextLong(1, 1000);
        } while (find(flag));
        System.out.println("flag:");
        System.out.println(flag);
        for (int i = 0; i < this.getNElems(); i++) {
            for (int j = i + 1; j < this.getNElems(); j++) {
                if (a[i] == a[j]) {
                    a[j] = flag;
                }
            }
        }
        deleteByFlag(flag);
    }

    public boolean deleteByFlag(Long flag) {
        for (int i = 0; i < nElems; i++) {
            if (a[i] == flag) {
                for (int k = i; k < nElems - 1; k++) {
                    a[k] = a[k + 1];
                }
                nElems--;
            }
        }
        return true;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (value == a[j])
                break;
        }
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public void bubbleSort() {
        long temp;
//        int cycleCount = 0;
        for (int i = nElems - 1; i > 0; i--) { //i>1 ???
            for (int j = 0; j < i; j++) {
//                cycleCount++;
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
//                    display();
                }
            }
        }
//        System.out.println(cycleCount);
    }

    public void biDirectionalBubbleSort() {
//        int cycleCount = 0;
        boolean direction = true;
        for (int leftBound = 0, rightBound = nElems - 1; leftBound < rightBound; ) {
            if (direction) {
                rightBound--;
            } else {
                leftBound++;
            }
            for (int forwardIndex = leftBound, backwardIndex = rightBound; forwardIndex <= rightBound && backwardIndex >= leftBound; ) {
//                cycleCount++;
                int firstIndex;
                int secondIndex;
                if (direction) {
                    firstIndex = forwardIndex;
                    secondIndex = firstIndex + 1;
                    forwardIndex++;
                } else {
                    firstIndex = backwardIndex - 1;
                    secondIndex = backwardIndex;
                    backwardIndex--;
                }
                if (a[firstIndex] > a[secondIndex]) {
                    long temp = a[firstIndex];
                    a[firstIndex] = a[secondIndex];
                    a[firstIndex + 1] = temp;
                }
//                display();
            }
            direction = !direction;
        }
//        System.out.println("Cyclecount:");
//        System.out.println(cycleCount);
    }


    public void selectionSort() {
//        int cycleCount = 0;
        for (int i = 0; i < nElems - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < nElems; j++) {
//                cycleCount++;
                if (a[j] < a[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            long temp = a[i];
            a[i] = a[indexOfMin];
            a[indexOfMin] = temp;
//            display();
        }
//        System.out.println(cycleCount);
    }

    public void improvedSelectionSort() {
//        int cycleCount = 0;
        for (int i = 0, k = nElems - 1; i < nElems / 2; i++, k--) {
            int indexOfMin = i;
            int indexOfMax = k;
            for (int j = i + 1; j < nElems - i; j++) {
//                cycleCount++;
                if (a[j] < a[indexOfMin]) {
                    indexOfMin = j;
                }
                if (a[j] > a[indexOfMax]) {
                    indexOfMax = j;
                }
            }
            long temp = a[i];
            a[i] = a[indexOfMin];
            a[indexOfMin] = temp;

            long tempForMax = a[k];
            a[k] = a[indexOfMax];
            a[indexOfMax] = tempForMax;
//            display();
        }
//        System.out.println(cycleCount);
    }


    public void insertionSort() {
        long copyCount = 0;
        long compareCount = 0;
        for (int i = 1; i < nElems; i++) {
            long temp = a[i];
            int j = i;
            while (j > 0) {
                compareCount++;
                if (temp <= a[j - 1]) {
                    a[j] = a[j - 1];
                    copyCount++;
                    --j;
//                display();
                } else {
                    break;
                }
            }
            a[j] = temp;
            copyCount++;

//            System.out.println("Partly sorted:");
//            display();
        }
//        display();
        System.out.println("Copycount: " + copyCount++);
        System.out.println("Comparecount: " + compareCount);
    }

    public void insertionSortNoDups() {
        int dupCount = 0;
        for (int i = 1; i < nElems; i++) {
            long temp = a[i];
            int j = i;
            while (j > 0 && temp <= a[j - 1]) {
                if (a[j - 1] == -1) {
                    break;
                }
                if (temp == a[j - 1]) {
                    dupCount++;
                    temp = -1;
                }
                a[j] = a[j - 1];

                --j;
            }
            a[j] = temp;
        }
        display();
        for (int k = 0; k < nElems - dupCount; k++) {
            a[k] = a[k + dupCount];
        }
        nElems -= dupCount;
        System.out.println(dupCount);
    }

    public void oddEvenSort() {
        int count = 0;
        while (true) {
            count++;
            boolean isSwapped = false;
            long temp;
            for (int even = 0; even + 1 < nElems; even += 2) {
                if (a[even] > a[even + 1]) {
                    temp = a[even];
                    a[even] = a[even + 1];
                    a[even + 1] = temp;
                    isSwapped = true;
//                    display();
                }
            }
            for (int odd = 1; odd + 1 < nElems; odd += 2) {
                if (a[odd] > a[odd + 1]) {
                    temp = a[odd];
                    a[odd] = a[odd + 1];
                    a[odd + 1] = temp;
                    isSwapped = true;
//                    display();
                }
            }
            if (!isSwapped) {
                System.out.println("Array has been sorted");
                System.out.println("Number of cycles - " + count);
                break;

            }
        }

    }

    public void median() {
        long medianValue;
        if (nElems % 2 == 0) {
            medianValue = (a[(nElems / 2 - 1)] + a[nElems / 2]) / 2;
        } else {
            medianValue = a[nElems / 2];
        }
        System.out.println(medianValue);
    }

    public void noDupsInSortedArray() {
        int tempCount = 0;
        for (int i = 0; i < nElems - 1; i++) {
            if (a[i] == a[i + 1]) {
                tempCount++;
            } else if (tempCount > 0) {
                a[i - tempCount + 1] = a[i + 1];
                display();
            } else {
                continue;
            }
        }
        nElems -= tempCount;

    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    public long getMax() {
        long max = -1;
        if (!(this == null)) {
            for (int i = 0; i < this.nElems; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
        }
        return max;
    }

    public long removeMax() {
        long max = -1;
        if (!(this == null)) {
            for (int i = 0; i < this.nElems; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            this.delete(max);
        }

        return max;
    }

    public long get(int index) {
        return a[index];
    }


}
