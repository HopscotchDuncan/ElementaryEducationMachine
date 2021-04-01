package edu.bsu.cs222.Hangman.View;

import javafx.scene.layout.GridPane;

public class saveManGridPane extends GridPane {
    definitionTextArea definitionTextArea = new definitionTextArea();
    public saveManGridPane(){
        getChildren().add(definitionTextArea);
    }
}
