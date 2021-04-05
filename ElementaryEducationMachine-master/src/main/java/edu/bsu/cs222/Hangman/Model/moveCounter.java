package edu.bsu.cs222.Hangman.Model;

import edu.bsu.cs222.Hangman.View.saveMan;

public class moveCounter {
    static int movesRemaining = 6;
    saveMan.EndGameScreen endGameScreen = new saveMan.EndGameScreen();

    public void moveChecker(){
        movesRemaining = movesRemaining - 1;
        if (movesRemaining == 0){
            endGameScreen.setLose();
            endGameScreen.show();
        }
    }
    public Integer getMovesRemaining(){
        return movesRemaining;
    }


}
