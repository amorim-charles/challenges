package br.com.charles.challenge.writer_reader;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        //Modelo de leitura de arquivo
        PrintStream output = new PrintStream("src/PrintStream-Result.txt");
        output.println("Escrevendo com PrintStream");
        output.print("segunda linha");
        output.println("\t continua na segunda linha");
        output.println("Terceira linha");

        output.close();
    }
}
