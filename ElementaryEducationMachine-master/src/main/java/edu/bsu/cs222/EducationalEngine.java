package edu.bsu.cs222;

import edu.bsu.cs222.Hangman.View.inputBox;
import edu.bsu.cs222.Jeopardy.View.JeopardyGUI;
import edu.bsu.cs222.Jeopardy.View.JeopardySettingsGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EducationalEngine extends Application {
    inputBox inputBox = new inputBox();
    JeopardySettingsGUI jeopardySettingsGUI = new JeopardySettingsGUI();

    @Override
    public void start(Stage primaryStage){
        Button button = createHangmanButton(primaryStage);
        Button button2 = createJeopardyButton(primaryStage);
        VBox vbox = new VBox(20);

        vbox.getChildren().add(button);
        vbox.getChildren().add(button2);

        Scene scene = new Scene(vbox, 100, 100);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createHangmanButton(Stage stage){
        Button button = new Button("Hangman");

        button.setOnAction(e ->{
            stage.close();
            inputBox.show();
        });

        return button;
    }

    private Button createJeopardyButton(Stage stage){
        Button button = new Button("Jeopardy");

        button.setOnAction(e ->{
            stage.close();
            try {
                jeopardySettingsGUI.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        return button;
    }
}
