package edu.bsu.cs222.Saveman.Model;

import java.util.ArrayList;
import java.util.Random;

public class WordRandomizer {
    ArrayList<String> WordList = WordBank.getWordBank().wordList;

    public void setRandomWord(){
        String word = createRandomWord();

        WordBank.getWordBank().removeWord(word);

        WordBank.getWordBank().setUsedWord(word);
    }

    private String createRandomWord(){
        Random r = new Random();

        int randomString = r.nextInt(WordList.size());

        return WordList.get(randomString);

    }

}
