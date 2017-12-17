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
    
    protected Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected void setExit(String direction, Room neighbor) {
        setExit(direction, neighbor, false);
    }
    
    protected void setItem(Item item){
        this.item = item;
    }
    
    protected Item getItem(){
        return this.item;
    }
    
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

    protected String getShortDescription() {
        return description;
    }

    protected String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    protected String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    protected Room getExit(String direction) {
        return exits.get(direction);
    }
}