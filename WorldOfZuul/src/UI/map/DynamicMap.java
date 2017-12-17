/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.map;

import UI.Tiles.Tile;
import UI.Tiles.TileEnum;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author Jonathan
 */
public class DynamicMap {
    
    static HashMap<String, Image> levelMap;
    
    public DynamicMap() {
        levelMap = new HashMap<>();
        
//        levelMap.put("00", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("01", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("02", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("03", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("04", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("05", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("06", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("07", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("08", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("09", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("10", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("11", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("12", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("13", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("14", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("15", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("16", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("17", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("18", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("19", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("20", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("21", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("22", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("23", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("24", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("25", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("26", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("27", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("28", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("29", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("30", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("31", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("32", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("33", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("34", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("35", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("36", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("37", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("38", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("39", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("40", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("41", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("42", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("43", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("44", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("45", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("46", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("47", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("48", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("49", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("50", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("51", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("52", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("53", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("54", new Image(TileEnum.PRISONER.toString()));
        levelMap.put("55", new Image(TileEnum.PLAYER.toString()));
//        levelMap.put("56", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("57", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("58", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("59", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("60", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("61", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("62", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("63", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("64", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("65", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("66", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("67", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("68", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("69", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("70", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("71", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("72", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("73", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("74", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("75", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("76", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("77", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("78", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("79", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("80", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("81", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("82", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("83", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("84", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("85", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("86", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("87", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("88", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("89", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("90", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("91", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("92", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("93", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("94", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("95", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("96", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("97", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("98", new Image(TileEnum.PRISONER.toString()));
//        levelMap.put("99", new Image(TileEnum.PRISONER.toString()));
    }
    
    public static HashMap getMap() {
        return levelMap;
    }
}
