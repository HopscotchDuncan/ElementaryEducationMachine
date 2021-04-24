package edu.bsu.cs222.Jeopardy.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JeopardyChoice extends Application {
    JeopardyManualInput jeopardyManualInput = new JeopardyManualInput();
    ExcelSelector excelSelector = new ExcelSelector();

    @Override
    public void start(Stage primaryStage) {
        Button saveManButton = createManualInputButton(primaryStage);
        Button jeopardyButton = createExcelInputButton(primaryStage);
        VBox vbox = new VBox(20);
        vbox.getChildren().add(saveManButton);
        vbox.getChildren().add(jeopardyButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createManualInputButton(Stage stage){
        Button button = new Button("Create Game Manually");
        button.setOnAction(e ->{
            stage.close();
            try {
                jeopardyManualInput.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        return button;
    }

    private Button createExcelInputButton(Stage stage){
        Button button = new Button("Get Game From\nExcel Document");
        button.setOnAction(e -> {
            stage.close();
            try {
                excelSelector.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        return button;
    }
}