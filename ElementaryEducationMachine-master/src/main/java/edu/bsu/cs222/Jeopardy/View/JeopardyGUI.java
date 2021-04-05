package edu.bsu.cs222.Jeopardy.View;

import edu.bsu.cs222.Jeopardy.Model.ExcelTransferer;
import edu.bsu.cs222.Jeopardy.Model.LocationFinder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class JeopardyGUI extends Application {

    ExcelTransferer transferer = new ExcelTransferer();
    LocationFinder finder = new LocationFinder();
    JeopardyQuestion question = null;
    JeopardyAnswer answer = null;
    JeopardyAnswer finalJeopardyAnswer; { try {
            finalJeopardyAnswer = new JeopardyAnswer(transferer.getExcelData(1,13), "Quit Game");
        } catch (IOException e) {
            e.printStackTrace(); }
    }
    JeopardyQuestion finalJeopardyQuestion;{
        try {
            finalJeopardyQuestion = new JeopardyQuestion(transferer.getExcelData(0,13), finalJeopardyAnswer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Button skipToFinalJeopardy = new Button("To Final\nJeopardy->");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        StackPane layout = new StackPane();
        boardSetUp(layout, primaryStage);
        layout.setStyle("-fx-background-color:blue");
        primaryStage.setScene(new Scene(layout, 1280, 800, Color.BLUE));
        primaryStage.show();
    }

    //sets up one column at a time, for the full 6
    private void boardSetUp(StackPane layout, Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
        int location = 1;
        for(int i = 0; i<6; i++){
            Text category = new Text(transferer.getExcelData(0,location));
            location += 2;
            stylizeCategory(category);
            gridPane.add(category,i,0);
            for(int j = 0; j<5; j++){
                Button button = new Button();
                stylizeButton(button);
                int categoryNumber = i+1;
                int questionAmount = 100 * j + 100;
                button.setText("Category " + categoryNumber + ":\n" + questionAmount);
                button.setOnAction((event) -> {
                    int rowLocation = finder.findRowLocation(button.getText());
                    int columnLocation = finder.findColumnLocation(button.getText());
                    try { answer = new JeopardyAnswer(transferer.getExcelData(rowLocation+1, columnLocation),
                            "Return to Board");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        question = new JeopardyQuestion(transferer.getExcelData(rowLocation, columnLocation), answer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    question.show();
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
