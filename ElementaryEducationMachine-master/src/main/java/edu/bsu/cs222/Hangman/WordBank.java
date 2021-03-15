package edu.bsu.cs222.Hangman;

import java.util.HashMap;

public class WordBank {
    HashMap<String,String> wordAndDefinition = new HashMap<>();

    public void mapWordAndDefinition(String word, String definition){
        wordAndDefinition.put(word, definition);
    }

    public HashMap<String,String> printWordAndDefinition(){
        return wordAndDefinition;
    }
}
