/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesss;

import acquaintance.IBusiness;
import acquaintance.IData;
import dataLayers.DataFacede;
import static java.lang.System.currentTimeMillis;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Bruger
 */
public class BusinessFacede implements IBusiness {
    
    Game game = new Game();
    Timer timer;
    dataLayers.DataFacede data = new DataFacede();
    WallBreak wallBreak = new WallBreak();

    public void printTest(String input) {
        System.out.println("WORKS" + input);
    }

  
    //IData data;
    public void injectData(IData Data) {
        //this.data=data;
    }

    /**
     * called when a new game starts
     */
    @Override
    public void play() {
        game.createRooms();
    }

    /**
     * gets the description from the room the player is currently in
     * @return a string so it can be outputted to the player
     */
    @Override
    public String look() {
        if (Player.getCurrentRoom() == null) {
            return "You are in the void a place no man should be";
        } else {
            System.out.println("long description: " + Player.getCurrentRoom().getLongDescription() + ", get item: " + Player.getCurrentRoom().getExitString());
            return Player.getCurrentRoom().getLongDescription() + Player.getCurrentRoom().getItem();
        }
    }

    /**
     * moves the player to another room
     * @param direction to go to another room in that direction
     */
    @Override
    public void move(String direction) { 
        game.goRoom(new Command(CommandWord.GO, direction));
    }

    /**
     * lets the guard move along his patrol
     */
    @Override
    public void waitGuard() {
//        game.moveGuard();
    }

    /**
     * to save the highscore of the game in its file
     * @return 
     */
    @Override
    public boolean saveHighscore() {
        return game.saveHighscore();
    }

    @Override
    public List loadHighscore() {
        return data.loadScore();
    }

    /**
     * saves the game
     * @return a true if the save was succeful and a false if it was not
     */
    @Override
    public boolean saveGame() {
        if (game == null) {
            return false;
        } else {
            Player.setScore(currentTimeMillis() - timer.getStartTime());
            return game.saveGame();
        }
    }

    /**
     * loads the game
     */
    @Override
    public void loadGame() {
        ArrayList alist = new ArrayList((ArrayList) data.load());
        game.loadRooms(alist);
    }

    /**
     * picks up an item in the room that the player is
     * @return a true if the item was picked up succefully
     */
    @Override
    public boolean pickUpItem() {
        if (Player.getCurrentRoom().isEmpty()) {
            return false;
        } else {
            Player.getInventory().addItem(Player.getCurrentRoom().getItem());
            Player.getCurrentRoom().setItem(null);
            return true;
        }
    }

    /**
     * emptys inventory will also remove keys
     */
    @Override
    public void dropItem() {
        Player.getInventory().emptyInventory();
    }

    /**
     * uses the item that the player have in their inventory
     * @return a true if it was succesful
     */
    @Override
    public boolean useItem() {
        return false;
    }

    /**
     *
     * @return a string that contains all the items in the inventory in the
     * format: "you'r inventory contains: name, name, name, name,"
     */
    @Override
    public String showInventory() {
        return Player.getInventory().printInventory();
    }

    @Override
    public void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void interactNPC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getTime() {
        return currentTimeMillis() - timer.getStartTime();
    }

    @Override
    public void startTime() {
        timer = new Timer();
    }

    @Override
    public boolean miniGameConditionCheck() {
      return wallBreak.conditionCheck();
    }

    @Override
    public boolean miniGameRuns() {
       return wallBreak.runs();
    }

    @Override
    public String miniGameGetChar() {
    return Character.toString(wallBreak.getChar());
    }
    @Override
    public boolean checkInput(String input) {
      return  wallBreak.checkInput(input);
    }
}
