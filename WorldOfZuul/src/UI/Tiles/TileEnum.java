/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Tiles;

/**
 *
 * @author Jonathan
 */
public enum TileEnum {
    BACKGROUND        ("/Tiles/Sprites/Background.png"),
    DOOREASTEND       ("/Tiles/Sprites/DoorEastEnd.png"),
    DOOREASTSTART     ("/Tiles/Sprites/DoorEastStart.png"),
    DOORNORTHEND      ("/Tiles/Sprites/DoorNorthEnd.png"),
    DOORNORTHSTART    ("/Tiles/Sprites/DoorNorthStart.png"),
    DOORSOUTHEND      ("/Tiles/Sprites/DoorSouthEnd.png"),
    DOORSOUTHSTART    ("/Tiles/Sprites/DoorSouthStart.png"),
    DOORWESTEND       ("/Tiles/Sprites/DoorWestEnd.png"),
    DOORWESTSRTART    ("/Tiles/Sprites/DoorWestStart.png"),
    GUARD             ("/Tiles/Sprites/Guard.png"),
    HAMMER_CHISEL     ("/Tiles/Sprites/Hammer_Chisel.png"),
    Key               ("/Tiles/Sprites/Key.png"),
    LADDER            ("/Tiles/Sprites/Ladder.png"),
    OFFICEMAN         ("/Tiles/Sprites/OfficeMan.png"),
    PLAYER            ("/Tiles/Sprites/Player.png"),
    PRISONER          ("/Tiles/Sprites/Prisoner.png"),
    SAW               ("/Tiles/Sprites/Saw.png"),
    SEWERFLOOR1       ("/Tiles/Sprites/SewerFloor1.png"),
    SEWERFLOOR2       ("/Tiles/Sprites/SewerFloor2.png"),
    SEWERFLOOR3       ("/Tiles/Sprites/SewerFloor3.png"),
    SEWERFLOOR4       ("/Tiles/Sprites/SewerFloor4.png"),
    SEWERFLOOR5       ("/Tiles/Sprites/SewerFloor5.png"),
    SEWERFLOORLADDER  ("/Tiles/Sprites/SewerFloorLadder.png"),
    SEWERFLOORPIPE1   ("/Tiles/Sprites/SewerFloorPipe1.png"),
    SEWERFLOORPIPE2   ("/Tiles/Sprites/SewerFloorPipe2.png"),
    SEWERTEST         ("/Tiles/Sprites/SewerTest.png"),
    WALL_EAST         ("/Tiles/Sprites/WallEast.png"),
    WALL_NORTH        ("/Tiles/Sprites/WallNorth.png"),
    WALL_NORTH_EAST   ("/Tiles/Sprites/WallNorthEast.png"),
    WALL_NORTH_LADDER ("/Tiles/Sprites/WallNorthLadder.png"),
    WALL_NORTH_WEST   ("/Tiles/Sprites/WallNorthWest.png"),
    WALL_SOUTH        ("/Tiles/Sprites/WallSouth.png"),
    WALL_SOUTH_EAST   ("/Tiles/Sprites/WallSouthEast.png"),
    WALL_SOUTH_WEST   ("/Tiles/Sprites/WallSouthWest.png"),
    WALL_WEST         ("/Tiles/Sprites/WallWest.png"),
    WALL_WITH_PIPE    ("/Tiles/Sprites/WallWithPipe.png");
    
    private final String path;
    
    private TileEnum(String s) {
        path = s;
    }
    
    @Override
    public String toString() {
        return this.path;
    }
}
