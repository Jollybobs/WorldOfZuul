
package com.framework.WorldOfZuul;

/**
 *
 * @author 103020
 */
public class Guard {
    private Room currentRoom;
    private Room[] patrol;
    private int numOfRooms = 0;
    private int roomsToPatrol = 0;
    
    public Guard(Room room){
        this.currentRoom = room;
        patrol = new Room[10];
        patrol[numOfRooms] = room;
        numOfRooms++;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void addToPatrol(Room room){
        if (numOfRooms == patrol.length) {
            System.out.println("A guard can only guard so many rooms");
        } else {
            patrol[numOfRooms] = room;
            numOfRooms++;
        }
    }
    public void moveToNextRoom(){
        if (numOfRooms <= 1) {
            System.out.println("A guard only have one room, so can't move to another one");
        } else if (roomsToPatrol+1 <= numOfRooms) {
            currentRoom = patrol[++numOfRooms];
        }
 {
            
        }
    }
}
