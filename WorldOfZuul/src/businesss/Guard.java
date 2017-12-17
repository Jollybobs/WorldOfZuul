
package businesss;

/**
 *
 * @author 103020
 */
public class Guard {
    private Room currentRoom;
    private Room[] patrol;
    private int numOfRooms = 0;
    private int roomsToPatrol = 0;
    
    /**
     * This class's constuctor
     * @param room the room the guard starts in
     */
    public Guard(Room room){
        this.currentRoom = room;
        patrol = new Room[10];
        patrol[numOfRooms] = room; // Siger hvilket rum han er i nu
        numOfRooms++;
    }

    /**
     * A getter 
     * @return the room the guard is in
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
     * Addes rooms that the guard will move to when it is called with a methode
     * @param room the new room that the guard can move to
     */
    public void addToPatrol(Room room){
        if (numOfRooms == patrol.length) { //can be change so the list gets exstended
            System.out.println("A guard can only guard so many rooms");
        } else {
            patrol[numOfRooms] = room;
            numOfRooms++;
        }
    }
    
    /**
     * Moves to the next room on the list but only if there was added a room to the Room[] patrol
     */
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
