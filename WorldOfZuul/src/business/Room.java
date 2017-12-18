package business;

import java.util.Set;
import java.util.HashMap;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
class Room {
    private String description;
    private HashMap<String, Room> exits;
    private Item item = null;
    
    /**
     * Creates a room.
     * 
     * @param description room description.
     */
    protected Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Changes the room description
     * 
     * @param description room description
     */
    protected void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets exit of the room
     * 
     * @param direction exit direction (north, east, south or west).
     * @param neighbor set the neighbor to which the exit should lead to.
     */
    protected void setExit(String direction, Room neighbor) {
        setExit(direction, neighbor, false);
    }
    
    /**
     * create an item in the room.
     * 
     * @param item an item that can be picked up.
     */
    protected void setItem(Item item){
        this.item = item;
    }
    
    /**
     * get an item, if any in the room.
     * 
     * @return Item.
     */
    protected Item getItem(){
        return this.item;
    }
    
    /**
     * Check if the room contains an item.
     * 
     * @return true if room contains an item.
     */
    protected boolean isEmpty(){
        if (item == null) {
            return true;
        }
        return false;
    }
    
    /**
     * Sets an exit reference from this room to @param neighbor room in 
     * @direction.
     * 
     * if @param backwardExitReference is true, a backward reference is set from 
     * @neighbor to this room.
     * 
     * @param direction
     * @param neighbor
     * @param backwardExitReference 
     */
    protected void setExit(String direction, Room neighbor, Boolean backwardExitReference) {
        exits.put(direction, neighbor);
        
        if(backwardExitReference){
            String backDirection;
            switch(direction){
                case "north" : backDirection = "south";
                               break;
                case "east"  : backDirection = "west";
                               break;     
                case "south" : backDirection = "north";
                               break;
                case "west"  : backDirection = "east";
                               break;
                default      : backDirection = "Not Compatible";
                               break;
            }
            neighbor.setExit(backDirection, this);
        }
    }

    /**
     * Short description of the room 
     * 
     * @return a String with a short description.
     */
    protected String getShortDescription() {
        return description;
    }

    /**
     * Long description of the room, including exits
     * 
     * @return a String with a long description and exits.
     */
    protected String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Exits in the room.
     * 
     * @return a String containing exits from the room
     */
    protected String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * get the room at exit corresponding to direction.
     * 
     * @param direction exit direction of the room.
     * @return a Room that the exit leads to.
     */
    protected Room getExit(String direction) {
        return exits.get(direction);
    }
}