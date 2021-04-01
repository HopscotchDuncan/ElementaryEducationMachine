package edu.bsu.cs222;

import edu.bsu.cs222.Hangman.View.inputBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class EducationalEngine extends Application {
    inputBox inputBox = new inputBox();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = createHangmanButton(primaryStage);
        VBox vbox = new VBox(20);

        vbox.getChildren().add(button);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 150, 150);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Button createHangmanButton(Stage stage){
        Button button = new Button("Save Man");

        button.setOnAction(e ->{
            stage.close();
            inputBox.show();
        });

        return button;
    }
}
