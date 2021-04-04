package edu.bsu.cs222.Hangman.View;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class JavaFXEffects {

    public DropShadow createDropShadow(){
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(.25);
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(5);
        dropShadow.setColor(Color.web("#333333"));

        return dropShadow;
    }
}
