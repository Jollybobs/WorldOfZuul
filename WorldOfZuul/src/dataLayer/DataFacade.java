/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLayer;

import acquaintance.IData;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 103020
 */
public class DataFacade implements IData {
    Data data;
    
    /**
     * a Facade to Business Logic.
     */
    public DataFacade() {
        data = new Data();
    }
    
    /**
     * Save Game.
     * 
     * @param aList - a List of Objects to be saved.
     * @return boolean - Status of save operation.
     */
    @Override
    public boolean save(List aList) {
        return data.saveGame(aList);
    }

    /**
     * Load Game
     * 
     * @return List - A list of objects to be loaded.
     */
    @Override
    public List load() {
        return data.loadGame();
    }

    /**
     * Save HighScore
     * 
     * @param hList - a List of HighScores to be saved.
     * @return boolean - Status of save operation.
     */
    @Override
    public boolean saveScore(List hList) {
        return data.saveHighscore(hList);
    }

    /**
     * Load HighScore
     * 
     * @return hList - a List of HighScores to be loaded.
     */
    @Override
    public List loadScore() {
        return data.loadHighscore();
    }

    /**
     * Save Map
     * 
     * @param aMap - a HashMap of Map entities to be saved.
     * @return boolean - Status of save operation.
     */
    @Override
    public boolean saveMap(HashMap aMap) {
        return data.saveMap(aMap);
    }

    /**
     * Load Map
     * 
     * @param aMap - a HashMap of Map entities to be loaded.
     */
    @Override
    public HashMap loadMap() {
        return data.loadMap();
    }
    
    
    
}
