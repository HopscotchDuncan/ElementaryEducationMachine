package edu.bsu.cs222.Hangman;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GUIBeforeGame extends Application {

    StackPane stackPane = new StackPane();
    HBox layout = new HBox(20);
    VBox layout2 = new VBox(20);
    Button button = new Button("Enter");
    TextField textField = new TextField("Enter in Word/Character here");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hangman");
        button.setScaleX(1.5);
        button.setScaleY(1.5);
        layout.getChildren().addAll(textField, button);
        layout.setAlignment(Pos.BOTTOM_RIGHT);
        layout.setPadding(new Insets(50));
        stackPane.getChildren().addAll(layout, layout2);
        Scene scene = new Scene(stackPane, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
