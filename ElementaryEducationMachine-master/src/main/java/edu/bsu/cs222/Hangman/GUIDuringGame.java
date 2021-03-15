package edu.bsu.cs222.Hangman;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class GUIDuringGame extends Application {

    private final GuessChecker guessChecker = new GuessChecker();
    private final DrawingCreator hangmanMaker = new DrawingCreator();
    private final Button button = new Button("Guess");
    private final TextField guess = new TextField();
    private final TextField reaction = new TextField();
    private final HashMap<String,String> wordBank;
    private final List<String> keys;
    private final ArrayList<String> usedKeys = new ArrayList<>();
    private final ArrayList<String> usedLetters = new ArrayList<>();
    private String solution;
    private int guessesLeft = 6;
    private final Label wordLabel = new Label();
    private final Label definitionLabel = new Label();
    private final Label lettersLabel = new Label();
    private Circle head;
    private Line spine;
    private Line leftArm;
    private Line rightArm;
    private Line leftLeg;
    private Line rightLeg;

    public GUIDuringGame(HashMap<String,String> wordBank){
        this.wordBank = wordBank;
        keys = new ArrayList<>(wordBank.keySet());
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        getNewWord();
        VBox outerBox = new VBox();
        outerBox.getChildren().addAll(makeInputBox(), button, makeOutputBox(), makeWordSpace(), definitionLabel, lettersLabel);
        outerBox.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Hangman");
        primaryStage.setResizable(true);
        setUpShape(outerBox);
        activateMainButton();
        primaryStage.setHeight(800);
        primaryStage.setWidth(1280);
        primaryStage.setScene(new Scene(outerBox));
        primaryStage.show();
    }

    //sets up shapes and makes them invisible
    private void setUpShape(VBox vBox) {
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

    public void activateMainButton(){
        button.setText("Guess");
        button.setOnAction((event) -> {
            if(guess.getText().length()>1){
                if(guessChecker.checkWord(guess.getText(), solution)){
                    endWinningGame();
                }else{
                    guessesLeft -= 1;
                    reaction.setText("Incorrect");
                    incrementHangman();
                }
            }else if(guess.getText().length()==1){
                if(guessChecker.checkLetter(guess.getText(), solution)){
                    reaction.setText("Correct Guess");
                    changeWordSpace(guess.getText());
                }else{
                    guessesLeft -= 1;
                    reaction.setText("Incorrect");
                    incrementHangman();
                }
            }else{
                reaction.setText("No text inputted");
            }
            usedLetters.add(guess.getText());
            makeLettersDisplay();
        });
    }

    private HBox makeInputBox(){
        HBox box = new HBox();
        guess.setPromptText("Input letter or word guess");
        box.getChildren().add(guess);
        box.setAlignment(Pos.BOTTOM_CENTER);
        return box;
    }

    private HBox makeOutputBox() {
        HBox bottomBox = new HBox();
        reaction.setEditable(false);
        bottomBox.getChildren().add(reaction);
        bottomBox.setAlignment(Pos.BASELINE_CENTER);
        return bottomBox;
    }

    private Label makeWordSpace() {
        StringBuilder wordText = new StringBuilder();
        String blankSpace = " ";
        for (int i = 0; i< solution.length(); i++){
            if (solution.charAt(i) == blankSpace.charAt(0)){
                wordText.append(" ");
            } else {
                wordText.append("_");
            }
        }
        wordLabel.setText(wordText.toString());
        return wordLabel;
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
            endLosingGame();
        }
    }

    private String getRandomWord(){
        Random r = new Random();
        int selection = r.nextInt(keys.size());
        String blankedWord = keys.get(selection);
        makeDefinitionSpace(blankedWord);
        usedKeys.add(keys.get(selection));
        keys.remove(keys.get(selection));
        return blankedWord;
    }

    private void makeDefinitionSpace(String blankedWord) {
        String definition = wordBank.get(blankedWord);
        definitionLabel.setText(definition);
    }

    private void makeLettersDisplay() {
        StringBuilder lettersList = new StringBuilder(" ");
        for (String usedLetter : usedLetters) {
            lettersList.append(" ").append(usedLetter).append(" ");
        }
        lettersLabel.setText("Used letters:" + lettersList);
    }

    private void resetGame(){
        guessesLeft = 6;
        reaction.setText("");
        getNewWord();
        wordLabel.setText("_".repeat(solution.length()));
        activateMainButton();
        incrementHangman();
    }

    private void getNewWord(){
        if (keys.size() <= 0) {
            //all inputted words have been used, resetting the word bank
            keys.addAll(usedKeys);
            usedKeys.clear();
        }
        solution = getRandomWord();
    }

    private void changeWordSpace(String guess) {
        StringBuilder wordSpace = new StringBuilder(wordLabel.getText());
        for (int i = 0; i < solution.length(); i++) {
            if (guess.charAt(0) == solution.charAt(i)) {
                wordSpace.setCharAt(i, solution.charAt(i));
            }
        }
        wordLabel.setText(wordSpace.toString());
    }

    private void endWinningGame() {
        wordLabel.setText("Congratulations! The word was " + solution + "! Hit Play Again? to start a new game or the X in the top right to close the game.");
        button.setText("Play Again?");
        reaction.setText(wordBank.get(solution));
        button.setOnAction((event) -> resetGame());
    }

    private void endLosingGame() {
        wordLabel.setText("So close! The word was " + solution + "! Hit Play Again? to start a new game or the X in the top right to close the game.");
        button.setText("Play Again?");
        reaction.setText(wordBank.get(solution));
        button.setOnAction((event) -> resetGame());
    }
}
