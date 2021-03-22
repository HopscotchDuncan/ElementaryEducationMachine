package edu.bsu.cs222.Hangman;

import edu.bsu.cs222.Hangman.Model.GuessChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuessCheckerTest {

    GuessChecker hangmanChecker = new GuessChecker();

    @Test
    public void testIsLetterCorrect(){
        Assertions.assertTrue(hangmanChecker.checkLetter("t", "True"));
    }

    @Test
    public void testIsLetterCorrectFalse(){
        Assertions.assertFalse(hangmanChecker.checkLetter("t", "False"));
    }

    @Test
    public void testIsWordCorrectTrue(){
        Assertions.assertTrue(hangmanChecker.checkWord("Test","Test"));
    }

    @Test
    public void testIsWordCorrectFalse(){
        Assertions.assertFalse(hangmanChecker.checkWord("Yes","No"));
    }
}
