import java.util.ArrayList;
import java.util.List;

public class ObserverExo {
        private  List<Observer> observables = new ArrayList<>();

        public  void addObserver(Observer observable) {
            observables.add(observable);
        }

        public void removeObserver(Observer observable) {
            observables.remove(observable);
        }

        public void setMessage(String message) {
            for (Observer observable : observables) {
                observable.update(message);
            }
        }
}
