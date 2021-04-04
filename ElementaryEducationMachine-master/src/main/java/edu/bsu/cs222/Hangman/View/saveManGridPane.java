package edu.bsu.cs222.Hangman.View;

import edu.bsu.cs222.Hangman.Model.WordBank;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class saveManGridPane extends GridPane {

    definitionTextArea definitionTextArea = new definitionTextArea();

    public saveManGridPane(){

        getChildren().add(definitionTextArea);

    }


    public static class definitionTextArea extends VBox {

        public definitionTextArea() {
            getChildren().addAll(createLabel(), createDefinitionLabel());

            setScaleX(1.6);
            setScaleY(1.6);
            setPadding(new Insets(40));
            setAlignment(Pos.BASELINE_LEFT);

        }

        private Label createDefinitionLabel(){
            Label definitionLabel = new Label();

            definitionLabel.setText(String.valueOf(WordBank.getWordBank().getDefinition()));

            return definitionLabel;
        }

        private Label createLabel(){

            return new Label("Definition: ");
            }
    }
}
