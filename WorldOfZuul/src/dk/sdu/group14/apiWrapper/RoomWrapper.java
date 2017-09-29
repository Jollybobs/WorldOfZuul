/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group14.apiWrapper;

import com.framework.WorldOfZuul.Room;

/**
 *
 * @author jollybob
 */
public class RoomWrapper {
    Room aRoom;
    public RoomWrapper(String s) {
        aRoom = new Room(s);
    }
    public void setExit(String direction, Room neighbor) 
    {
        aRoom.setExit(direction, neighbor);
    }

    public String getShortDescription()
    {
        return aRoom.getShortDescription();
    }

    public String getLongDescription()
    {
        return aRoom.getLongDescription();
    }


    public Room getExit(String direction) 
    {
        return aRoom.getExit(direction);
    }
}
