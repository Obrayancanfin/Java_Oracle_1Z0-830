import java.util.Observable;


public class NewObserverExoConsole implements Observer {

    private String name;

    public NewObserverExoConsole(String name) {
        this.name = name;
    }


    @Override
    public void update(String o) {
        System.out.println(name + " a recu un message : "+ o);
    }
}
