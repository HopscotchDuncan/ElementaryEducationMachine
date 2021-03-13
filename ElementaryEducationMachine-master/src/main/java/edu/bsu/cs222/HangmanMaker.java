package edu.bsu.cs222;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class HangmanMaker {

    int hangmanSpineStartX = 200;

    public Circle makeHead() {
        Circle head = new Circle(20);
        head.setTranslateX(hangmanSpineStartX);
        return head;
    }

    public Line makeSpine() {
        Line spine = new Line();
        spine.setTranslateX(hangmanSpineStartX + 8);
        setStart(spine);
        spine.setEndX(100.0f);
        spine.setEndY(100.0f);
        return spine;
    }

    public Line makeLeftArm() {
        Line leftArm = new Line();
        leftArm.setTranslateX(hangmanSpineStartX - 2);
        leftArm.setTranslateY(-100.0f);
        setStart(leftArm);
        setEndToLeft(leftArm);
        return leftArm;
    }

    public Line makeRightArm() {
        Line rightArm = new Line();
        rightArm.setTranslateX(hangmanSpineStartX + 20);
        rightArm.setTranslateY(-200);
        setStart(rightArm);
        setEndToRight(rightArm);
        return rightArm;
    }

    public Line makeLeftLeg() {
        Line leftLeg = new Line();
        leftLeg.setTranslateX(hangmanSpineStartX - 2);
        leftLeg.setTranslateY(-206);
        setStart(leftLeg);
        setEndToLeft(leftLeg);
        return leftLeg;
    }

    public Line makeRightLeg() {
        Line rightLeg = new Line();
        rightLeg.setTranslateX(hangmanSpineStartX + 20);
        rightLeg.setTranslateY(-310);
        setStart(rightLeg);
        setEndToRight(rightLeg);
        return rightLeg;
    }

    public void setStart(Line line){
        line.setStartX(100.0f);
        line.setStartY(0);
    }

    public void setEndToLeft(Line line){
        line.setEndX(80.0f);
        line.setEndY(100.0f);
    }

    public void setEndToRight(Line line){
        line.setEndX(120.0f);
        line.setEndY(100.0f);
    }
}
