package edu.bsu.cs222.Jeopardy.View;

import edu.bsu.cs222.Jeopardy.Model.Board;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class JeopardyManualInput extends Application {

    CheckBox finalJeopardyOption = new CheckBox();
    TextField categoryTitle = new TextField();
    TextField question200 = new TextField();
    TextField answer200 = new TextField();
    TextField question400 = new TextField();
    TextField answer400 = new TextField();
    TextField question600 = new TextField();
    TextField answer600 = new TextField();
    TextField question800 = new TextField();
    TextField answer800 = new TextField();
    TextField question1000 = new TextField();
    TextField answer1000 = new TextField();
    TextField[] fullCategory = new TextField[]{categoryTitle,question200,answer200,question400,answer400,
            question600,answer600,question800,answer800,question1000,answer1000};
    TextField finalJeopardyQuestion = new TextField();
    TextField finalJeopardyAnswer = new TextField();
    TextField[] finalJeopardy = new TextField[]{finalJeopardyQuestion, finalJeopardyAnswer};
    List<String> categories = new ArrayList<>();

    @Override
    public void start(Stage primaryStage){
        VBox layout = new VBox();
        settingsSetUp(layout);
        finalJeopardyOptionSetUp(layout);
        gameStartSetUp(layout,primaryStage);
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }

    private void gameStartSetUp(VBox vBox, Stage stage) {
        Button startGame = new Button("Begin Jeopardy");
        startGame.setAlignment(Pos.BOTTOM_RIGHT);
        startGame.setOnAction((event) -> {
            finalJeopardyCheck();
            try {
                Board jeopardyBoard = new Board(categories, stage);
                JeopardyGUI jeopardyGUI = new JeopardyGUI(jeopardyBoard.boardSetUp());
                jeopardyGUI.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        vBox.getChildren().addAll(startGame);
    }

    private void finalJeopardyCheck() {
        if(finalJeopardyOption.isSelected()){
            nullCatcher(finalJeopardy);
            categories.add("Final Jeopardy");
            categories.add(finalJeopardyQuestion.getText());
            categories.add(finalJeopardyAnswer.getText());
        }
    }

    private void finalJeopardyOptionSetUp(VBox vBox) {
        Text finalJeopardyPrompt = new Text("Include Final Jeopardy?");
        finalJeopardyQuestion.setPromptText("Enter final jeopardy question");
        finalJeopardyAnswer.setPromptText("Enter final jeopardy answer");
        finalJeopardyOption.setSelected(true);
        finalJeopardyOption.setOnAction((event) -> {
            if(finalJeopardyOption.isSelected()){
                finalJeopardyQuestion.setVisible(true);
                finalJeopardyAnswer.setVisible(true);
            }else{
                finalJeopardyQuestion.setVisible(false);
                finalJeopardyAnswer.setVisible(false);
            }
        });
        vBox.getChildren().addAll(finalJeopardyPrompt, finalJeopardyOption, finalJeopardyQuestion, finalJeopardyAnswer);
    }

    private void settingsSetUp(VBox vBox) {
        categoryTitle.setPromptText("Enter Category Title");
        for(int i = 1; i<fullCategory.length; i+=2){
            fullCategory[i].setPromptText(String.format("Enter The %d Question", 200 + 200 * (i/2)));
            fullCategory[i+1].setPromptText(String.format("Enter The %d Answer", 200 + 200 * (i/2)));
        }
        vBox.getChildren().addAll(categoryTitle, question200, answer200, question400, answer400, question600,
                answer600, question800, answer800, question1000, answer1000);
        Button addCategory = new Button("Add category");
        addCategorySetUp(addCategory);
        addCategory.setAlignment(Pos.BOTTOM_LEFT);
        vBox.getChildren().add(addCategory);
    }

    private void addCategorySetUp(Button button) {
        button.setOnAction(event -> {
            try{
                nullCatcher(fullCategory);
                for(TextField t : fullCategory){
                    categories.add(t.getText());
                    t.clear();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    private void nullCatcher(TextField[] textFields) {
        for(TextField t : textFields){
            if(t.getText().isEmpty()){
                throw new NullPointerException();
            }
        }
    }
}