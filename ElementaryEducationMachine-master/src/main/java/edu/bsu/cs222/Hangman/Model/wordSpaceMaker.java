package edu.bsu.cs222.Hangman.Model;

import java.util.Locale;

public class wordSpaceMaker {
    StringBuilder wordText = new StringBuilder();


    public StringBuilder createDashes() {

        String blankSpace = " ";
        for (int i = 0; i < WordBank.getWordBank().usedWord.length(); i++) {
            if (WordBank.getWordBank().usedWord.charAt(i) == blankSpace.charAt(0)) {
                wordText.append("  ");
            } else {
                wordText.append(" ");
                wordText.append("_");
            }
        }
        return wordText;
    }

    public StringBuilder replaceDashesWithLetters(String character){
        String word = WordBank.getWordBank().usedWord;
        word = word.toLowerCase(Locale.ROOT);
        for (int i = 0; i < word.length(); i++){
            if (character.equals(String.valueOf(word.charAt(i)))){
                wordText.replace(i,i+1, String.valueOf(character));
                wordText.append(" ");
            }
            else{
                wordText.append(" ");
                wordText.append("_");
            }
        }
        return wordText;
    }
}
