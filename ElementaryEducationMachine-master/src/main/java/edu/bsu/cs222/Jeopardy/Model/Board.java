package edu.bsu.cs222.Jeopardy.Model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Board {
    ArrayList<Category> categories;
    List<String> finalJeopardy;
    Button skipToFinalJeopardy = new Button("To Final\nJeopardy->");

    public Board(ArrayList<Category> categories, List<String> finalJeopardy){
        this.categories = categories;
        this.finalJeopardy = finalJeopardy;
    }


    //sets up one column at a time, for the full 6
    private void boardSetUp(StackPane layout, Stage stage) {
        GridPane gridPane = new GridPane();
        for(int i = 0; i<categories.size(); i++){
            Text exampleCategory = new Text("Example");
            stylizeCategory(exampleCategory);
            gridPane.add(exampleCategory,i,0);
            for(int j = 0; j<5; j++){
                Button button = new Button();
                stylizeButton(button);
                button.setText(String.format("$%d", 200 + 200*j));
                button.setOnAction((event) -> {
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
