public class OrderedArray {
    private long[] a;
    private int nElems;

    public OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int getCapacity() {
        return a.length;
    }

    public Long getItem(int index) {
        return a[index];
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;


        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return -1;
            } else {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    public void insert(long value) {
        int lowerBound = 0;
        int upperBound = nElems;
        int curIn;
        int insertIndex;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == value || lowerBound >= upperBound) {
                insertIndex = curIn;
                break;
            } else {
                if (a[curIn] < value) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn;
                }
            }
        }

        for (int k = nElems; k > insertIndex; k--) {
            a[k] = a[k - 1];
        }
        a[insertIndex] = value;
        nElems++;
    }

    private void simpleInsert(Long value) {
        a[this.size()] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
        }
        return true;
    }

    public void merge(OrderedArray firstArray, OrderedArray secondArray) {
        int firstCount = 0;
        int secondCount = 0;
//        int cycleLength = Math.max(firstArray.length, secondArray.length);
        int cycleLength = firstArray.size() + secondArray.size();
//        OrderedArray resultArray = new OrderedArray(cycleLength);
        for (int i = 0; i < cycleLength; i++) {
            if (firstCount >= firstArray.size()) {
                this.addAll(secondArray, secondCount, secondArray.size());
                break;
            } else if (secondCount >= secondArray.size()){
                this.addAll(firstArray, firstCount, firstArray.size());
                break;
            } else if (firstArray.getItem(firstCount) < secondArray.getItem(secondCount)) {
                this.simpleInsert(firstArray.getItem(firstCount));
                firstCount++;
            } else {
                this.simpleInsert(secondArray.getItem(secondCount));
                secondCount++;
            }
            }
    }

    private void addAll(OrderedArray array, int leftBoundIndex, int rightBoundIndex) {
//        int cycleCount = rightBoundIndex - leftBoundIndex; //+1
        for (int i = leftBoundIndex; i < rightBoundIndex; i++) {
            this.simpleInsert(array.getItem(i));
        }
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


}
