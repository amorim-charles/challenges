package br.com.charles.challenge.strings;

import java.util.Objects;

public class StringReverse {

    public String reverse(String input) {
        if (Objects.isNull(input)) {
            return null;
        }

        String[] inputArr = input.split(" ");
        String output = "";

        for (int i = inputArr.length - 1; i >= 0; i--) {
            output = output.concat(inputArr[i]).concat(" ");
        }

        return output.trim();
    }
}

