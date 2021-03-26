package edu.bsu.cs222.Jeopardy.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
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
        buttonSetUp(layout,primaryStage);
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }

    private void buttonSetUp(VBox vBox, Stage stage) {
        Button addCategory = new Button("Add category");
        Button startGame = new Button("Begin Jeopardy");
        Button excelReader = new Button("Get categories from spreadsheet and begin game");
        addCategory.setAlignment(Pos.BOTTOM_LEFT);
        startGame.setAlignment(Pos.BOTTOM_RIGHT);
        startGame.setOnAction((event) -> {
            stage.close();
            try {
                jeopardyGUI.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        vBox.getChildren().addAll(addCategory,startGame,excelReader);
    }

    private void finalJeopardyOptionSetUp(VBox vBox) {
        TextField finalJeopardyQuestion = new TextField();
        finalJeopardyQuestion.setPromptText("Enter final jeopardy question");
        TextField finalJeopardyAnswer = new TextField();
        finalJeopardyAnswer.setPromptText("Enter final jeopardy answer");
        finalJeopardyOption.setOnAction((event) -> {
            if(!finalJeopardyOption.isSelected()){
                vBox.getChildren().addAll(finalJeopardyQuestion,finalJeopardyAnswer);
            }else{
                try{
                    vBox.getChildren().removeAll(finalJeopardyQuestion,finalJeopardyAnswer);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        vBox.getChildren().add(finalJeopardyOption);
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
    }
}
