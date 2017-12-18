/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.mapHandlers;

import ui.tiles.TileEnum;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 * Dynamic map containing player only.
 * 
 * @author Jonathan
 */
public class DynamicMap {
    //todo - Delete class and add player in backgroundMap after other tiles.
    
    static HashMap<String, Image> levelMap;
    
    /**
     * Initializes a Map with player in the middle.
     */
    public DynamicMap() {
        levelMap = new HashMap<>();
        levelMap.put("55", new Image(TileEnum.PLAYER.toString()));
    }
    
    /**
     * getter for dynamical player map.
     * 
     * @return HashMap - Dynamical map containing player tile.
     */
    public static HashMap getMap() {
        return levelMap;
    }
}
