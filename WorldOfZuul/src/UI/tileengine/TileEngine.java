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
    
    
    /**
     * Engine to handle the updating of Tile in the games viewport.
     * 
     * @param lvlMap The levelMap containing references to the viewport tiles.
     */
    public TileEngine(HashMap<String, ImageView> lvlMap) {
        // Set Values.
        offsetX = 7;
        offsetY = 12;
        levelMap = lvlMap;
        
        // Instantiate used objects.
        DynamicMap dm = new DynamicMap();
        bfacade = new BusinessFacede();
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
        changeRoom(x, y);
        redrawViewPort();
    }
    
    private boolean checkTileAndMovePlayer(int x, int y) {
        boolean ableToMove = true;
        // Check tile to the east if x>0.
        if (x > 0) {
            tile = backgroundMap.get(updateCenterPosition(1, 0));
            // If tile equals a stepable tile, nothing will happen and abteToMove will be returned as true.
            if (!(tile.equals(TileEnum.BACKGROUND.toString()) || tile.equals(TileEnum.GRASS.toString()) || tile.equals(TileEnum.SEWER_FLOOR.toString()) || tile.equals(TileEnum.LADDER_WALL.toString()))) {
                // Else tile is checked to contain an item to pick up.
                if ((tile.equals(TileEnum.Key.toString()))) {
                    backgroundMap.put(updateCenterPosition(1, 0), TileEnum.BACKGROUND.toString());
                } else if ((tile.equals(TileEnum.HAMMER_CHISEL.toString()))) {
                    backgroundMap.put(updateCenterPosition(1, 0), TileEnum.BACKGROUND.toString());
                // If tile isn't stepable and doesn't contain an item, ableToMove is set to false.
                } else {
                    ableToMove = false;
                }
            }
        // Check tile to the west if x<0.
        } else if (x < 0) {
            tile = backgroundMap.get(updateCenterPosition(-1, 0));
            // If tile equals a stepable tile, nothing will happen and abteToMove will be returned as true.
            if (!(tile.equals(TileEnum.BACKGROUND.toString()) || tile.equals(TileEnum.GRASS.toString()) || tile.equals(TileEnum.SEWER_FLOOR.toString()) || tile.equals(TileEnum.LADDER_WALL.toString()))) {
                // Else tile is checked to contain an item to pick up.
                if ((tile.equals(TileEnum.Key.toString()))) {
                    backgroundMap.put(updateCenterPosition(-1, 0), TileEnum.BACKGROUND.toString());
                } else if ((tile.equals(TileEnum.HAMMER_CHISEL.toString()))) {
                    backgroundMap.put(updateCenterPosition(-1, 0), TileEnum.BACKGROUND.toString());
                // If tile isn't stepable and doesn't contain an item, ableToMove is set to false.
                } else {
                    ableToMove = false;
                }
            }
        // Check tile to the south if y>0.
        } else if (y > 0) {
            tile = backgroundMap.get(updateCenterPosition(0, 1));
            // If tile equals a stepable tile, nothing will happen and abteToMove will be returned as true.
            if (!(tile.equals(TileEnum.BACKGROUND.toString()) || tile.equals(TileEnum.GRASS.toString()) || tile.equals(TileEnum.SEWER_FLOOR.toString()) || tile.equals(TileEnum.LADDER_WALL.toString()))) {
                // Else tile is checked to contain an item to pick up.
                if ((tile.equals(TileEnum.Key.toString()))) {
                    backgroundMap.put(updateCenterPosition(0, 1), TileEnum.BACKGROUND.toString());
                } else if ((tile.equals(TileEnum.HAMMER_CHISEL.toString()))) {
                    backgroundMap.put(updateCenterPosition(0, 1), TileEnum.BACKGROUND.toString());
                // If tile isn't stepable and doesn't contain an item, ableToMove is set to false.
                } else {
                    ableToMove = false;
                }
            }
        // Check tile to the north if y<0.
        } else {
            tile = backgroundMap.get(updateCenterPosition(0, -1));
            // If tile equals a stepable tile, nothing will happen and abteToMove will be returned as true.
            if (!(tile.equals(TileEnum.BACKGROUND.toString()) || tile.equals(TileEnum.GRASS.toString()) || tile.equals(TileEnum.SEWER_FLOOR.toString()) || tile.equals(TileEnum.LADDER_WALL.toString()))) {
                // Else tile is checked to contain an item to pick up.
                if ((tile.equals(TileEnum.Key.toString()))) {
                    backgroundMap.put(updateCenterPosition(0, -1), TileEnum.BACKGROUND.toString());
                } else if ((tile.equals(TileEnum.HAMMER_CHISEL.toString()))) {
                    backgroundMap.put(updateCenterPosition(0, -1), TileEnum.BACKGROUND.toString());
                // If tile isn't stepable and doesn't contain an item, ableToMove is set to false.
                } else {
                    ableToMove = false;
                }
            }
        }
        return ableToMove;
    }
    
    private String updateCenterPosition(int x, int y) {
        // Offset to center of screen, for the checker not to check tile in upper left corner.
        int screenOffset = 5;
        // Update center.
        x = x + offsetX + screenOffset;
        y = y + offsetY + screenOffset;
        
        // Handles the shift from possible 2-int tileplacer-format to 4-int tileplacer-format.
        String centerPosition;
        if (y < 10 && x < 10) {
            centerPosition = "0" + Integer.toString(x) + "0" + Integer.toString(y);
        } else if (x < 10 && y >= 10) {
            centerPosition = "0" + Integer.toString(x) + Integer.toString(y);
        } else if (x >= 10 && y < 10) {
            centerPosition = Integer.toString(x) + "0" + Integer.toString(y);
        } else {
            centerPosition = Integer.toString(x) + Integer.toString(y);
        }
        return centerPosition;
    }
    
    private void movePlayer(boolean canMove, int x, int y) {
        // Move player if tile is inside constraints of map.
        if(canMove) {
            if (-4 < offsetX && offsetX < 23 || x > 0 && offsetX < -3 || x < 0 && offsetX > 22) {
                offsetX = offsetX + x;
            }
            if (-4 < offsetY && offsetY < 13 || y > 0 && offsetY < -3 || y < 0 && offsetY > 12) {
                offsetY = offsetY + y;
            }
        }
    }
    
    private void changeRoom(int x, int y) {
        // Calls legacy code when room is chaged, to ensure syncronization between old and new code.
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
        // Redraw tiles by setting new images in the ImageView containers, 
        // based upon updated pointers to the backgroundMap HashMap.
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
