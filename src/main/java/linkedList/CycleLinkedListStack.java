package linkedList;

public class CycleLinkedListStack {

    private CycleLinkedList cycleLinkedList;
    private int maxSize;

    public CycleLinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        cycleLinkedList = new CycleLinkedList();
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");

            return;
        }

        cycleLinkedList.insert(value);
    }

    public Integer pop() {

        if (isEmpty()) {
            System.out.println("Stack is empty");

            return null;
        }

        for (int i = 0; i < cycleLinkedList.size() - 1; i++) {
            cycleLinkedList.next();
        }

        var result = cycleLinkedList.delete().getIntData();

//        System.out.println(result);

        return result;
    }

    public Integer peek() {

        if (isEmpty()) {
            System.out.println("Stack is empty");

            return null;
        }

        return cycleLinkedList.getCurrent().getIntData();
    }

    public boolean isEmpty() {
        return cycleLinkedList.isEmpty();
    }

    public boolean isFull() {
        return maxSize == cycleLinkedList.size();
    }

}
