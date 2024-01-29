package SimpleMapEditor;

import java.io.*;

public class FileManager {

    public static String readFile() {

        String result = "";
        try {
            FileReader fileReader = new FileReader("resources/grid.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";


            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    public static void writeFile(String grid) {

        try {
            FileWriter fileWriter = new FileWriter("resources/grid.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(grid);
            bufferedWriter.close();


        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
