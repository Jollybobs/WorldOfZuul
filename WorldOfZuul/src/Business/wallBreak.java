///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Business;
//
//import java.util.Collections;
//import java.util.Stack;
//
///**
// *
// * @author Unknown
// */
//public class wallBreak {
//
//    private Stack<Character> charList;
//
//    private int winCount = 0;
//
//    /**
//     * adds Characters to the stack
//     */
//    public wallBreak() {
//        charList.add('q');
//        charList.add('w');
//        charList.add('e');
//        charList.add('a');
//        charList.add('s');
//        charList.add('d');
//        charList.add('z');
//        charList.add('x');
//        charList.add('c');
//
//    }//constructor    
//
//    /**
//     * check if the player is in the right room and has the rightr item
//     *
//     * @return
//     */
//    public boolean conditionCheck() {
//        if (Player.getInventory().checkFor( % PLACEHOLDEr %) && Player.getCurrentRoom().equals( % PLACEHOLDER %)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /**
//     * changes to false when game is won
//     *
//     * @return boolean
//     */
//    public boolean runs() {
//        if (winCount <= 9) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /**
//     * returns the char the player has to input
//     *
//     * @return character
//     */
//    public Character getChar() {
//        return charList.peek();
//    }
///**
// * checks if the input matches the displayed char
// * @param input
// * @return boolean 
// */
//    public boolean checkInput(Character input) {
//        if (input.equals(charList.peek())) {
//            charList.pop();
//            winCount++;
//            Collections.shuffle(charList);
//            return true;
//        } else {
//            Collections.shuffle(charList);
//            return false;
//        }
//    }
//
//}//c-wallBreaker
//