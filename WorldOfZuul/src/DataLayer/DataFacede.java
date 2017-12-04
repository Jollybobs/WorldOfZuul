/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Acquaintance.*;
import java.util.List;

/**
 *
 * @author 103020
 */
public class DataFacede implements IData {
    Data data;
    @Override
    public boolean save(List aList) {
        return data.saveGame(aList);
    }

    @Override
    public List load() {
        return data.loadGame();
    }

    @Override
    public boolean saveScore(List hList) {
        return data.saveHighscore(hList);
    }

    @Override
    public List loadScore() {
        return data.loadHighscore();
    }
    
    
    
}
