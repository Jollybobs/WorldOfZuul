/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Scanner;

/**
 *
 * @author paul
 */
    public class Minigame { //blueprint
    
    private String game;
    private boolean isQUsed = false;
    private boolean isWUsed = false;
    private boolean isEUsed = false;
    private boolean isAUsed = false;
    private boolean isSUsed = false;
    private boolean isDUsed = false;
    private boolean isZUsed = false;
    private boolean isXUsed = false;
    private boolean isCUsed = false;
    
    public Minigame(String game) {
        this.game = game;      
    }
    
    private String getRandomLetter() {
        int number = (int)Math.ceil(Math.random() * 9);
        switch (number) {
            case 1:
                return "q";
            case 2:
                return "w";
            case 3:
                return "e";
            case 4:
                return "a";
            case 5:
                return "s";
            case 6:
                return "d";
            case 7:
                return "z";
            case 8:
                return "x";
            case 9:
                return "c";
        }
        return "l";
    }
    
    private boolean checkIfLetterIsUsed(String letter) {
        switch (letter) {
            case "q":
                if (isQUsed == true) {
                    return true;
                }
                else {
                    isQUsed = true;
                    return false;
                }
            case "w":
                if (isWUsed == true) {
                    return true;
                }
                else {
                    isWUsed = true;
                    return false;
                }
            case "e":
                if (isEUsed == true) {
                    return true;
                }
                else {
                    isEUsed = true;
                    return false;
                }
            case "a":
                if (isAUsed == true) {
                    return true;
                }
                else {
                    isAUsed = true;
                    return false;
                }
            case "s":
                if (isSUsed == true) {
                    return true;
                }
                else {
                    isSUsed = true;
                    return false;
                }
            case "d":
                if (isDUsed == true) {
                    return true;
                }
                else {
                    isDUsed = true;
                    return false;
                }
            case "z":
                if (isZUsed == true) {
                    return true;
                }
                else {
                    isZUsed = true;
                    return false;
                }
            case "x":
                if (isXUsed == true) {
                    return true;
                }
                else {
                    isXUsed = true;
                    return false;
                }
            case "c":
                if (isCUsed == true) {
                    return true;
                }
                else {
                    isCUsed = true;
                    return false;
                }
            default:
                break;
        }          
        return false;
        
    }
    
    private void letterNotUsed(String letter){
        switch (letter) {
            case "q":
                isQUsed = false;
            case "w":
                isWUsed = false;
            case "e":
                isEUsed = false;
            case "a":
                isAUsed = false;
            case "s":
                isSUsed = false;
            case "d":
                isDUsed = false;
            case "z":
                isZUsed = false;
            case "x":
                isXUsed = false;
            case "c":
                isCUsed = false;
            default:
                break;
        }          
        
    }
    
    private boolean wallBreaker() {
    boolean findingNewLetter;
    String randomLetter = null;
    Scanner input = new Scanner(System.in);
    int amountOfRights = 0;
        while(true){
            findingNewLetter = true;
            while(findingNewLetter){
                randomLetter = getRandomLetter();
                if (checkIfLetterIsUsed(randomLetter)) {
                    findingNewLetter = true;
                }
                else {
                    findingNewLetter = false;
                }
            }
            System.out.println("Type in " + randomLetter + ".");
            String justWritten = input.next();
            if (justWritten.equals(randomLetter)) {
                amountOfRights++;
            }
            else {
                letterNotUsed(randomLetter);
            }
            if (amountOfRights == 9) {
                return true;
            }
        }
    }
    
    public boolean startGame() {
        
        if (game.equals("wallBreaker")) {
            if (wallBreaker()) {
                return true;
            }
        }
        else if(game.equals("ironBar")) {
            if (ironBar()) {
                return true;
            }
        }
        return false;
    }
    
    private boolean ironBar() {
        Scanner input = new Scanner(System.in);
        String justWritten;
        String wantedLetter;
        int amountOfRights = 0;
        while(true){
            for (int i = 0 ;; i++) {
                if (i%2 == 0) {
                    System.out.println("Type in W");
                    wantedLetter = "w";
                }
                else {
                    System.out.println("Type in S");
                    wantedLetter = "s";
                }
                justWritten = input.next();
                if (justWritten.equals(wantedLetter)) {
                    amountOfRights++;
                }
                else {
                    i--;
                }
                if (amountOfRights == 20) {
                    return true;
                }
            }  
        }
    }
}