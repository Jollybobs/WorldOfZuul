/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.Tiles.Tile;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class GameMap {
    
    Map<String, Tile> levelMap;
    
    public GameMap() {
        levelMap = new HashMap<>();
        
        //levelMap.put("00", this)
    }
    
    public Map getMap() {
        return levelMap;
    }
}
