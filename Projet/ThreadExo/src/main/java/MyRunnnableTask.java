import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyRunnnableTask implements Runnable {
    private final int nombre;
    public MyRunnnableTask(int nombre) {
        this.nombre = nombre;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            Thread thread = new Thread(new MyRunnnableTask(i));
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Le carre de "+nombre+" est "+(nombre*nombre));
    }
}
