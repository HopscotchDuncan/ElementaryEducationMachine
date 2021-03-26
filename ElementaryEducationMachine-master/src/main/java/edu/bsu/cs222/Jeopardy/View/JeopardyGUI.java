package edu.bsu.cs222.Jeopardy.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JeopardyGUI extends Application {

    JeopardyAnswer exampleAnswer = new JeopardyAnswer("Example Answer");
    JeopardyQuestion exampleQuestion = new JeopardyQuestion("Example Question", exampleAnswer);
    FinalJeopardyAnswer finalJeopardyAnswer = new FinalJeopardyAnswer("Example Final Jeopardy Answer");
    JeopardyQuestion finalJeopardyQuestion = new JeopardyQuestion("Example Final Jeopardy", finalJeopardyAnswer);
    Button skipToFinalJeopardy = new Button("To Final Jeopardy->");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        VBox layout = new VBox(20);
        boardSetUp(layout, primaryStage);
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }

    //sets up one column at a time, for the full 6
    private void boardSetUp(VBox layout, Stage stage) {
        GridPane gridPane = new GridPane();
        for(int i = 0; i<6; i++){
            gridPane.add(new Text("Example"),i,0);
            for(int j = 0; j<5; j++){
                Button button = new Button();
                button.setText(String.format("$%d", 200 + 200*j));
                button.setOnAction((event) -> {
                    exampleQuestion.show();
                    button.setDisable(true);
                });
                gridPane.add(button,i,j+1);
            }
        }
        skipToFinalJeopardy.setOnAction((event) -> {
            finalJeopardyQuestion.show();
            stage.close();
        });
        gridPane.add(skipToFinalJeopardy, 6,9);
        layout.getChildren().add(gridPane);
    }
}
