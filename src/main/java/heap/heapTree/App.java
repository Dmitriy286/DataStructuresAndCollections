package heap.heapTree;

public class App {

    public static void main(String[] args) {

        Heap heap = new Heap(31);

        heap.insert(70);
        heap.insert(40);
        heap.insert(50);
        heap.insert(20);
        heap.insert(60);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(10);
        heap.insert(90);


        heap.display();

        System.out.printf("remove: %s", heap.remove().iData);
        System.out.println();

        heap.display();


        System.out.printf("remove: %s", heap.remove().iData);
        System.out.println();

        heap.display();

        heap.change(3, 77);

        heap.display();
    }
}
