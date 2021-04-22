package edu.bsu.cs222.Jeopardy.Model;

import edu.bsu.cs222.Jeopardy.View.JeopardyAnswer;
import edu.bsu.cs222.Jeopardy.View.JeopardyQuestion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class Board {
    List<String> categories;
    Stage stage;

    public Board(List<String> categories, Stage stage){
        this.categories = categories;
        this.stage = stage;
    }

    public GridPane boardSetUp() {
        GridPane gridPane = new GridPane();
        for(int i = 0; i<categories.size()/11; i++){
            int parseIndex = 11 * i;
            Text Category = new Text(categories.get(parseIndex));
            stylizeCategory(Category);
            gridPane.add(Category,i,0);
            for(int j = 1; j<=9; j+=2){
                Button button = new Button();
                buttonSetUp(parseIndex, j, button);
                gridPane.add(button,i,j+1);
            }
        }
        gridPane.setAlignment(Pos.CENTER);
        if(categories.contains("Final Jeopardy")){
            finalJeopardySetUp(gridPane);
        }
        return gridPane;
    }

    private void buttonSetUp(int parseIndex, int j, Button button) {
        stylizeButton(button);
        button.setText(String.format("$%d", 200 + 200 * (j/2)));
        JeopardyAnswer jeopardyAnswer = new JeopardyAnswer(categories.get(parseIndex + j +1),"Return to board");
        JeopardyQuestion jeopardyQuestion = new JeopardyQuestion(categories.get(parseIndex + j),jeopardyAnswer);
        button.setOnAction((event) -> {
            jeopardyQuestion.show();
            button.setDisable(true);
            button.setText("");
        });
    }

    private void finalJeopardySetUp(GridPane gridPane) {
        Button skipToFinalJeopardy = new Button("To Final\nJeopardy->");
        stylizeButton(skipToFinalJeopardy);
        int finalJeopardyPosition = categories.indexOf("Final Jeopardy");
        JeopardyAnswer jeopardyAnswer = new JeopardyAnswer(categories.get(finalJeopardyPosition+2),"Finish Game");
        JeopardyQuestion jeopardyQuestion = new JeopardyQuestion(categories.get(finalJeopardyPosition+1),jeopardyAnswer);
        skipToFinalJeopardy.setOnAction((event) -> {
            jeopardyQuestion.show();
            stage.close();
        });
        gridPane.add(skipToFinalJeopardy, 5, 11);
    }

    private void stylizeCategory(Text text) {
        text.setStyle("-fx-font-size:20;" +
                "-fx-text-alignment:center;");
        text.setWrappingWidth(200);
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