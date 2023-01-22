package linkedList;

public class LinkedListStackApp {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(20);
        stack.push(40);

        stack.display();

        stack.push(60);
        stack.push(80);

        stack.display();

        stack.pop();
        stack.pop();

        stack.display();
    }
}
