package arrays;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyVector<E> extends AbstractList implements Cloneable {
    protected Object[] array;
    protected int capacity;
    protected int capacityIncrement;
    protected int elementCount;
    protected transient int modificationCount;

    public MyVector(int initCapacity, int capacityIncrement) {
        super();
        if (initCapacity < 0) {
            throw new IllegalArgumentException("Capacity have to be more or equals to zero and not \"" + initCapacity + "\"");
        }
        this.capacity = initCapacity;
        this.capacityIncrement = capacityIncrement > 0 ? capacityIncrement : 0;
        this.array = new Object[this.capacity];
    }

    public void print() {
        int index = 0;
        for (Object e : array) {
            System.out.println(index + " - " + e);
            index++;
        }
    }

    @Override
    public synchronized boolean add(Object e) {
        modificationCount++;
        this.autoIncrease();
        array = Arrays.copyOf(array, capacity);
        array[elementCount] = e;
        elementCount++;
        return true;
    }

    public void delete(int index) {
        modificationCount++;
        for (int i = 0; i < this.size() - index; i++) {
            array[index + i] = array[index + i + 1];
        }
        elementCount--;
        autoDecrease();
    }

    private void autoIncrease() {
        if (capacity < elementCount + capacityIncrement && capacityIncrement > 0) {
            capacity = capacity + capacityIncrement;
        } else {
            capacity = capacity + 1;
        }
    }

    private void autoDecrease() {
        capacity = elementCount;
        array = Arrays.copyOf(array, capacity);
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    protected MyVector<E> clone() throws CloneNotSupportedException {
        MyVector<E> vector = new MyVector<E>(this.capacity, this.capacityIncrement);
        for (int i = 0; i < this.size(); i++) {
            vector.set(i, this.array[i]);
        }
        return vector;
    }

    @Override
    public Stream stream() {
        return super.stream();
    }

    @Override
    public void sort(Comparator c) {
        super.sort(c);
    }

    @Override
    public void forEach(Consumer action) {
        super.forEach(action);
    }

//    public int linearSearchByValue(Object e) {
//public Function<Object, Integer> linearSearchByValueFunction(Object e) {
//    return (e) -> {
//        for (int i = 0; i < this.size(); i++) {
//            if (this.array[i] == e) {
//                return i;
//            }
//        }
//        return -1;
//    };
//    }

//    public Function<Object, Integer> linearSearchByValueFunction(Object e) {
//        return () -> linearSearchByValue(e);
//    }

    public int binarySearchByValue(E e, Function<Object, Integer> function) {
        int leftBound = 0;
        int rightBound = elementCount - 1;
        int checkedIndex;
        Object[] arrayForSearch = this.array.clone();
        while (true) {
            checkedIndex = (rightBound - leftBound) / 2;
            if (rightBound - leftBound <= 0) {
                break;
            } else if (arrayForSearch[checkedIndex] == e) {
                return checkedIndex;
            } else if (Comparator.comparing(function).compare(arrayForSearch[checkedIndex], e) < 0) { //arrayForSearch[checkedIndex] < e
                leftBound = checkedIndex + 1;
            } else if (Comparator.comparing(function).compare(arrayForSearch[checkedIndex], e) > 0) {
                rightBound = checkedIndex - 1;
            }
        }
        return -1;
    }
}
