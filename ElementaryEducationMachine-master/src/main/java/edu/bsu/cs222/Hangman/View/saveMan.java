package edu.bsu.cs222.Hangman.View;

import edu.bsu.cs222.Hangman.Model.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class saveMan extends Scene {

    public saveMan(){

        super(new saveManGridPane(), 700,700);

    }


    public static class EndGameScreen extends Stage {

        Button playAgainButton = new Button("Play again");
        Label congratsLabel = new Label("Congrats you got the Word correct");

        edu.bsu.cs222.Hangman.Model.randomizeWords randomizeWords = new randomizeWords();

        public EndGameScreen(){
            setPlayAgainButton();

            VBox layout = new VBox(30);
            layout.getChildren().addAll(congratsLabel, playAgainButton);
            layout.setPadding(new Insets(20));
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout, 250 ,250);
            setScene(scene);

        }

        private void setPlayAgainButton() {

            playAgainButton.setOnAction(e ->{
                randomizeWords.setRandomWord();
                setScene(new saveMan());
            });
        }

        public void setLose() {
            congratsLabel.setText("You did not guess the correct word");
        }
    }

    public static class saveManGridPane extends GridPane {

        saveManGridPane.definitionTextArea definitionTextArea = new definitionTextArea();
        saveManGridPane.saveManGuessArea saveManGuessArea = new saveManGuessArea();
        saveManGridPane.saveManWordSpace saveManWordSpace = new saveManWordSpace();
        edu.bsu.cs222.Hangman.Model.wordSpaceMaker wordSpaceMaker = new wordSpaceMaker();
        saveManGridPane.usedLettersArea usedLettersArea = new usedLettersArea();
        saveManGridPane.saveManManDisplay saveManManDisplay = new saveManManDisplay();

        public saveManGridPane(){


            add(definitionTextArea,0,0,1,1);
            add(usedLettersArea,0,1,1,1);
            add(saveManWordSpace, 0,2,1,1);
            add(saveManGuessArea, 3, 2, 1, 1);
            add(saveManManDisplay,2,1,1,1 );

            usedLettersArea.setTranslateY(-70);

            saveManManDisplay.setTranslateX(150);

            saveManWordSpace.setTranslateY(-200);
            saveManWordSpace.setTranslateX(150);

            saveManGuessArea.setTranslateX(175);
            saveManGuessArea.setTranslateY(-30);

        }


        public static class definitionTextArea extends VBox {

            public definitionTextArea() {
                getChildren().addAll(createLabel(), createDefinitionLabel());

                setScaleX(1.6);
                setScaleY(1.6);
                setPadding(new Insets(40));
                setAlignment(Pos.TOP_LEFT);

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

        public class saveManGuessArea extends HBox {

            GuessChecker guessChecker = new GuessChecker();
            TextField guessTextField = new TextField();
            saveMan.EndGameScreen EndGameScreen = new EndGameScreen();
            edu.bsu.cs222.Hangman.Model.moveCounter moveCounter = new moveCounter();

            public saveManGuessArea(){
                setSpacing(20);
                setAlignment(Pos.BOTTOM_RIGHT);

                setTextArea();
                getChildren().addAll(guessTextField, createEnterInButton());

            }

            private Button createEnterInButton(){

                Button button = new Button("Check Answer");

                button.setOnAction(e -> {
                    String guess = guessTextField.getText();
                    boolean check = guessChecker.guessCheck(guess);

                    if (guess.length() == 1) {
                        if (check) {
                            String word = String.valueOf(wordSpaceMaker.replaceDashesWithLetters(guess));

                            saveManWordSpace.changeWordSpace(word);
                        } else {
                            usedLettersArea.setUsedLetter(usedLettersArea.addtoUsedLetters(guess));
                            moveCounter.moveChecker();
                            saveManManDisplay.saveManIncrementer(moveCounter.getMovesRemaining());
                        }
                    } else if (check) {
                        EndGameScreen.show();
                    } else {
                        moveCounter.moveChecker();
                        saveManManDisplay.saveManIncrementer(moveCounter.getMovesRemaining());

                        guessTextField.setText("");
                    }
                });


                return button;
            }

            private void setTextArea(){
                guessTextField.setPromptText("Enter in Word or Letter");
            }

        }

        public class saveManManDisplay extends VBox {
            DrawingCreator drawingCreator = new DrawingCreator();
            Circle head;
            Line spine;
            Line leftArm;
            Line rightArm;
            Line leftLeg;
            Line rightLeg;

            public saveManManDisplay() {
                head = drawingCreator.makeHead();
                spine = drawingCreator.makeSpine();
                leftArm = drawingCreator.makeLeftArm();
                rightArm = drawingCreator.makeRightArm();
                leftLeg = drawingCreator.makeLeftLeg();
                rightLeg = drawingCreator.makeRightLeg();
                getChildren().addAll(head, spine, leftArm, rightArm, leftLeg, rightLeg);

                head.setVisible(true);
                spine.setVisible(true);
                leftArm.setVisible(true);
                rightArm.setVisible(true);
                leftLeg.setVisible(true);
                rightLeg.setVisible(true);
            }

            public void saveManIncrementer(Integer guessesLeft) {
                if (guessesLeft == 5) {
                    rightLeg.setVisible(false);
                } else if (guessesLeft == 4) {
                    leftLeg.setVisible(false);
                } else if (guessesLeft == 3) {
                    leftArm.setVisible(false);
                } else if (guessesLeft == 2) {
                    rightArm.setVisible(false);
                } else if (guessesLeft == 1) {
                    spine.setVisible(false);
                } else if (guessesLeft == 0) {
                    head.setVisible(false);
                }

            }
        }

        public class saveManWordSpace extends HBox {
            wordSpaceMaker wordSpaceMaker = new wordSpaceMaker();

            Label wordSpacelabel = new Label();

            public saveManWordSpace(){

                WordSpaceLabel();

                getChildren().add(wordSpacelabel);
                setAlignment(Pos.BASELINE_CENTER);

            }

            public void WordSpaceLabel(){

                wordSpacelabel.setText(String.valueOf(wordSpaceMaker.createDashes()));

                wordSpacelabel.setScaleX(3);
                wordSpacelabel.setScaleY(2.5);

            }
            public void changeWordSpace(String stringBuilder){
                wordSpacelabel.setText(String.valueOf(stringBuilder));
            }


        }

        public static class usedLettersArea extends VBox {
            String usedLetters = "";
            Label label = new Label("Used Letters: ");
            Label usedLettersLabel = new Label();

            public usedLettersArea(){
                setSpacing(20);

                getChildren().addAll(label, usedLettersLabel);
                setScaleX(1.5);
                setScaleY(1.5);

                setAlignment(Pos.CENTER);
                setPadding(new Insets(10));
            }
            public void setUsedLetter(String UsedLetters){
                usedLettersLabel.setText(UsedLetters);
            }
            public String addtoUsedLetters(String usedletter){
                return usedLetters = usedLetters + usedletter + " ";
            }

        }
    }
}
