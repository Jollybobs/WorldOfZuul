package business;

import java.util.ArrayList;

public class Inventory {
//
//    private int freeSpace = 1;
    private ArrayList<Item> inventory = new ArrayList();

    /**
     * if no args default inventory freeSpace=1
     */
    public Inventory() {
    }  // no args constructor

    /**
     * Checks if the inventory has freeSpace, and adds an Item to the ArrayList
     * inventory if there is not space. Returns a String with text explaining
     * the outcome.
     * 
     * @param item - Item to be added to inventory.
     * @return String - a description of the item added to inventory
     */
    public String addItem(Item item) {
            inventory.add(item);
//            freeSpace -= item.getSize();
            //sout Item pick up
            return ("you picked up a " + item.getName() + "!");

    }//m-addItem

    //PRINT INVENTORY
    //
    
    /**
     * Concatenates a string of items in the inventory ArrayList.
     * 
     * @return String - with the results
     */
    public String getInventoryListString() {
        String result = ("you inventory contains: \n");
        if(inventory.size() > 0) {
            for (Item item : inventory) {
                result += (item.getName() + "\n");
            }//for print
        }
        return result;
    }//PrintInventory

    /**
     * check if ArrayList inventory contains Item
     * @param item - Item to be checked.
     * 
     * @return boolean - true if ArrayList contains item.
     */
    public boolean checkFor(Item item) {
        boolean result = false;
        if (inventory.contains(item)) {
            result = true;
        }//if contains
        return result;
    }//m-checkFor

    /**
     * better for inventory.
     * 
     * @return ArrayList of inventory items.
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }
}//c-inventory
