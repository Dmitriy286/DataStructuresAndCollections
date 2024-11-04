package hashtable;

public class Dog extends Animal implements WalkingAndRunning{
    @Override
    public void makeSound() {
        System.out.println("Gav!");
    }

    @Override
    public void walking() {
        System.out.println("Dog is walking");

    }

    @Override
    public void running() {
        System.out.println("Dog is running");

    }

    @Override
    public void going() {
        WalkingAndRunning.super.going();
//        System.out.println("Dog is going");
    }
}
