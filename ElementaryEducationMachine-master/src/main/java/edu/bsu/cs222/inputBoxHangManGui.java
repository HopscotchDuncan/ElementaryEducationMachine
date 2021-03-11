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

    HangmanGUIMainRobert hangmanGUIMainRobert = new HangmanGUIMainRobert();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        wordAndDefinitionMaker wordAndDefinitionMaker = new wordAndDefinitionMaker();
        VBox layout = new VBox(20);
        primaryStage.setTitle("Word Box");

        TextField wordInput = new TextField("Enter in Word here");
        TextField definitionHereInput = new TextField("Enter in Definition Here");
        Button addAnotherWordButton = new Button("Add another Word");
        Button startGameButton = new Button("Start Game");

        addAnotherWordButton.setOnAction(event -> {
            String word = wordInput.getText();
            String definition = definitionHereInput.getText();

            /*wordAndDefinitionMaker.wordListMaker(word);
            wordAndDefinitionMaker.definitionListMaker(definition);*/

            wordAndDefinitionMaker.wordAndDefinitionMapper(word, definition);

            wordInput.setText("");
            definitionHereInput.setText("");
        });

        startGameButton.setOnAction(event -> {
            String word = wordInput.getText();
            String definition = definitionHereInput.getText();

            /*wordAndDefinitionMaker.wordListMaker(word);
            wordAndDefinitionMaker.definitionListMaker(definition);

            wordAndDefinitionMaker.printWordsList();
            wordAndDefinitionMaker.printDefinitionList();*/
            wordAndDefinitionMaker.wordAndDefinitionMapper(word, definition);
            wordAndDefinitionMaker.printWordAndDefinition();

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