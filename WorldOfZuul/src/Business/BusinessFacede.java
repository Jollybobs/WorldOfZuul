/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Bruger
 */
public class BusinessFacede implements IBusiness {
    
    Game game;

    public void PrintTest(String input) {
        System.out.println("WORKS"+input);
    }

  
    IData data;
    public void InjectData(IData Data) {
        this.data=data;
    }

    @Override
    public void go(Room room) {
        
    }

    @Override
    public void play(Game game) {
        this.game = new Game();
    }

    @Override
    public void quit(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void look(Room room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goRoom(Room room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(Room room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void waitGuard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            return game.saveGame();
        }
    }
    
    @Override
    public void loadGame() {
        ArrayList alist = new ArrayList((ArrayList)data.load());
        game.loadRooms(alist);
    }

    @Override
    public void pickUpItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dropItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void useItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void help() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
