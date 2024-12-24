package graphs.directedGraph;

public class StackX {
    private final int SIZE = 20;
    private int[] stackArray;
    private int top;

    public StackX() {
        stackArray = new int[SIZE];
        top = -1;
    }

    public void push(int j) {
        stackArray[++top] = j;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
