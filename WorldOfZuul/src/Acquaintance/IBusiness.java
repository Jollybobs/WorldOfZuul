/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import Business.Game;
import Business.Guard;
import Business.Inventory;
import Business.Item;
import Business.Room;
import java.util.List;

/**
 *
 * @author Bruger
 */
public interface IBusiness {

    void injectData(IData Data);

    void play(Game game);

    String look();

    void move(String room);

    void waitGuard();

    boolean saveHighscore();

    List loadHighscore();

    boolean saveGame();

    void loadGame();

    boolean pickUpItem();

    void dropItem();

    boolean useItem();

    String showInventory();

    void playMiniGame();

    void pause();

    void interactNPC();

}
