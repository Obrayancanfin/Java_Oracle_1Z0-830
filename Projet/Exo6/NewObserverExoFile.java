import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;

public class NewObserverExoFile implements Observer {

    @Override
    public void update(String o) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("test.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
