package edu.bsu.cs222.Jeopardy.View;

import edu.bsu.cs222.Jeopardy.Model.Board;
import edu.bsu.cs222.Jeopardy.Model.ExcelParser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

public class ExcelSelector extends Application {
    File jeopardyFile;
    Text fileName = new Text();

    @Override
    public void start(Stage primaryStage){
        VBox layout = new VBox();
        Button excelSelector = new Button("Choose Excel File");
        excelChoiceSetUp(excelSelector);
        Button startButton = new Button("Begin game with selected file");
        startButtonSetUp(startButton, primaryStage);
        layout.getChildren().addAll(excelSelector,fileName,startButton);
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }

    private void excelChoiceSetUp(Button button) {
        button.setOnAction(event -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Excel Files","xlsx", "xlsm", "xlsb", "xltx", "xltm", "xls");
            chooser.setFileFilter(filter);
            chooser.showOpenDialog(null);
            jeopardyFile = new File(chooser.getSelectedFile().getAbsolutePath());
            System.out.println(chooser.getSelectedFile().getAbsolutePath());
            fileName.setText(jeopardyFile.getName());
        });
    }

    private void startButtonSetUp(Button button, Stage stage) {
        button.setOnAction(event -> {
            if(jeopardyFile!=null){
                try{
                    ExcelParser newGame = new ExcelParser(jeopardyFile);
                    gameStart(stage, newGame);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                fileName.setText("No File Selected");
            }
        });
    }

    private void gameStart(Stage stage, ExcelParser newGame) throws IOException {
        Board jeopardyBoard = new Board(newGame.getData(),stage);
        JeopardyGUI jeopardyGUI = new JeopardyGUI(jeopardyBoard.boardSetUp());
        jeopardyGUI.start(stage);
    }
}