
package com.framework.WorldOfZuul;

/**
 *
 * @author 103020
 */
public class Guard {
    private Room currentRoom;
    private Room[] patrol;
    private int roomsToPatrol = 0;
    
    public Guard(Room room){
        this.currentRoom = room;
        patrol = new Room[10];
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void addToPatrol(Room room){
        if (roomsToPatrol == patrol.length) {
            System.out.println("A guard can only guard so many rooms");
        } else {
            patrol[roomsToPatrol] = room;
        }
    }
}
