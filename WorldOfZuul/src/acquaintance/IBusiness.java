package acquaintance;

import business.Game;
import java.util.List;

/**
 *
 * List of method that are used for allowing communication between the UI and the business layer
 */
public interface IBusiness {

    boolean checkInput(String input);
    
    void injectData(IData Data);

    void play();

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

    String miniGameGetChar();

}
