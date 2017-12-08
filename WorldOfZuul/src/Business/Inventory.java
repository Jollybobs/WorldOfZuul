package Business;

import java.util.ArrayList;

public class Inventory {

    private int freeSpace = 1;
    ArrayList<Item> inventory = new ArrayList<Item>();

    /**
     * if no args default inventorys frespace=1
     */
    public Inventory() {
    }  // no args constructor

    public Inventory(int FreeSpace) {
        this.freeSpace = FreeSpace;
    }

    /**
     * Checks if the inventory has Freespace, and adds an Item to the ArrayList
     * inventory if there is not space. returns a String with text explaining
     * the outcome.
     */
    public String addItem(Item item) throws IllegalArgumentException {
        if (item.getSize() <= 0) {
            throw new IllegalArgumentException("Size <=0 exception");
        }
        if (item.getSize() <= freeSpace) {
            inventory.add(item);
            freeSpace -= item.getSize();
            //sout Item pick up
            return ("you picked up a " + item.getName() + "!");
        }//if 
        else {
            return ("your inventory doesn't have space");
        }//else

    }//m-addItem

    /*
    *romves Item from ArrayList inventory & and adds the items size back to freeSpace
     *returns a String with text explaining the outcome.
     */
    public String dropItem(Item item) {
        inventory.remove(item);
        freeSpace += item.getSize();
        return ("you dropped" + item);
    }//m-addItem 

    //PRINT INVENTORY
    //prints ArrayList inventory
    public String printInventory() {
        String result = ("you inventory contains: ");
        for (Item item : inventory) {
            result += (item.getName() + ", ");
        }//for print
        return result;
    }//PrintInventory

    /**
     * check if ArrayList inventory containts Item
     */
    public boolean checkFor(Item item) {
        boolean result = false;
        if (inventory.contains(item)) {
            result = true;
        }//if contains
        return result;
    }//m-checkFor

    /**
     * check if the inventory contains anything (returns true if inventory is
     * empty)
     */
    public boolean checkEmpty() {
        boolean result = false;
        if (inventory.isEmpty()) {
            result = true;
        }//if .isempty= true result=true
        return result;
    }//m-checkEmpty

}//c-inventory
