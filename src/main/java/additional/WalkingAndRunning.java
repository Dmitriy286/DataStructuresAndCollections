package additional;

public interface WalkingAndRunning {
    default void going() {
        System.out.println("going");
    };

    void walking();

    void running();


}
