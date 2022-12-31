package br.com.charles.challenge.writer_reader;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String pharse = "um dois tres";
        System.out.println("Código unicode da letra u: " + pharse.codePointAt(0));

        Charset charset = Charset.defaultCharset();
        System.out.println("Charset default OS: " + charset);

        byte[] bytes = pharse.getBytes(StandardCharsets.US_ASCII);
        System.out.println(bytes.length + " ASCII");

        bytes = pharse.getBytes(StandardCharsets.ISO_8859_1);
        System.out.println(bytes.length + " ISO 8859-1");

        bytes = pharse.getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length + " UTF-8");

        bytes = pharse.getBytes(StandardCharsets.UTF_16BE);
        System.out.println(bytes.length + " UTF-16BE");

        bytes = pharse.getBytes(StandardCharsets.UTF_16LE);
        System.out.println(bytes.length + " UTF-16LE");

        bytes = pharse.getBytes(StandardCharsets.UTF_16);
        System.out.println(bytes.length + " UTF-16");

    }
}
