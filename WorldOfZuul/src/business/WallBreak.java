package business;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author Unknown
 */
public class WallBreak {

    private Stack<Character> charList = new Stack();

    private int winCount = 0;

    /**
     * adds Characters to the stack
     */
    public WallBreak() {
        charList.add('q');
        charList.add('w');
        charList.add('e');
        charList.add('a');
        charList.add('s');
        charList.add('d');
        charList.add('z');
        charList.add('x');
        charList.add('c');
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
            if (items.checkFor(hammer_Chisel) && Player.getCurrentRoom().equals("Cell")) {
                return true;
            } else {
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
        return winCount <= 9;
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
     *
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