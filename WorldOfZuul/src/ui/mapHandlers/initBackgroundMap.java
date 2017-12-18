/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.mapHandlers;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 * Placeholder for references of background map.
 * 
 * @author Jonathan
 */
public class initBackgroundMap {
    
    static HashMap<String, Image> levelMap;
    
    /**
     * Initialize a background map without references.
     * will be added from serialized file when instantiated by the program.
     */
    public initBackgroundMap() {
        levelMap = new HashMap<>();
    }
    
    /**
     * getter for backgroundMap.
     * 
     * @return empty HashMap - to be populated with tile images from serialized map file, when loaded.
     */
    public static HashMap getMap() {
        return levelMap;
    }
}
