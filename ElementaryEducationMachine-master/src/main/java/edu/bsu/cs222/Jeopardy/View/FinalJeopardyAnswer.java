package edu.bsu.cs222.Jeopardy.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class FinalJeopardyAnswer extends JeopardyAnswer{

    public FinalJeopardyAnswer(String answer) {
        super(answer);
    }

    private Scene createUI(){
        VBox vBox = new VBox();
        Button close = new Button("End Game");
        close.setOnAction((event) -> close());
        vBox.getChildren().add(close);
        return new Scene(vBox);
    }
}
