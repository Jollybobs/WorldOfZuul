/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author 103020
 */
public class Player {
    private Room currentRoom;
    private String name;
    private Inventory inventory;
    
    public Player(Room room){
        this.currentRoom = room;
        this.inventory = new Inventory();
        
    }
    public Player(Room room, String name){
        this.currentRoom = room;
        this.name = name;
        this.inventory = new Inventory();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addItemInventory(Item item) {
        this.inventory.addItem(item);
    }
    
}
