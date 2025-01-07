package org.example;

import java.io.*;


public class Main {
    public static void main(String[] args)  {
        int nbrJava = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("java")) {
                    nbrJava++;
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        System.out.println(nbrJava);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Result.txt")) ){
            writer.write("Le nombre de ligne contenent \" java \" est de "+nbrJava);
        }catch (IOException e){
            System.err.println(e);
        }
    }
}