package stackAndQueue;

import linkedList.CycleLinkedListStack;

import java.util.Random;

public class StackApp {
    public static void main(String[] args) {
        linkedListStack();

//        simpleStack();

    }

    private static void linkedListStack() {

        CycleLinkedListStack stack = new CycleLinkedListStack(10);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) {
            var peekValue = stack.peek();
            System.out.print(peekValue);
            System.out.print(" ");

            int value = stack.pop();
            System.out.print(value);
            System.out.print(" ");

            Random random = new Random();

            int newValue = random.nextInt();
            System.out.println("New value: " + newValue);

            stack.push(newValue);

        }

        System.out.println();
        System.out.println("======================");
        System.out.println();
    }

    private static void simpleStack() {
        StackX stack = new StackX(10);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) {
            long value = stack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
    }
}
