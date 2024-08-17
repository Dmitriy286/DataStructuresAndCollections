package flavius;

import linkedList.CycleLinkedList;
import linkedList.Node;

import java.util.ArrayList;
import java.util.List;

public class FlaviusApp {

    private int manCount;
    private int countNumber;
    private int startNumber;

    private CycleLinkedList cycleLinkedList;

    private List<Integer> disruptedMen;

    private Node currentMan;

    public FlaviusApp(int manCount, int countNumber, int startNumber) {
        this.manCount = manCount;
        this.countNumber = countNumber;
        this.startNumber = startNumber;

        createList();

        this.disruptedMen = new ArrayList<>();
    }

    public void startGame() {
        while (cycleLinkedList.size() > 1) {
            countForDisrupt();
        }

        System.out.println(disruptedMen);

        System.out.println("List size: " + cycleLinkedList.size());

        System.out.println(cycleLinkedList.getCurrent().getIntData());
    }

    private void countForDisrupt() {
        for (int i = 0; i < countNumber - 1; i++) {
            cycleLinkedList.next();
        }

        Node disruptedMan = cycleLinkedList.delete();

        disruptedMen.add(disruptedMan.getIntData());
    }

    private void createList() {

        this.cycleLinkedList = new CycleLinkedList();

        for (int i = 1; i <= manCount; i++) {
            cycleLinkedList.insert(i);
        }

        currentMan = getCurrentMan();
    }

    private Node getCurrentMan() {
        return cycleLinkedList.find(startNumber);
    }


}
