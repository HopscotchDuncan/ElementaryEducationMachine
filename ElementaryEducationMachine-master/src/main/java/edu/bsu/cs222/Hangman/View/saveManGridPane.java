package edu.bsu.cs222.Hangman.View;

import edu.bsu.cs222.Hangman.Model.WordBank;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class saveManGridPane extends GridPane {

    definitionTextArea definitionTextArea = new definitionTextArea();
    saveManGuessArea saveManGuessArea = new saveManGuessArea();
    VBox hBox = new VBox();

    public saveManGridPane(){

        add(definitionTextArea,0,0,1,1);
        add(saveManGuessArea, 2, 2, 3, 3);

        setHgap(100);
        setVgap(100);

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
