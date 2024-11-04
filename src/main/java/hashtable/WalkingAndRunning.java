package hashtable;

public interface WalkingAndRunning {
    default void going() {
        System.out.println("going");
    };

    void walking();

    void running();


}
