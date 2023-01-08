package stackAndQueue;

public class StackDequeApp {
    public static void main(String[] args) {
        StackDeque stackDeque = new StackDeque(10);
        stackDeque.push(10);
        stackDeque.push(20);
        stackDeque.push(30);
        stackDeque.push(40);
        stackDeque.push(50);
        stackDeque.push(60);
        stackDeque.push(70);
        stackDeque.push(80);
        stackDeque.push(90);
        stackDeque.push(100);
        stackDeque.push(110);

        stackDeque.pop();

        System.out.println(stackDeque.peek());

        while (!stackDeque.isEmpty()) {
            long temp = stackDeque.pop();
            System.out.print(temp);
            System.out.print(" ");
        }
    }
}
