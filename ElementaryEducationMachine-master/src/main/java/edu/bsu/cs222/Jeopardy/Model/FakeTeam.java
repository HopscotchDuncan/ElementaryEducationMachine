package edu.bsu.cs222.Jeopardy.Model;

public class FakeTeam {

    private final String name;
    private int score;

    public FakeTeam(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int setScore(int increment){
        return this.score += increment;
    }
}
