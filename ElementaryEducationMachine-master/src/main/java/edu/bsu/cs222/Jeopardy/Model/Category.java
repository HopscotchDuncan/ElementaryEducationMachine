package edu.bsu.cs222.Jeopardy.Model;

import java.util.HashMap;

public class Category {
    String categoryName;
    HashMap<String, String> questions;

    public Category(String categoryName, HashMap<String,String> questions){
        this.categoryName = categoryName;
        this.questions = questions;
    }
}
