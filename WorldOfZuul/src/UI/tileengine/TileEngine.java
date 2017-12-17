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
    
    int offsetX;
    int offsetY;
    String tile;
    boolean move;
    HashMap<String, ImageView> levelMap;
    HashMap<String, String> backgroundMap;
    HashMap<String, Image> dynamicMap;
    DataFacede data;
    
    public TileEngine(HashMap<String, ImageView> lvlMap) {
        // Set Values.
        offsetX = 7;
        offsetY = 12;
        levelMap = lvlMap;
        
        // Instantiate used objects.
        bfacade = new BusinessFacede();
        DynamicMap dm = new DynamicMap();
        data = new DataFacede();
        
        // Get data from objects.
        dynamicMap = dm.getMap();
        backgroundMap = data.loadMap();
        
        // Update map with data.
        redrawViewPort();
    }
        
    public void moveMap(int x, int y) {
        // Get logik values.
        move = checkTileAndMovePlayer(x, y);
        
        // Do method-logik.
        movePlayer(move, x, y);
        roomChangeHandler(x, y);
        redrawViewPort();
    }
    
    private boolean checkTileAndMovePlayer(int x, int y) {
        boolean ableToMove = true;
        if (x > 0) {
            tile = backgroundMap.get(checkPlacementString(1, 0));
            if (!(tile.equals(TileEnum.BACKGROUND.toString()) || tile.equals(TileEnum.GRASS.toString()) || tile.equals(TileEnum.SEWER_FLOOR.toString()) || tile.equals(TileEnum.LADDER_WALL.toString()))) {
                if ((tile.equals(TileEnum.Key.toString()))) {
                    backgroundMap.put(checkPlacementString(1, 0), TileEnum.BACKGROUND.toString());
                } else if ((tile.equals(TileEnum.HAMMER_CHISEL.toString()))) {
                    backgroundMap.put(checkPlacementString(1, 0), TileEnum.BACKGROUND.toString());
                } else {
                    ableToMove = false;
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
                    ableToMove = false;
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
                    ableToMove = false;
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
                    ableToMove = false;
                }
            }
        }
        return ableToMove;
    }
    
    private String checkPlacementString(int x, int y) {

//        String dynamicplacement = Integer.toString(y) + Integer.toString(x);

        x = x + offsetX + 5;
        y = y + offsetY + 5;
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
    
    private void movePlayer(boolean canMove, int x, int y) {
        if(canMove) {
            if (-4 < offsetX && offsetX < 23 || x > 0 && offsetX < -3 || x < 0 && offsetX > 22) {
                offsetX = offsetX + x;
            }
            if (-4 < offsetY && offsetY < 13 || y > 0 && offsetY < -3 || y < 0 && offsetY > 12) {
                offsetY = offsetY + y;
            }
        }
    }
    
    private void roomChangeHandler(int x, int y) {
        if(offsetX%5 == 0 && x == 1) {
            bfacade.move("east");
        } else if((offsetX%5 == 4 || offsetX%5 == -1) && x == -1) {
            bfacade.move("west");
        } else if(offsetY%5 == 0 && y == 1) {
            bfacade.move("south");
        } else if((offsetY%5 == 4 || offsetY%5 == -1) && y == -1) {
            bfacade.move("north");
        }
    }
    
    private void redrawViewPort() {
        levelMap.forEach((String k, ImageView v) -> {

            int x = Integer.parseInt(k.substring(1, 2));
            int y = Integer.parseInt(k.substring(0, 1));
            String dynamicplacement = Integer.toString(y) + Integer.toString(x);

            x = x + offsetX;
            y = y + offsetY;
            
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
}
