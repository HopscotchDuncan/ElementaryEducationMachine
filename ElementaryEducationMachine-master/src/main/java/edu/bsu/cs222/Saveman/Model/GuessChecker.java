package edu.bsu.cs222.Saveman.Model;

public class GuessChecker {

    public boolean guessCheck(String guess){
        boolean check;

        if (guess.length() == 1){
            check =checkLetter(guess);
        }
        else {check = checkWord(guess);}
        return check;
    }

    public boolean checkLetter(String guess){

        return WordBank.getWordBank().usedWord.toLowerCase().contains(guess);
    }

    public boolean checkWord(String guess){

        return guess.equalsIgnoreCase(WordBank.getWordBank().usedWord);
    }
}