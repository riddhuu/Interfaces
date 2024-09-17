import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Filter shortWordFilter = new ShortWordFilter();
        ArrayList<String> shortWords = new ArrayList<>();

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try (Scanner scanner = new Scanner(selectedFile)) {
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    if (shortWordFilter.accept(word)) {
                        shortWords.add(word);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
                return;
            }
        }

        System.out.println("Short words (less than 5 characters):");
        for (String word : shortWords) {
            System.out.println(word);
        }
    }
}