package edu.bsu.cs222.Hangman.Model;

public class GuessChecker {

    public boolean guessCheck(String guess){

        if (guess.length() == 1){
            return checkLetter(guess);
        }
        else {return checkWord(guess);}
    }

    public boolean checkLetter(String guess){

        return WordBank.getWordBank().usedWord.toLowerCase().contains(guess);
    }

    public boolean checkWord(String guess){

        return guess.equalsIgnoreCase(WordBank.getWordBank().usedWord);
    }
}