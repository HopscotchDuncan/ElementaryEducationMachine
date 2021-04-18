package edu.bsu.cs222.Jeopardy.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JeopardyGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        StackPane layout = new StackPane();
        boardSetUp(layout, primaryStage);
        layout.setStyle("-fx-background-color:blue");
        primaryStage.setScene(new Scene(layout, 1280, 800, Color.BLUE));
        primaryStage.show();
    }
}
