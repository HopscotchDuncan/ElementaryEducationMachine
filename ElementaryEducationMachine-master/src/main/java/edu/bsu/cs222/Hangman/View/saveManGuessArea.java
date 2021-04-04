package edu.bsu.cs222.Hangman.View;

import edu.bsu.cs222.Hangman.Model.GuessChecker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class saveManGuessArea extends HBox {

    GuessChecker guessChecker = new GuessChecker();
    TextField guessTextField = new TextField();

    public saveManGuessArea(){
        setSpacing(20);
        setAlignment(Pos.BOTTOM_RIGHT);

        setTextArea();
        getChildren().addAll(guessTextField, createEnterInButton());


    }

    private Button createEnterInButton(){
        Button button = new Button("Check Answer");

        button.setOnAction(e ->{
            String guess = guessTextField.getText();
            Boolean check = guessChecker.guessCheck(guess);
            System.out.printf(String.valueOf(check));
        });

        return button;
    }
    private void setTextArea(){
        guessTextField.setPromptText("Enter in Word or Letter");
    }

}
