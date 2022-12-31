package br.com.charles.challenge.writer_reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        //Modelo para ler arquivos com código de alto nível
//        FileInputStream inputStream = new FileInputStream("src/FileWriter-Result.txt");
//        InputStreamReader inputReader = new InputStreamReader(inputStream);
//        BufferedReader input = new BufferedReader(inputReader);

        //Forma compacta de escrever o códio acima
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("src/FileWriter-Result.txt")));

        // Lê apenas a primeira linha
        String fileResult = input.readLine();

        //Laço para ler todas as linhas
        while (fileResult != null) {
            System.out.println(fileResult);
            fileResult = input.readLine();
        }

        input.close();
    }
}
