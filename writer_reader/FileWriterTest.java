package br.com.charles.challenge.writer_reader;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        //Modelo para escrever arquivos com código de alto nível
//        FileOutputStream outputStream = new FileOutputStream("src/FileWriter-Result.txt");
//        OutputStreamWriter outputWriter = new OutputStreamWriter(outputStream);
//        BufferedWriter output = new BufferedWriter(outputWriter);

        //Forma compacta de escrever o código acima
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/FileWriter - Charles Amorim.txt")));

        output.write("Teste de escrita"); // write não pula linha
        output.newLine(); // pula linha
        output.newLine();
        output.write("Terceira linha");
        output.newLine();
        output.write("Quarta linha");
        output.newLine();
        output.write("Quinta linha");
        output.newLine();
        output.write("Fim da linha");

        output.close();
    }
}
