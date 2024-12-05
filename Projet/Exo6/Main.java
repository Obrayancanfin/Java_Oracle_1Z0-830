public class Main {
    public static void main(String[] args) {

        ObserverExo observer = new ObserverExo();

        Observer observer1 = new NewObserverExoConsole("Console");
        Observer observer2 = new NewObserverExoFile();

        observer.addObserver(observer1);
        observer.addObserver(observer2);

        observer.setMessage("Hello World");
        observer.setMessage("Hello Darkness my old friend");

        observer.removeObserver(observer1);
        observer.setMessage("Hello there");


    }
}
