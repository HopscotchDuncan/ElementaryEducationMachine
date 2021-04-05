package edu.bsu.cs222.Jeopardy.Model;

public class LocationFinder {

    Character firstLocation = '1';
    Character secondLocation = '2';
    Character thirdLocation = '3';
    Character fourthLocation = '4';
    Character fifthLocation = '5';


    public int findColumnLocation(String buttonText){
        if (buttonText.charAt(9) == firstLocation) {
            return 1;
        } if (buttonText.charAt(9) == secondLocation) {
            return 3;
        } if (buttonText.charAt(9) == thirdLocation) {
            return 5;
        } if (buttonText.charAt(9) == fourthLocation) {
            return 7;
        } if (buttonText.charAt(9) == fifthLocation) {
            return 9;
        } else {
            return 11;
        }
    }

    public int findRowLocation(String buttonText) {
        if (buttonText.charAt(12) == firstLocation) {
            return 1;
        } if (buttonText.charAt(12) == secondLocation) {
            return 3;
        } if (buttonText.charAt(12) == thirdLocation) {
            return 5;
        } if (buttonText.charAt(12) == fourthLocation) {
            return 7;
        } else {
            return 9;
        }
    }
}
