package edu.bsu.cs222.Jeopardy.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JeopardySettingsGUI extends Application {

    //int categoryCount = 0; //for counting how many categories have been added
    CheckBox finalJeopardyOption = new CheckBox();
    JeopardyGUI jeopardyGUI = new JeopardyGUI();

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
        Button excelReader = new Button("Get categories from spreadsheet and begin game");
        startGame.setAlignment(Pos.BOTTOM_RIGHT);
        startGame.setOnAction((event) -> {
            stage.close();
            try {
                jeopardyGUI.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        vBox.getChildren().addAll(startGame,excelReader);
    }

    private void finalJeopardyOptionSetUp(VBox vBox) {
        Text finalJeopardyPrompt = new Text("Include Final Jeopardy?");
        TextField finalJeopardyQuestion = new TextField();
        finalJeopardyQuestion.setPromptText("Enter final jeopardy question");
        TextField finalJeopardyAnswer = new TextField();
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
        TextField categoryTitle = new TextField();
        categoryTitle.setPromptText("Enter category title here");
        vBox.getChildren().add(categoryTitle);
        //TODO may have to hardcode these in for the purpose of getting them for the game
        for(int i = 0; i<5;i++){
            TextField question = new TextField();
            question.setPromptText(String.format("Enter question for $%d", 200 + 200*i));
            TextField answer = new TextField();
            answer.setPromptText(String.format("Enter answer for $%d", 200 + 200*i));
            vBox.getChildren().addAll(question,answer);
        }
        Button addCategory = new Button("Add category");
        addCategory.setAlignment(Pos.BOTTOM_LEFT);
        vBox.getChildren().add(addCategory);
    }
}
