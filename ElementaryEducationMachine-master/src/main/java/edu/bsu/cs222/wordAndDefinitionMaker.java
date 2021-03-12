package edu.bsu.cs222;

import java.util.HashMap;

public class wordAndDefinitionMaker {
    HashMap<String,String> wordAndDefinition = new HashMap<>();

    public void wordAndDefinitionMapper(String word, String Definition){
        wordAndDefinition.put(word, Definition);
    }

    public HashMap<String,String> printWordAndDefinition(){
        return wordAndDefinition;
    }
}
