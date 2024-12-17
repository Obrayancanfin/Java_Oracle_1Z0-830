import java.util.concurrent.*;

public class CalculatorCallable implements Callable<Integer> {
    private final int num1;

    public CalculatorCallable(int num1) {
        this.num1 = num1;
    }

    public static void main(String[] args) {

    };

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
