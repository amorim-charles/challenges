package br.com.charles.challenge.writer_reader;

import java.io.*;

public class ReaderAndWriterTest {
    public static void main(String[] args) throws IOException {
        //Antes de executar esse teste rode a classe FileWriter para criar o arquivo que será lido aqui

        //Modelo de leitura
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("src/FileWriter-Result.txt")));

        //Modelo de escrita
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/FileWriter-Update.txt")));

        String line = input.readLine();
        output.write("Update feita pela classe FileReaderAndWriter\n");

        while (line != null) {
            output.write(line);
            output.newLine();
            line = input.readLine();
        }

        input.close();
        output.close();
    }

}
