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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        VBox layout = new VBox(20);
        boardSetUp(layout);
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }

    //sets up one column at a time, for the full 6
    private void boardSetUp(VBox layout) {
        GridPane gridPane = new GridPane();
        for(int i = 0; i<6; i++){
            gridPane.add(new Text("Example"),i,0);
            for(int j = 0; j<5; j++){
                Button button = new Button();
                button.setText("$200");
                button.setOnAction((event) -> {
                    exampleQuestion.show();
                    button.setDisable(true);
                });
                gridPane.add(button,i,j+1);
            }
        }
        layout.getChildren().add(gridPane);
    }
}
