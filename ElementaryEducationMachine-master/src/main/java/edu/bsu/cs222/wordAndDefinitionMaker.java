package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordAndDefinitionMaker {
    List<String> words = new ArrayList<String>();
    List<String> definitions = new ArrayList<String>();
    HashMap<String,String> wordAndDefinition = new HashMap<>();

   /* public void wordListMaker(String word) {
       if (!word.equals("")) {
           words.add(word);
       }
    }
    public void definitionListMaker(String definition) {
        if(!definition.equals("")) {
            definitions.add(definition);
        }
    }
    public void printWordsList(){
        System.out.printf(String.valueOf(words));
    }
    public void printDefinitionList(){
        System.out.printf(String.valueOf(definitions));
    }*/
    public void wordAndDefinitionMapper(String word, String Definition){
        wordAndDefinition.put(word, Definition);
    }
    public void printWordAndDefinition(){
        System.out.printf(String.valueOf(wordAndDefinition));
    }
}
