package flavius;

public class Main {

    public static void main(String[] args) {
//        int manCount = 20;
//        int countNumber = 3;
//        int startNumber = 1;

        int manCount = 7;
        int countNumber = 3;
        int startNumber = 1;

//        int manCount = 5;
//        int countNumber = 1;
//        int startNumber = 1;

        FlaviusApp flaviusApp = new FlaviusApp(manCount, countNumber, startNumber);

        flaviusApp.startGame();
    }
}
