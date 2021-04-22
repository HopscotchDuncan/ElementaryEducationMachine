package edu.bsu.cs222.Jeopardy.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JeopardyGUI extends Application {

    JeopardyAnswer exampleAnswer = new JeopardyAnswer("What is an extremely long String value for both Question and Answer for the purpose of testing",
            "Return to Board");
    JeopardyQuestion exampleQuestion = new JeopardyQuestion("This is something that Robert is using to test longer questions and answers," +
            " making it possible to see both if the text aligns correctly, but if the formatting is correct.", exampleAnswer);
    JeopardyAnswer finalJeopardyAnswer = new JeopardyAnswer("Example Final Jeopardy Answer", "Quit Game");
    JeopardyQuestion finalJeopardyQuestion = new JeopardyQuestion("Example Final Jeopardy", finalJeopardyAnswer);
    Button skipToFinalJeopardy = new Button("To Final\nJeopardy->");

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

    //sets up one column at a time, for the full 6
    private void boardSetUp(StackPane layout, Stage stage) {
        GridPane gridPane = new GridPane();
        for(int i = 0; i<6; i++){
            Text exampleCategory = new Text("Example");
            stylizeCategory(exampleCategory);
            gridPane.add(exampleCategory,i,0);
            for(int j = 0; j<5; j++){
                Button button = new Button();
                stylizeButton(button);
                button.setText(String.format("$%d", 200 + 200*j));
                button.setOnAction((event) -> {
                    exampleQuestion.show();
                    button.setDisable(true);
                    button.setText("");
                });
                gridPane.add(button,i,j+1);
            }
        }
        gridPane.setAlignment(Pos.CENTER);
        finalJeopardySetUp(layout, stage, gridPane);
    }

    private void finalJeopardySetUp(StackPane layout, Stage stage, GridPane gridPane) {
        stylizeButton(skipToFinalJeopardy);
        skipToFinalJeopardy.setOnAction((event) -> {
            finalJeopardyQuestion.show();
            stage.close();
        });
        gridPane.add(skipToFinalJeopardy, 5,9);
        layout.getChildren().add(gridPane);
    }

    private void stylizeCategory(Text text) {
        text.setStyle("-fx-font-size:20;" +
                "-fx-text-alignment:center;");
        text.setFill(Color.GOLD);
    }

    private void stylizeButton(Button button) {
        button.setMinSize(200,100);
        button.setMaxSize(200,100);
        button.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setStyle("-fx-font-size:20");
        button.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        button.setTextFill(Color.GOLD);
    }
}
