package edu.bsu.cs222.Saveman.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordBank {

    public static WordBank wordBank = null;

    private final  Map<String, String> wordAndDefinition = new HashMap<>();
    public ArrayList<String> wordList = new ArrayList<>();

    private String word;
    private  String definition;

    public String usedWord;

    public WordBank(){
    }

    public static WordBank getWordBank(){
        if (wordBank == null){
          wordBank = new WordBank();
        }
        return wordBank;
    }

    public void mapWordAndDefinition(String word, String definition){
        this.word = word;
        this.definition= definition;
        map();
    }
    public void removeWord(String word){
        wordList.remove(word);
    }

    public void setUsedWord(String usedWord){
        this.usedWord = usedWord;
    }

    public String getDefinition(){
        return wordAndDefinition.get(usedWord);

    }
    public void addToArrayList(String Word){
        this.word = Word;
        addWordList();
    }


    private void map(){
        wordAndDefinition.put(word, definition);
    }


    private void addWordList(){
        wordList.add(word);
    }




}
