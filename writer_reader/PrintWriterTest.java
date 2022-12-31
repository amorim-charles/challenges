package br.com.charles.challenge.writer_reader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output = new PrintWriter("src/main/resources/PrintWriter - Charles Amorim.txt");
        output.println("Teste de escrita com PrintWriter");
        output.print("Segunda linha");
        output.println("\t continua na segunda linha");
        output.println("Terceira linha");
        output.close();
    }
}
