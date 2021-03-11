package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class HangmanGUIMainRobert extends Application {

    private final HangmanChecker hangmanChecker = new HangmanChecker();
    private final HangmanMaker hangmanMaker = new HangmanMaker();
    private final Button button = new Button("Guess");
    private final TextField guess = new TextField();
    private final TextField guessesLeftDisplay = new TextField();
    private int guessesLeft = 6;
    private Circle head;
    private Line spine;
    private Line leftArm;
    private Line rightArm;
    private Line leftLeg;
    private Line rightLeg;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox outerBox = new VBox();
        outerBox.getChildren().addAll(inputBox(), button, outputBox());
        primaryStage.setTitle("Hangman");
        primaryStage.setResizable(false);
        shapeSetUp(outerBox);
        buttonMainHangmanGame();
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(new Scene(outerBox));
        primaryStage.show();
    }

    //sets up shapes and makes them invisible
    private void shapeSetUp(VBox vBox) {
        head = hangmanMaker.makeHead();
        spine = hangmanMaker.makeSpine();
        leftArm = hangmanMaker.makeLeftArm();
        rightArm = hangmanMaker.makeRightArm();
        leftLeg = hangmanMaker.makeLeftLeg();
        rightLeg = hangmanMaker.makeRightLeg();
        vBox.getChildren().addAll(head, spine, leftArm, rightArm, leftLeg, rightLeg);
        head.setVisible(false);
        spine.setVisible(false);
        leftArm.setVisible(false);
        rightArm.setVisible(false);
        leftLeg.setVisible(false);
        rightLeg.setVisible(false);
    }

    public void buttonMainHangmanGame(){
        button.setText("Guess");
        button.setOnAction((event) -> {
            if(guess.getText().length()>1){
                if(hangmanChecker.isWordCorrect(guess.getText(),"Test")){
                    guessesLeftDisplay.setText("Winner!");
                }else{
                    guessesLeft -= 1;
                    incrementHangman();
                }
            }else if(guess.getText().length()==1){
                if(hangmanChecker.isLetterCorrect(guess.getText(),"Test")){
                    guessesLeftDisplay.setText("Correct Guess");
                }else{
                    guessesLeft -= 1;
                    incrementHangman();
                }
            }else{
                guessesLeftDisplay.setText("No text inputted");
            }
        });
    }

    private void incrementHangman(){
        guessesLeftDisplay.setText(String.valueOf(guessesLeft));
        if (guessesLeft == 6) {
            head.setVisible(false);
            spine.setVisible(false);
            leftArm.setVisible(false);
            rightArm.setVisible(false);
            leftLeg.setVisible(false);
            rightLeg.setVisible(false);
        }else if(guessesLeft == 5){
            head.setVisible(true);
        } else if (guessesLeft == 4) {
            spine.setVisible(true);
        } else if (guessesLeft == 3) {
            leftArm.setVisible(true);
        } else if (guessesLeft == 2) {
            rightArm.setVisible(true);
        } else if (guessesLeft == 1) {
            leftLeg.setVisible(true);
        } else if (guessesLeft == 0) {
            rightLeg.setVisible(true);
            //lose the game, set the button to restart
            button.setText("Try again");
            button.setOnAction((event) -> {
                guessesLeft = 6;
                buttonMainHangmanGame();
                incrementHangman();
            });
        }
    }

    private HBox inputBox(){
        HBox box = new HBox();
        box.getChildren().addAll(new Label("Input:"), guess);
        return box;
    }

    private HBox outputBox() {
        HBox bottomBox = new HBox();
        guessesLeftDisplay.setEditable(false);
        bottomBox.getChildren().addAll(new Label("Output:"), guessesLeftDisplay);
        return bottomBox;
    }
}
