/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

class Player {

    private static Player player;
    private static Room currentRoom;
    private static String name;
    private static Inventory inventory;
    private static double score;

    /**
     *
     * @param room
     */
    protected Player(Room room) {
        this.currentRoom = room;
        this.inventory = new Inventory();

    }

    /**
     *
     * @param room
     * @param name
     */
    protected Player(Room room, String name) {
        this.currentRoom = room;
        this.name = name;
        this.inventory = new Inventory();
    }

    /**
     *
     * @return
     */
    protected static Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     *
     * @param currentRoom
     */
    protected static void setCurrentRoom(Room currentRoom) {
        currentRoom = currentRoom;
    }

    /**
     *
     * @return
     */
    protected static String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    protected static void setName(String name) {
        name = name;
    }

    /**
     *
     * @return
     */
    protected static Inventory getInventory() {
       return inventory;
    }

    /**
     *
     * @param item
     */
    protected static void addItemInventory(Item item) {
        inventory.addItem(item);
    }
    
    protected static void dropAll(){
        inventory.emptyInventory();
    }

    protected static double getScore() {
        return score;
    }

    protected static void setScore(double score) {
        Player.score = score;
    }
    

}
