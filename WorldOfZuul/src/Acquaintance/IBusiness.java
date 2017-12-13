package Acquaintance;

import Business.Game;
import java.util.List;

/**
 *
 * List of method that are used for allowing communication between the UI and the business layer
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

    void pause();

    void interactNPC();

    double getTime();

    void startTime();

    boolean miniGameConditionCheck();

    boolean miniGameRuns();

    Character miniGameGetChar();

}
