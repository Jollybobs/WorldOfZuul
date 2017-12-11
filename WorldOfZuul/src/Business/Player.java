/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

public class Player {

    private static Player player;
    private static Room currentRoom;
    private static String name;
    static Inventory inventory;

    /**
     *
     * @param room
     */
    public Player(Room room) {
        this.currentRoom = room;
        this.inventory = new Inventory();

    }

    /**
     *
     * @param room
     * @param name
     */
    public Player(Room room, String name) {
        this.currentRoom = room;
        this.name = name;
        this.inventory = new Inventory();
    }

    /**
     *
     * @return
     */
    public static Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     *
     * @param currentRoom
     */
    public static void setCurrentRoom(Room currentRoom) {
        currentRoom = currentRoom;
    }

    /**
     *
     * @return
     */
    public static String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public static void setName(String name) {
        name = name;
    }

  
}
