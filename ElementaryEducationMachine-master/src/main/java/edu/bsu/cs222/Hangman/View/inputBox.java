package edu.bsu.cs222.Hangman.View;

import edu.bsu.cs222.Hangman.Model.WordBank;
import edu.bsu.cs222.Hangman.Model.randomizeWords;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Map;


public class inputBox extends Stage {
    inputBoxTextsFields inputBoxTextsFields = new inputBoxTextsFields();
    inputBoxButtons inputBoxButtons = new inputBoxButtons();


    public inputBox(){
        setTitle("Input Box");
        Scene scene = createUI();

        setScene(scene);
    }


    private Scene createUI(){
        VBox layout = new VBox(20);

        layout.getChildren().addAll(inputBoxTextsFields, inputBoxButtons);
        layout.setPadding(new Insets(100));
        layout.setAlignment(Pos.CENTER);

        return new Scene(layout, 350, 250);
    }
    public TextField getWordTextField(){
        return this.inputBoxTextsFields.wordTextField;
    }
    public TextField getDefinitionTextField(){
        return this.inputBoxTextsFields.definitionTextField;
    }



    public static class inputBoxTextsFields extends VBox {
        TextField wordTextField = createWordInputTextField();
        TextField definitionTextField = createDefinitionTextField();

        public inputBoxTextsFields() {
            getChildren().addAll((wordTextField), definitionTextField);
            setSpacing(20);
        }

        public TextField createDefinitionTextField() {
            TextField textField = new TextField();
            textField.setPromptText("Enter in Definition Here");
            return textField;
        }

        public TextField createWordInputTextField() {
            TextField textField = new TextField();
            textField.setPromptText("Enter in Word Here");
            return textField;
        }

    }

    private class inputBoxButtons extends VBox {
        Button StartGameButton = createStartGameButton();
        Button addWordButton =  createAddAWordButton();
        randomizeWords randomizeWords = new randomizeWords();

       JavaFXEffects javaFX = new JavaFXEffects();

        inputBoxButtons(){
            setSpacing(20);
            getChildren().addAll(addWordButton, StartGameButton);
            setAlignment(Pos.CENTER);
            setPadding(new Insets(20));
        }




        private Button createAddAWordButton() {

            Button addWordButton = new Button("Add Word");


            addWordButton.setOnAction(event -> {
                TextField wordTextField = getWordTextField();
                TextField definitionTextField = getDefinitionTextField();

                String word = wordTextField.getText();
                String definition = definitionTextField.getText();

                WordBank.getWordBank().mapWordAndDefinition(word, definition);
                WordBank.getWordBank().addToArrayList(word);

                wordTextField.setText("");
                definitionTextField.setText("");

            });

            addWordButton.setEffect(createDropShadow());

            return addWordButton;
        }
        public Button createStartGameButton() {
            Button startGame = new Button("Start game");

            startGame.setOnAction(event -> {
                randomizeWords.setRandomWord();

                setScene(new saveMan());

            });

            startGame.setEffect(createDropShadow());

            return startGame;
        }

        private DropShadow createDropShadow(){
            DropShadow dropShadow = new DropShadow();
            dropShadow.setRadius(.25);
            dropShadow.setOffsetX(4);
            dropShadow.setOffsetY(5);
            dropShadow.setColor(Color.web("#333333"));

            return dropShadow;
        }


    }
}

