package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class inputBoxHangManGui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        wordAndDefinitionMaker wordAndDefinitionMaker = new wordAndDefinitionMaker();
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

            wordAndDefinitionMaker.wordAndDefinitionMapper(word, definition);

            wordInput.setText("");
            definitionHereInput.setText("");
        });

        startGameButton.setOnAction(event -> {
            HangmanGUIMainRobert hangmanGUIMainRobert = new HangmanGUIMainRobert(wordAndDefinitionMaker.printWordAndDefinition());
            hangmanGUIMainRobert.start(primaryStage);
        });

        layout.getChildren().addAll(wordInput,definitionHereInput, addAnotherWordButton, startGameButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets( 100));

        Scene scene = new Scene(layout, 800, 500);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}