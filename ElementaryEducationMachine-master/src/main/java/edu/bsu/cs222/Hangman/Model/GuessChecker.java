package edu.bsu.cs222.Hangman.Model;

public class GuessChecker {

    public boolean checkLetter(String guess, String correct){

        return correct.toLowerCase().contains(guess);
    }

    public boolean checkWord(String guess, String correct){

        return guess.equalsIgnoreCase(correct);
    }
}