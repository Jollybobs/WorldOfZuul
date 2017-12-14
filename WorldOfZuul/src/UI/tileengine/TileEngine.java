/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.tileengine;

import Business.BusinessFacede;
import DataLayer.DataFacede;
import UI.DynamicMap;
import UI.Tiles.TileEnum;
import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author jollybob
 */
public class TileEngine {
    
    BusinessFacede bfacade;
    
    int intX;
    int intY;
    HashMap<String, ImageView> levelMap;
    HashMap<String, String> backgroundMap;
    HashMap<String, Image> dynamicMap;
    DataFacede data;
    
    public TileEngine(HashMap<String, ImageView> lvlMap) {
        intX = 7;
        intY = 12;
        bfacade = new BusinessFacede();
        DynamicMap dm = new DynamicMap();
        dynamicMap = dm.getMap();
        data = new DataFacede();
        levelMap = lvlMap;
        backgroundMap = data.loadMap();
        redrawViewPort();
    }
        
    public void moveMap(int x, int y) {
        
        int roomX = intX%5;
        int roomY = intY%5;
        
//        System.out.println("roomX: " + roomX + "roomY: " + roomY);
        
        String tile;
        // Check tile before move.
        if (x > 0) {
            tile = backgroundMap.get(checkPlacementString(1, 0));
            if (!(tile.equals(TileEnum.BACKGROUND.toString()) || tile.equals(TileEnum.GRASS.toString()) || tile.equals(TileEnum.SEWER_FLOOR.toString()) || tile.equals(TileEnum.LADDER_WALL.toString()))) {
                if ((tile.equals(TileEnum.Key.toString()))) {
                    backgroundMap.put(checkPlacementString(1, 0), TileEnum.BACKGROUND.toString());
                } else if ((tile.equals(TileEnum.HAMMER_CHISEL.toString()))) {
                    backgroundMap.put(checkPlacementString(1, 0), TileEnum.BACKGROUND.toString());
                } else {
                    return;
                }
            }
        } else if (x < 0) {
            tile = backgroundMap.get(checkPlacementString(-1, 0));
            if (!(tile.equals(TileEnum.BACKGROUND.toString()) || tile.equals(TileEnum.GRASS.toString()) || tile.equals(TileEnum.SEWER_FLOOR.toString()) || tile.equals(TileEnum.LADDER_WALL.toString()))) {
                if ((tile.equals(TileEnum.Key.toString()))) {
                    backgroundMap.put(checkPlacementString(-1, 0), TileEnum.BACKGROUND.toString());
                } else if ((tile.equals(TileEnum.HAMMER_CHISEL.toString()))) {
                    backgroundMap.put(checkPlacementString(-1, 0), TileEnum.BACKGROUND.toString());
                } else {
                    return;
                }
            }
        } else if (y > 0) {
            tile = backgroundMap.get(checkPlacementString(0, 1));
            if (!(tile.equals(TileEnum.BACKGROUND.toString()) || tile.equals(TileEnum.GRASS.toString()) || tile.equals(TileEnum.SEWER_FLOOR.toString()) || tile.equals(TileEnum.LADDER_WALL.toString()))) {
                if ((tile.equals(TileEnum.Key.toString()))) {
                    backgroundMap.put(checkPlacementString(0, 1), TileEnum.BACKGROUND.toString());
                } else if ((tile.equals(TileEnum.HAMMER_CHISEL.toString()))) {
                    backgroundMap.put(checkPlacementString(0, 1), TileEnum.BACKGROUND.toString());
                } else {
                    return;
                }
            }
        } else {
            tile = backgroundMap.get(checkPlacementString(0, -1));
            if (!(tile.equals(TileEnum.BACKGROUND.toString()) || tile.equals(TileEnum.GRASS.toString()) || tile.equals(TileEnum.SEWER_FLOOR.toString()) || tile.equals(TileEnum.LADDER_WALL.toString()))) {
                if ((tile.equals(TileEnum.Key.toString()))) {
                    backgroundMap.put(checkPlacementString(0, -1), TileEnum.BACKGROUND.toString());
                } else if ((tile.equals(TileEnum.HAMMER_CHISEL.toString()))) {
                    backgroundMap.put(checkPlacementString(0, -1), TileEnum.BACKGROUND.toString());
                } else {
                    return;
                }
            }
        }
        if (-4 < intX && intX < 23 || x > 0 && intX < -3 || x < 0 && intX > 22) {
            intX = intX + x;
        }
        if (-4 < intY && intY < 13 || y > 0 && intY < -3 || y < 0 && intY > 12) {
            intY = intY + y;
        }
        
        roomChangeHandler(x, y);
        redrawViewPort();
    }
    
    private void moveRoom() {
        
    }
    
    private String checkPlacementString(int x, int y) {

//        String dynamicplacement = Integer.toString(y) + Integer.toString(x);

        x = x + intX + 5;
        y = y + intY + 5;
        String placement;
        if (y < 10 && x < 10) {
            placement = "0" + Integer.toString(x) + "0" + Integer.toString(y);
        } else if (x < 10 && y >= 10) {
            placement = "0" + Integer.toString(x) + Integer.toString(y);
        } else if (x >= 10 && y < 10) {
            placement = Integer.toString(x) + "0" + Integer.toString(y);
        } else {
            placement = Integer.toString(x) + Integer.toString(y);
        }
        return placement;
    }
    
    private void redrawViewPort() {
        levelMap.forEach((String k, ImageView v) -> {

            int x = Integer.parseInt(k.substring(1, 2));
            int y = Integer.parseInt(k.substring(0, 1));
            String dynamicplacement = Integer.toString(y) + Integer.toString(x);

            x = x + intX;
            y = y + intY;
            
            String placement;
            if (y < 10 && x < 10) {
                placement = "0" + Integer.toString(x) + "0" + Integer.toString(y);
            } else if (x < 10 && y >= 10) {
                placement = "0" + Integer.toString(x) + Integer.toString(y);
            } else if (x >= 10 && y < 10) {
                placement = Integer.toString(x) + "0" + Integer.toString(y);
            } else {
                placement = Integer.toString(x) + Integer.toString(y);
            }
            if (backgroundMap.get(placement) != null) {
                v.setImage(new Image(backgroundMap.get(placement)));
            } else {
                v.setImage(new Image("/UI/Tiles/Sprites/Background.png"));// + TileEnum.BACKGROUND.toString());
            }
            if (dynamicMap.get(dynamicplacement) != null) {
                v.setImage(dynamicMap.get(dynamicplacement));
            }
        });
    }
    
////    private boolean isTileBackground(TileEnum tileEnum) {
//        if (tileEnum.toString().equals("background.png")) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    private void roomChangeHandler(int x, int y) {
        if(intX%5 == 0 && x == 1) {
            bfacade.move("East");
        } else if((intX%5 == 4 || intX%5 == -1) && x == -1) {
            bfacade.move("West");
        } else if(intY%5 == 0 && y == 1) {
            bfacade.move("South");
        } else if((intY%5 == 4 || intY%5 == -1) && y == -1) {
            bfacade.move("North");
        }
    }
}
