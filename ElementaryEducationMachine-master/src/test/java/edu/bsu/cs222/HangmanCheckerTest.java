package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HangmanCheckerTest {

    HangmanChecker hangmanChecker = new HangmanChecker();

    @Test
    public void testIsLetterCorrect(){
        Assertions.assertTrue(hangmanChecker.isLetterCorrect("t", "True"));
    }

    @Test
    public void testIsLetterCorrectFalse(){
        Assertions.assertFalse(hangmanChecker.isLetterCorrect("t", "False"));
    }

    @Test
    public void testIsWordCorrectTrue(){
        Assertions.assertTrue(hangmanChecker.isWordCorrect("Test","Test"));
    }

    @Test
    public void testIsWordCorrectFalse(){
        Assertions.assertFalse(hangmanChecker.isWordCorrect("Yes","No"));
    }
}
