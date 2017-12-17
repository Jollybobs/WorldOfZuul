/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.tiles;

/**
 *
 * @author Jonathan
 */
public enum TileEnum {    
    BACKGROUND        ("Background.png"),
    DOOREASTEND       ("DoorEastEnd.png"),
    DOOREASTSTART     ("DoorEastStart.png"),
    DOORNORTHEND      ("DoorNorthEnd.png"),
    DOORNORTHSTART    ("DoorNorthStart.png"),
    DOORSOUTHEND      ("DoorSouthEnd.png"),
    DOORSOUTHSTART    ("DoorSouthStart.png"),
    DOORWESTEND       ("DoorWestEnd.png"),
    DOORWESTSRTART    ("DoorWestStart.png"),
    GUARD             ("Guard.gif"),
    HAMMER_CHISEL     ("Hammer_Chisel.png"),
    Key               ("Key.png"),
    LADDER            ("Ladder.png"),
    OFFICEMAN         ("OfficeMan.png"),
    PLAYER            ("Player.gif"),
    PRISONER          ("Prisoner.png"),
    SAW               ("Saw.png"),
    SEWERFLOOR1       ("SewerFloor1.png"),
    SEWERFLOOR2       ("SewerFloor2.png"),
    SEWERFLOOR3       ("SewerFloor3.png"),
    SEWERFLOOR4       ("SewerFloor4.png"),
    SEWERFLOOR5       ("SewerFloor5.png"),
    SEWERFLOORLADDER  ("SewerFloorLadder.png"),
    SEWERFLOORPIPE1   ("SewerFloorPipe1.png"),
    SEWERFLOORPIPE2   ("SewerFloorPipe2.png"),
    SEWERTEST         ("SewerTest.png"),
    WALL_EAST         ("WallEast.png"),
    WALL_NORTH        ("WallNorth.png"),
    WALL_NORTH_EAST   ("WallNorthEast.png"),
    WALL_NORTH_LADDER ("WallNorthLadder.png"),
    WALL_NORTH_WEST   ("WallNorthWest.png"),
    WALL_SOUTH        ("WallSouth.png"),
    WALL_SOUTH_EAST   ("WallSouthEast.png"),
    WALL_SOUTH_WEST   ("WallSouthWest.png"),
    WALL_WEST         ("WallWest.png"),
    WALL_WITH_PIPE    ("WallWithPipe.png"),
    GRASS             ("Grass.png"),
    SOUTH_NORTH_WALL  ("NSWall.png"),
    WEST_EAST_WALL    ("WEWall.png"),
    SEWER_FLOOR       ("Sewer floor.png"),
    LADDER_WALL       ("LadderWall.png"),
    SEWER_LADDER      ("SewerLadder.png"),
    SEWER_BARS        ("SewerBars.png");
    
    private final String path;
    
    private TileEnum(String s) {
        path = "/UI/Tiles/Sprites/" + s;
    }
    
    @Override
    public String toString() {
        return this.path;
    }
}
