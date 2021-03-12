package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class HangmanGUIMainRobert extends Application {

    private final HangmanChecker hangmanChecker = new HangmanChecker();
    private final HangmanMaker hangmanMaker = new HangmanMaker();
    private final Button button = new Button("Guess");
    private final TextField guess = new TextField();
    private final TextField guessesLeftDisplay = new TextField();
    private final HashMap<String,String> wordBank;
    private final List<String> keys;
    private final ArrayList<String> usedKeys = new ArrayList<>();
    private String hangmanWord = "";
    private int guessesLeft = 6;
    private Circle head;
    private Line spine;
    private Line leftArm;
    private Line rightArm;
    private Line leftLeg;
    private Line rightLeg;

    public HangmanGUIMainRobert(HashMap<String,String> wordBank){
        this.wordBank = wordBank;
        keys = new ArrayList<>(wordBank.keySet());
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox outerBox = new VBox();
        outerBox.getChildren().addAll(inputBox(), button, outputBox());
        outerBox.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Hangman");
        primaryStage.setResizable(false);
        shapeSetUp(outerBox);
        getNewWord();
        buttonMainHangmanGame();
        primaryStage.setHeight(800);
        primaryStage.setWidth(1280);
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
                if(hangmanChecker.isWordCorrect(guess.getText(),hangmanWord)){
                    gameWin();
                }else{
                    guessesLeft -= 1;
                    guessesLeftDisplay.setText("Incorrect");
                    incrementHangman();
                }
            }else if(guess.getText().length()==1){
                if(hangmanChecker.isLetterCorrect(guess.getText(),hangmanWord)){
                    guessesLeftDisplay.setText("Correct Guess");
                }else{
                    guessesLeft -= 1;
                    guessesLeftDisplay.setText("Incorrect");
                    incrementHangman();
                }
            }else{
                guessesLeftDisplay.setText("No text inputted");
            }
        });
    }

    private void gameWin() {
        button.setText("Play Again?");
        guessesLeftDisplay.setText(wordBank.get(hangmanWord));
        button.setOnAction((event) -> gameReset());
    }

    private void incrementHangman(){
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
            button.setOnAction((event) -> gameReset());
        }
    }

    private String getRandomWord(){
        Random r = new Random();
        int selection = r.nextInt(keys.size());
        String blankedWord = keys.get(selection);
        usedKeys.add(keys.get(selection));
        keys.remove(keys.get(selection));
        return blankedWord;
    }

    private void gameReset(){
        guessesLeft = 6;
        getNewWord();
        buttonMainHangmanGame();
        incrementHangman();
    }

    private void getNewWord(){
        if (keys.size() <= 0) {
            //all inputted words have been used, resetting the word bank
            keys.addAll(usedKeys);
            usedKeys.clear();
        }
        hangmanWord = getRandomWord();
    }

    private HBox inputBox(){
        HBox box = new HBox();
        guess.setPromptText("Input letter or word guess");
        box.getChildren().add(guess);
        box.setAlignment(Pos.BOTTOM_CENTER);
        return box;
    }

    private HBox outputBox() {
        HBox bottomBox = new HBox();
        guessesLeftDisplay.setEditable(false);
        bottomBox.getChildren().add(guessesLeftDisplay);
        bottomBox.setAlignment(Pos.BASELINE_CENTER);
        return bottomBox;
    }
}
