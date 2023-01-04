package arrays;

import java.util.Random;
import java.util.Vector;
import java.util.function.Function;

public class MainArraysAndSimpleSorting {
    public static void main(String[] args) throws InterruptedException {
//        myVectorInit();
//        timeEval(myVector.linearSearchByValueFunction(3));
//        highArrayInit();
//        highArrayGetMax();
//        sortHighArray();
//        orderedArrayInit();
//        mergeOrderedArrays();
//        highArrayNoDups();
//        bubbleSort();
//        Thread.sleep(1000);
        selectionSort();
//        improvedSelectionSort();
//        Thread.sleep(1000);
//        insertionSort();
//        Thread.sleep(1000);
//        sortReversedSortedArray();
//        Thread.sleep(1000);
//        createReversedSortedArray().display();
//        createSortedArray().display();
//        sortSortedArray();
//        biDirectionalBubbleSort();
//        medianTest();
//        noDupsInSortedArrayTest();
//        oddEvenSorting();
//        insertSortCount();
//        insertSortAndDeleteDups();

    }


    public static void myVectorInit() {
        Vector<Integer> vector = new Vector<>(7, 0);
        System.out.println("Vector после создания:");
        System.out.println(vector);
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        System.out.println("Vector после добавления элементов:");
        System.out.println(vector);
        vector.remove(1);
        System.out.println("Vector после удаления элемента:");
        System.out.println(vector);
        System.out.println("Test foreach");
        for (Integer e : vector) {
            System.out.println(e);
        }

        MyVector<Integer> myVector = new MyVector<>(7, 5);
        System.out.println("myVector после создания:");
        System.out.println(myVector);
        myVector.print();
        myVector.add(1);
        myVector.add(2);
        myVector.add(3);
        myVector.add(4);
        myVector.add(5);
        myVector.add(6);
        System.out.println("myVector после добавления элементов:");
        System.out.println(myVector);
        myVector.print();
        myVector.delete(1);
        System.out.println("myVector после удаления элемента:");
        System.out.println(myVector);
        myVector.print();
        myVector.add(7);
        System.out.println("myVector после добавления элемента:");
        System.out.println(myVector);
        myVector.print();

        System.out.println("Test foreach");
        for (Object e : myVector) {
            System.out.println(e);
        }
    }

    public static void timeEval(Function<Object, Integer> function) {
        long start = System.currentTimeMillis();
//        int result = function.apply();
//        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void highArrayInit() {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();

        int searchKey = 35;

        if (arr.find(searchKey)) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }

    public static void highArrayGetMax() {
        int maxSize = 10;
        HighArray arr;
        arr = new HighArray(maxSize);
        System.out.println(arr.getMax());
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);

        System.out.println(arr.getMax());

        System.out.println(arr.removeMax());
        arr.display();

    }

    public static void highArrayNoDups() {
        Random r = new Random();
        int arraySize = 10;
        HighArray highArray = new HighArray(arraySize);
        for (int i = 0; i < arraySize; i++) {
            highArray.insert(r.nextLong(0, 50));
        }
        System.out.println("High array:");
        highArray.display();
        highArray.noDups();
        System.out.println("High array after noDups:");
        highArray.display();
    }

    public static void sortHighArray() {
        int maxSize = 10;
        HighArray arr;
        arr = new HighArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(100);
        arr.insert(22);
        arr.display();
        HighArray sortedArr = new HighArray(arr.getNElems());
        for (int i = 0; i < arr.getNElems() + i; i++) {
            sortedArr.insert(arr.removeMax());
        }
        sortedArr.display();
    }

    public static void orderedArrayInit() {
        int maxSize = 100;
        OrderedArray arr;
        arr = new OrderedArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();
        arr.insert(22);
        arr.display();
        Random r = new Random();
        arr.insert(r.nextLong(1000));
        arr.insert(r.nextLong(1000));
        arr.insert(r.nextLong(100));
        arr.insert(r.nextLong(100));
        arr.insert(r.nextLong(100));
        arr.insert(0);
        arr.insert(1);
        arr.insert(0);

        arr.display();

        int searchKey = 35;

        if (arr.find(searchKey) != -1) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }

    public static void mergeOrderedArrays() {
        Random r = new Random();

        OrderedArray firstArray = fillOrderedArray(new OrderedArray(r.nextInt(1, 20)));
        OrderedArray secondArray = fillOrderedArray(new OrderedArray(r.nextInt(1, 20)));

        System.out.println("First ordered array:");
        firstArray.display();
        System.out.println("Second ordered array:");
        secondArray.display();

        OrderedArray resultArray = new OrderedArray(firstArray.size() + secondArray.size());
        resultArray.merge(firstArray, secondArray);
        System.out.println("Result ordered array:");
        resultArray.display();
    }

    public static OrderedArray fillOrderedArray(OrderedArray array) {
        Random r = new Random();
        int cycleLength = r.nextInt(0, array.getCapacity());
        for (int i = 0; i < cycleLength; i++) {
            array.insert(r.nextLong(1000));
        }
        return array;
    }

    private static HighArray createRandomArray() {
        int maxSize = 100_000;
        HighArray arr = new HighArray(maxSize);
        Random r = new Random();
        for (int i = maxSize; i > 0; i--) {
            arr.insert(r.nextLong(maxSize));
        }
        arr.display();
        return arr;
    }

    private static void bubbleSort() {
        HighArray arr = createRandomArray();
        Operation operation = () -> arr.bubbleSort();
        timeMeasure(operation);
//        System.out.println("After sorting:");
//        arr.display();
    }

    private static void selectionSort() {
        HighArray arr = createRandomArray();
        Operation operation = () -> arr.selectionSort();
        timeMeasure(operation);
//        System.out.println("After sorting:");
//        arr.display();
    }

    private static void improvedSelectionSort() {
        HighArray arr = createRandomArray();
        Operation operation = () -> arr.improvedSelectionSort();
        timeMeasure(operation);
//        System.out.println("After sorting:");
//        arr.display();
    }


    private static void insertionSort() {
        HighArray arr = createRandomArray();
        Operation operation = () -> arr.insertionSort();
        timeMeasure(operation);
//        System.out.println("After sorting:");
//        arr.display();
    }

    private static HighArray createReversedSortedArray() {
        int maxSize = 100_000;
        HighArray array = new HighArray(maxSize);
        for (int i = maxSize; i > 0; i--) {
            array.insert(i);
        }
        System.out.println("Reversed sorted array" + ", elems: " + maxSize);
//        array.display();
        return array;
    }

    private static void sortReversedSortedArray() {
        HighArray arrayForBubble = createReversedSortedArray();

        long bubbleStart = System.currentTimeMillis();
        arrayForBubble.bubbleSort();
        long bubbleEnd = System.currentTimeMillis();

        long bubbleResult = (bubbleEnd - bubbleStart) / 1000;

//        System.out.println("After bubble sorting:");
//        arrayForBubble.display();

        System.out.println("Bubble sorting time:");
        System.out.println(bubbleResult);


        HighArray arrayForSelection = createReversedSortedArray();

        long selectionStart = System.currentTimeMillis();
        arrayForSelection.selectionSort();
        long selectionEnd = System.currentTimeMillis();

        long selectionResult = (selectionEnd - selectionStart) / 1000;

//        System.out.println("After selection sorting:");
//        arrayForSelection.display();

        System.out.println("Selection sorting time:");
        System.out.println(selectionResult);


        HighArray arrayForInsertion = createReversedSortedArray();

        long insertionStart = System.currentTimeMillis();
        arrayForInsertion.insertionSort();
        long insertionEnd = System.currentTimeMillis();

        long insertionResult = (insertionEnd - insertionStart) / 1000;

//        System.out.println("After Insertion sorting:");
//        arrayForInsertion.display();

        System.out.println("Insertion sorting time:");
        System.out.println(insertionResult);

    }

    private static HighArray createSortedArray() {
        int maxSize = 100_000;
        HighArray array = new HighArray(maxSize);
        for (int i = 0; i < maxSize; i++) {
            array.insert(i);
        }
        return array;
    }


    private static void sortSortedArray() {
        HighArray arrayForBubble = createSortedArray();
//        System.out.println(arrayForBubble.get(arrayForBubble.getNElems() - 1));
//        arrayForBubble.display();

        long bubbleStart = System.currentTimeMillis();
        arrayForBubble.bubbleSort();
        long bubbleEnd = System.currentTimeMillis();

        long bubbleResult = (bubbleEnd - bubbleStart) / 1000;
//        System.out.println(arrayForBubble.get(arrayForBubble.getNElems() - 1));
//        System.out.println("After bubble sorting:");
//        arrayForBubble.display();

        System.out.println("Bubble sorting time:");
        System.out.println(bubbleResult);


        HighArray arrayForSelection = createSortedArray();

        long selectionStart = System.currentTimeMillis();
        arrayForSelection.selectionSort();
        long selectionEnd = System.currentTimeMillis();

        long selectionResult = (selectionEnd - selectionStart) / 1000;

//        System.out.println("After selection sorting:");
//        arrayForSelection.display();

        System.out.println("Selection sorting time:");
        System.out.println(selectionResult);


        HighArray arrayForInsertion = createSortedArray();

        long insertionStart = System.currentTimeMillis();
        arrayForInsertion.insertionSort();
        long insertionEnd = System.currentTimeMillis();

        long insertionResult = (insertionEnd - insertionStart) / 1000;

//        System.out.println("After Insertion sorting:");
//        arrayForInsertion.display();

        System.out.println("Insertion sorting time:");
        System.out.println(insertionResult);
    }

    private static void biDirectionalBubbleSort() {
//        arrays.HighArray arr = createRandomArray();

        HighArray arr = new HighArray(10);

//        arr.insert(77);
//        arr.insert(99);
//        arr.insert(44);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);

        arr.insert(99);
        arr.insert(88);
        arr.insert(77);
        arr.insert(66);
        arr.insert(55);
        arr.insert(44);
        arr.insert(33);
        arr.insert(22);
        arr.insert(11);
        arr.insert(00);

        arr.display();
        long start = System.currentTimeMillis();
        arr.biDirectionalBubbleSort();
        long end = System.currentTimeMillis();

        long result = (end - start) / 1000;

        System.out.println("After sorting:");
        arr.display();

        System.out.println("Sorting time:");
        System.out.println(result);
    }

    public static void timeMeasure(Operation function) {
        System.out.println("Timemeasure start");
        long start = System.currentTimeMillis();
        function.process();
        long end = System.currentTimeMillis();

        long result = (end - start) / 1000;
        System.out.println("Sorting time:");
        System.out.println(result);

    }

    public static void medianTest() {

        HighArray arr = new HighArray(10);

//        arr.insert(77);
//        arr.insert(99);
//        arr.insert(44);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);

        arr.insert(5);
        arr.insert(1);
        arr.insert(3);
        arr.insert(25);
        arr.insert(19);
        arr.insert(17);
        arr.insert(21);
        arr.insert(19);


        arr.display();
        arr.insertionSort();

        arr.display();

        arr.median();


    }

    private static void noDupsInSortedArrayTest() {
        HighArray arr = new HighArray(100);

        arr.insert(0);
        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(3);
        arr.insert(3);
        arr.insert(6);
        arr.insert(7);
        arr.insert(8);
        arr.insert(8);
        arr.insert(10);
        arr.insert(11);
        arr.insert(12);
        arr.insert(13);
        arr.insert(14);
        arr.insert(15);
        arr.insert(15);
        arr.insert(15);
        arr.insert(15);
        arr.insert(16);
        arr.insert(17);
        arr.insert(18);
        arr.insert(19);
        arr.insert(20);

        arr.display();

        arr.noDupsInSortedArray();
        System.out.println("After noDups:");
        arr.display();
    }

    private static void oddEvenSorting() {
        HighArray arr = createRandomArray();
        Operation operation = () -> arr.oddEvenSort();
        timeMeasure(operation);

//        arrays.HighArray arr = new arrays.HighArray(100);

//        arr.insert(100);
//        arr.insert(44);
//        arr.insert(99);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);
//        arr.insert(77);
//
//
//        arr.insert(100);
//        arr.insert(99);
//        arr.insert(88);
//        arr.insert(77);
//        arr.insert(66);
//        arr.insert(55);
//        arr.insert(44);
//        arr.insert(33);
//        arr.insert(22);
//        arr.insert(11);
//        arr.insert(00);
//
//        arr.display();
//
//        arr.oddEvenSort();
//        arr.display();
    }

    private static void insertSortCount() {
//        arrays.HighArray arr = new arrays.HighArray(100);
//
////        arr.insert(100);
//        arr.insert(44);
//        arr.insert(99);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);
//        arr.insert(77);
////
////
////        arr.insert(100);
////        arr.insert(99);
////        arr.insert(88);
////        arr.insert(77);
////        arr.insert(66);
////        arr.insert(55);
////        arr.insert(44);
////        arr.insert(33);
////        arr.insert(22);
////        arr.insert(11);
////        arr.insert(00);
//
////        arr.insert(00);
////        arr.insert(11);
////        arr.insert(22);
////        arr.insert(33);
////        arr.insert(44);
////        arr.insert(55);
////        arr.insert(66);
////        arr.insert(77);
////        arr.insert(88);
////        arr.insert(99);
////        arr.insert(100);

        HighArray arr = createRandomArray();
//        arrays.Operation operation = () -> arr.insertionSort();
//        timeMeasure(operation);
////
//        arr.display();
////
//        arr.insertionSort();
//        arr.display();

//        arrays.HighArray arr = createReversedSortedArray();
//        arr.display();

        arr.insertionSort();

        System.out.println("Sorted array:");

        arr.display();
//        arr.setElementByIndex(5, 56);
//        arr.setElementByIndex(10, 20);
//        arr.setElementByIndex(15, 85);
//        arr.setElementByIndex(23, 88);
//        arr.setElementByIndex(30, 49);
//        arr.setElementByIndex(40, 76);
//        arr.setElementByIndex(45, 0);
//        arr.setElementByIndex(50, 77);
//        arr.setElementByIndex(53, 99);
//        arr.setElementByIndex(59, 66);
//        arr.setElementByIndex(62, 56);
//        arr.setElementByIndex(67, 25);
//        arr.setElementByIndex(69, 43);
//        arr.setElementByIndex(71, 30);
//        arr.setElementByIndex(74, 78);
//        arr.setElementByIndex(78, 2);
//        arr.setElementByIndex(81, 34);
//        arr.setElementByIndex(86, 56);
//        arr.setElementByIndex(89, 7);
//        arr.setElementByIndex(97, 1);
        Random r = new Random();
//        for (int i = arr.size() - 10; i < arr.size(); i++) {
        for (int i = 0; i < arr.size(); i+=100) {
            arr.setElementByIndex(i, r.nextLong(1000));
        }

        arr.display();

        arr.insertionSort();

        arr.display();


    }

    private static void insertSortAndDeleteDups() {
        HighArray arr = new HighArray(20);
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            arr.insert(r.nextLong(30));
        }
        arr.display();

        arr.insertionSortNoDups();

        arr.display();

    }
}
