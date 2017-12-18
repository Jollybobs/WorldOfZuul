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
    
    public DynamicMap() {
        levelMap = new HashMap<>();
        levelMap.put("55", new Image(TileEnum.PLAYER.toString()));
    }
    
    public static HashMap getMap() {
        return levelMap;
    }
}
