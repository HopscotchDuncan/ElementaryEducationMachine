package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class EducationalEngine extends Application {
    inputBoxHangManGui inputBoxHangManGui = new inputBoxHangManGui();

    @Override
    public void start(Stage Stage) throws Exception {
        StackPane layout = new StackPane();
        Button button = new Button("Hangman");

        button.setOnAction(event -> {
            try {
                inputBoxHangManGui.start(Stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        layout.getChildren().add(button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 450, 300);
        Stage.setScene(scene);
        Stage.show();
    }
}
