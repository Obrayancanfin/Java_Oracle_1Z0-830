import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        class swing1 extends JFrame {
            public swing1() {
                super("QCM Java");

                WindowListener l = new WindowAdapter() {
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                };

                addWindowListener(l);
                setSize(200,100);
                setVisible(true);
            }

        }
        JFrame frame = new swing1();
    }
}