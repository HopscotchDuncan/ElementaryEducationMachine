package edu.bsu.cs222.Hangman.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordBank {

    Map<String, String> wordAndDefinition = new HashMap<>();
    ArrayList<String> wordList = new ArrayList<>();

    public WordBank(){

        wordAndDefinition.put("Sam", "Rar");

    }

    public void mapWordAndDefinition(String word, String definition){

        this.wordAndDefinition.put(word, definition);

    }


    public Map<String,String> getWordAndDefinition(){


        return this.wordAndDefinition;
    }

    public void addToArrayList(String Word){
        wordList.add(Word);
    }

     public String getRandomWord(){
       /* Random r = new Random();

        int randomString = r.nextInt(wordList.size());
        String word = wordList.get(randomString);*/

        return "game";
    }

    public Map<String, String> getDefinition() {
        return getWordAndDefinition();
    }
}
