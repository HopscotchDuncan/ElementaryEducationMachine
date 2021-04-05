package edu.bsu.cs222.Saveman.Model;

import edu.bsu.cs222.Saveman.View.SaveMan;

public class MoveCounter {
    static int movesRemaining = 6;
    SaveMan.EndGameScreen endGameScreen = new SaveMan.EndGameScreen();

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
