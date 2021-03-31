package edu.bsu.cs222.Jeopardy.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JeopardyQuestion extends Stage{
    private final JeopardyAnswer jeopardyAnswer;
    private final Label question;

    public JeopardyQuestion(String question, JeopardyAnswer jeopardyAnswer){
        this.question = new Label(question);
        this.jeopardyAnswer = jeopardyAnswer;
        Scene scene = createUI();
        setScene(scene);
    }

    private Scene createUI() {
        VBox vBox = new VBox();
        Button revealAnswer = new Button("Answer");
        revealAnswer.setOnAction((event) -> {
            close();
            jeopardyAnswer.show();
        });
        stylizeAnswer(vBox, question, revealAnswer);
        vBox.getChildren().addAll(question, revealAnswer);
        vBox.setMinSize(1000,300);
        vBox.setMaxSize(1000,600);
        vBox.setAlignment(Pos.BOTTOM_RIGHT);
        return new Scene(vBox);
    }

    private void stylizeAnswer(VBox vBox, Label label, Button button) {
        vBox.setStyle("-fx-background-color:blue;");
        label.setStyle("-fx-font-size:60;" +
                "-fx-text-fill:gold;" +
                "-fx-text-alignment:center");
        label.setWrapText(true);
        button.setMinSize(200,100);
        button.setMaxSize(200,100);
        button.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setStyle("-fx-font-size:20");
        button.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        button.setTextFill(Color.GOLD);
    }
}
