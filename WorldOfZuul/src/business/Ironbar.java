
package business;

import java.util.Collections;
import java.util.Stack;


public class Ironbar {

    private Stack<Character> charList;

    private int winCount = 0;

    /**
     * Unfinished minigame. Unsupported.
     */
    public Ironbar() {
        charList.add('w');
        charList.add('s');
        charList.add('w');
        charList.add('s');
        charList.add('w');
        charList.add('s');
        charList.add('w');
        charList.add('s');
        charList.add('w');
        charList.add('s');
        charList.add('w');
        charList.add('s');
        charList.add('w');
        charList.add('s');
        charList.add('w');
        charList.add('s');
        charList.add('w');
        charList.add('s');
        charList.add('w');
        charList.add('s');
        
        Collections.shuffle(charList);

    }//constructor    

    /**
     * Not Implemented.
     * check if the player is in the right room and has the rightr item
     *
     * @return false - method not yet implemented.
     */
    public boolean conditionCheck() {
     /* 
        
        for (Item items: Player.getInventory().getInventory()) {
            if (items.checkFor(saw) && Player.getCurrentRoom().equals("sewerExit")) {
                return true;
            } 
            else {
                return false;
            }
        }
        
        */
     
        return false;
    }
    /**
     * changes to false when game is won
     *
     * @return boolean
     */
    public boolean runs() {
        if (winCount <= 20) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * returns the char the player has to input
     *
     * @return character
     */
    public Character getChar() {
        return charList.peek();
    }
    
    /**
     * checks if the input matches the displayed char
     * @param input String of char to match.
     * 
     * @return boolean false - not yet implemented.
     */
    public boolean checkInput(String input) {
        if (input.equals(charList.peek())) {
            charList.pop();
            winCount++;
            return true;
        } else {
            return false;
        }
    }
}