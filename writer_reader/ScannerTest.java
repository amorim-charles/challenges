package br.com.charles.challenge.writer_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/main/resources/FileWriter - Charles Amorim.txt"));

        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(" ");

            if (lineScanner.hasNext()) {
                String dois = lineScanner.next();
                System.out.println(dois);
            }
        }

        input.close();
    }
}
