package edu.bsu.cs222;

public class HangmanChecker {

    public boolean isLetterCorrect(String guess, String correct){
        return correct.toLowerCase().contains(guess);
    }

    public boolean isWordCorrect(String guess, String correct){
        return guess.equalsIgnoreCase(correct);
    }
}