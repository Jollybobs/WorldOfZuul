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

    void go(Room room);

    void play(Game game);

    void quit(Game game);

    void look(Room room);

    void goRoom(Room room);

    void move(String room);

    void waitGuard();

    boolean saveHighscore();

    List loadHighscore();

    boolean saveGame();

    void loadGame();

    void pickUpItem(Item item);

    void dropItem(Item item);

    void useItem(Item item);

    Inventory showInventory();

    void help();

    void playMiniGame();

    void pause();

    void interactNPC();

}
