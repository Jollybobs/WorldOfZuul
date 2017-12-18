/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.IBusiness;
import acquaintance.IData;
import dataLayer.DataFacade;
import static java.lang.System.currentTimeMillis;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Bruger
 */
public class BusinessFacade implements IBusiness {
    
    Game game = new Game();
    Guard guard = new Guard();
    TimeHandler timer;
    dataLayer.DataFacade data = new DataFacade();
    WallBreak wallBreak = new WallBreak();
    Player player = new Player();

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
        if (player.getCurrentRoom() == null) {
            return "You are in the void a place no man should be";
        } else {
            System.out.println("long description: " + player.getCurrentRoom().getLongDescription() + ", get item: " + player.getCurrentRoom().getExitString());
            return player.getCurrentRoom().getLongDescription() + player.getCurrentRoom().getItem();
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
        guard.stop();
    }
    
    /**
     * lets the guard move along his patrol
     */
//    @Override
    public void moveGuard() {
        guard.move();
    }

    /**
     * lets the guard move along his patrol
     */
//    @Override
    public String getGuardPosition() {
        return guard.getPosition();
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
     * @return a true if the save was successful and a false if it was not
     */
    @Override
    public boolean saveGame() {
        if (game == null) {
            return false;
        } else {
            player.setScore(currentTimeMillis() - timer.getStartTime());
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
     * @return a true if the item was picked up succesfully.
     */
    @Override
    public boolean pickUpItem() {
        System.out.println(player.getCurrentRoom());
        if (player.getCurrentRoom().isEmpty()) {
            return false;
        } else {
            player.getInventory().addItem(player.getCurrentRoom().getItem());
            player.getCurrentRoom().setItem(null);
            return true;
        }
    }

    /**
     *
     * @return a string that contains all the items in the inventory in the
     * format: "your inventory contains: name, name, name, name,"
     */
    @Override
    public String showInventory() {
        return player.getInventory().printInventory();
    }

    /**
     * Time elapsed.
     * 
     * @return time in miliseconds from game started.
     */
    @Override
    public double getTime() {
        return currentTimeMillis() - timer.getStartTime();
    }

    /**
     * Start ingame timer clock
     * 
     */
    @Override
    public void startTime() {
        timer = new TimeHandler();
    }
    
    /**
     * Not supported yet.
     */
    @Override
    public boolean useItem() {
        return false;
    }

    /**
     * Not supported yet.
     */
    @Override
    public boolean miniGameConditionCheck() {
      return wallBreak.conditionCheck();
    }

    /**
     * Not supported yet.
     */
    @Override
    public boolean miniGameRuns() {
       return wallBreak.runs();
    }

    /**
     * Not supported yet.
     */
    @Override
    public String miniGameGetChar() {
    return Character.toString(wallBreak.getChar());
    }
    
    /**
     * Not supported yet.
     */
    @Override
    public boolean checkInput(String input) {
      return  wallBreak.checkInput(input);
    }
    
    /**
     * Not supported yet.
     */
    @Override
    public void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Not supported yet.
     */
    @Override
    public void interactNPC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Not supported yet.
     */
    @Override
    public void dropItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Not supported yet.
     */
    public void injectData(IData dataInterface) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
