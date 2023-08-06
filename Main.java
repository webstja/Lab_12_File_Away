import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                java.io.File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.getName();
                System.out.println("File chosen: " + fileName);

                FileReader fileReader = new FileReader(selectedFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                int lines = 0;
                int words = 0;
                int characters = 0;

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    lines++;
                    String[] wordsArray = line.split("\\s+");
                    words += wordsArray.length;
                    characters += line.length();
                }

                bufferedReader.close();

                System.out.println("Number of lines: " + lines);
                System.out.println("Number of words: " + words);
                System.out.println("Number of characters: " + characters);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file chosen.");
        }
    }
}
