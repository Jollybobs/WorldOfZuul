/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.*;
import static java.lang.System.currentTimeMillis;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Bruger
 */
public class BusinessFacede implements IBusiness {
    
    Game game;
    Timer timer;

    public void printTest(String input) {
        System.out.println("WORKS"+input);
    }

  
    IData data;
    public void injectData(IData Data) {
        this.data=data;
    }

    @Override
    public void play(Game game) {
        this.game = new Game();
    }

    @Override
    public String look() {
        if (Player.getCurrentRoom() == null) {
            return "You are in the void";
        } else {
            return Player.getCurrentRoom().getLongDescription();
        }
    }

    @Override
    public void move(String room) {
//        game.goRoom(new Command(CommandWord.GO, room));
    }

    @Override
    public void waitGuard() {
        game.moveGuard();
    }

    @Override
    public boolean saveHighscore() {
        return game.saveHighscore();
    }
    
    @Override
    public List loadHighscore() {
        return data.loadScore();
    }

    @Override
    public boolean saveGame() {
        if (game == null) {
            return false;
        } else {
            Player.setScore(currentTimeMillis()-timer.getStartTime);
            return game.saveGame();
        }
    }
    
    @Override
    public void loadGame() {
        ArrayList alist = new ArrayList((ArrayList)data.load());
        game.loadRooms(alist);
    }

    @Override
    public boolean pickUpItem() {
        if (Player.getCurrentRoom().isEmpty()) {
            return false;
        } else {
            Player.addItemInventory(Player.getCurrentRoom().getItem());
            Player.getCurrentRoom().setItem(null);
            return true;
        }
    }

    @Override
    public boolean dropItem() {
        //TODO: gøre så man kan fjerne et eller alle items fra inventory uden at sige hvilke det skal være
        Player.dropAll();
        return false;
    }

    @Override
    public boolean useItem() {
        return false;
    }

    @Override
    public Inventory showInventory() {
        return Player.getInventory();
    }

    @Override
    public void playMiniGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public double getTime(){
        return currentTimeMillis()- timer.getStartTime();
    }
    
    @Override
    public void startTime(){
        timer = new Timer();
    }
}
