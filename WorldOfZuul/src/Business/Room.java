package Business;

import java.util.Set;
import java.util.HashMap;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Item item = null;

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExit(String direction, Room neighbor) 
    {
        setExit(direction, neighbor, false);
    }
    
    public void setItem(Item item){
        this.item = item;
    }
    
    public Item getItem(){
        return this.item;
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
    public void setExit(String direction, Room neighbor, Boolean backwardExitReference) 
    {
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

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

	private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}