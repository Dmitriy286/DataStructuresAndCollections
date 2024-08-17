package valueOrReference;

public class Main {

    public static void main(String[] args) {
        Dog aDog = new Dog("Max"); // creating the "Max" dog

// at this point, aDog points to the "Max" dog
        System.out.println("--------");
        System.out.println(aDog);
        System.out.println("--------");

        foo(aDog);

        System.out.println("========");
        System.out.println(aDog);
        System.out.println("========");


// aDog still points to the "Max" dog
    }

//    public static void foo(Dog d) {
//        d = new Dog("Fifi"); // creating the "Fifi" dog
//    }

    public static void foo(Dog someDog) {  // AAA
        System.out.println("++++++++");

        System.out.println(someDog);

        someDog.setName("Toz");     // BBB
        System.out.println(someDog);

        someDog = new Dog("Fifi");  // CCC
        System.out.println(someDog);

        someDog.setName("Rowlf");   // DDD
        System.out.println(someDog);

        System.out.println("++++++++");
    }
}
