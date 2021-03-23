package edu.bsu.cs222.Jeopardy.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JeopardyAnswer extends Stage {

    private final Text answer;

    public JeopardyAnswer(String answer) {
        this.answer = new Text(answer);
        Scene scene = createUI();
        setScene(scene);
    }

    private Scene createUI() {
        VBox vBox = new VBox();
        Button close = new Button("Return to Board");
        close.setOnAction((event) -> close());
        vBox.getChildren().addAll(answer, close);
        return new Scene(vBox);
    }


}
