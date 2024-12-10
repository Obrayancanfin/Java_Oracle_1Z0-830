package Exo1;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Calculator> operation = new HashMap<>();
        Scanner scanner =new Scanner(System.in);

        operation.put("a+b\n", Double::sum);
        operation.put("a-b\n",(a,b) -> a - b);
        operation.put("a/b\n",(a,b) -> b!=0? a / b : Double.NaN);
        operation.put("a*b\n",(a,b) -> a * b);
        operation.put("a%b\n",(a,b) -> b!=0? a % b : Double.NaN);
        operation.put("a^b\n",(a,b) -> Math.pow(a,b));

        Consumer<String> display = System.out::println;
        display.accept("~~~~~Calculator~~~~~");
        display.accept("entrer votre operation :");
        String input = scanner.nextLine();

        String[] resultat = input.split("[+*\\/\\-^]");
        Calculator result = operation.get(input);
        System.out.println(result);
        double resultas =result.calculate(Double.parseDouble(resultat[0]),Double.parseDouble(resultat[1]));
        display.accept(String.valueOf(resultas));
    }
}
