
package Business;

import java.util.Collections;
import java.util.Stack;


public class Ironbar {

    private Stack<Character> charList;

    private int winCount = 0;

    /**
     * adds Characters to the stack
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
     * check if the player is in the right room and has the rightr item
     *
     * @return
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
 * @param input
 * @return boolean 
 */
    public boolean checkInput(String input) {
        if (input.equals(charList.peek())) {
            charList.pop();
            winCount++;
            Collections.shuffle(charList);
            return true;
        } else {
            Collections.shuffle(charList);
            return false;
        }
    }

}//c-wallBreaker