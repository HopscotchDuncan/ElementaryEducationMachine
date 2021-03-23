package edu.bsu.cs222.Jeopardy.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JeopardyQuestion extends Stage{
    private final JeopardyAnswer jeopardyAnswer;
    Text question;

    public JeopardyQuestion(String question, JeopardyAnswer jeopardyAnswer){
        this.question = new Text(question);
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
        vBox.getChildren().addAll(question, revealAnswer);
        return new Scene(vBox);
    }
}
