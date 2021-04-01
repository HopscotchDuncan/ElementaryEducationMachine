package edu.bsu.cs222.Hangman.View;

import edu.bsu.cs222.Hangman.Model.WordBank;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class inputBox2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        WordBank wordAndDefinitionMaker = new WordBank();
        VBox layout = new VBox(20);
        primaryStage.setTitle("Word Box");
        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter in Word here");
        TextField definitionHereInput = new TextField();
        definitionHereInput.setPromptText("Enter in Definition Here");
        Button addAnotherWordButton = new Button("Add Word");
        Button startGameButton = new Button("Start Game");

        addAnotherWordButton.setOnAction(event -> {
            String word = wordInput.getText();
            String definition = definitionHereInput.getText();
            wordAndDefinitionMaker.mapWordAndDefinition(word, definition);
            wordInput.setText("");
            definitionHereInput.setText("");
        });

        startGameButton.setOnAction(event -> {
           // hangmanMain guiDuringGame = new hangmanMain(wordAndDefinitionMaker.getWordAndDefinition());
            //guiDuringGame.start(primaryStage);
        });
        layout.getChildren().addAll(wordInput,definitionHereInput, addAnotherWordButton, startGameButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets( 100));

        Scene scene = new Scene(layout, 800, 500);
        scene.getStylesheets().add("vector.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
