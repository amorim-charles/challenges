package br.com.charles.challenge.strings;

public class StringInvert {

    public String invert(String phrase) {
        if (phrase == null) {
            return null;
        }
        char[] phraseArr = phrase.toCharArray();
        String phraseInvert = "";

        for (int i = phraseArr.length -1; i >= 0; i--) {
            phraseInvert = phraseInvert.concat(String.valueOf(phraseArr[i]));
        }

        return phraseInvert;
    }
}
