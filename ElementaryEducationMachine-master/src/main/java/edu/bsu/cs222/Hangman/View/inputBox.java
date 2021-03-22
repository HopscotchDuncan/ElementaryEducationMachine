package edu.bsu.cs222.Hangman.View;

import edu.bsu.cs222.Hangman.Model.WordBank;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class inputBox extends Stage {

    public inputBox(){
        Scene scene = createUI();

        setScene(scene);
    }


    public Scene createUI(){
        VBox layout = new VBox(20);
        Button addAWordButton = createAddAWordButton();
        Button startGameButton = createStartGameButton();
        TextField wordInputTextField = creatWordInputTextField();
        TextField definitionInputTextField = createdefinitionTextField();

        layout.getChildren().addAll(wordInputTextField,definitionInputTextField,addAWordButton,startGameButton);
        return new Scene(layout, 300, 200);
    }

    private TextField createdefinitionTextField() {
        TextField textField = new TextField();
        textField.setPromptText("Enter in Definition Here");
        return textField;
    }

    private TextField creatWordInputTextField() {
        TextField textField = new TextField();
        textField.setPromptText("Enter in Word Here");
        return textField;

    }

    private Button createStartGameButton() {

        Button startGame = new Button("Start game");


        return startGame;
    }

    private Button createAddAWordButton() {
        return new Button("Add Word");

    }
}

