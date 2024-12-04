import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> myMap = null;
        try {
            myMap = new HashMap<String, String>();
            File myObj = new File("configuration.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.replace("{", "");
                data = data.replace("}", "");
                data = data.replace(": ", " ");
                String[] listData = data.split(",");
                for (int i = 0; i < listData.length; i++) {
                    listData[i] = listData[i].replace("\"", "");
                    String[] listdataParsed = listData[i].split(" ");
                    myMap.put(listdataParsed[1], listdataParsed[2]);
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(myMap);
    }
}
