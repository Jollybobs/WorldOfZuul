package Business;

import java.util.ArrayList;

public class Inventory {

    private int freeSpace = 1;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    /**
     * if no args default inventory freeSpace=1
     */
    public Inventory() {
    }  // no args constructor

    public Inventory(int FreeSpace) {
        this.freeSpace = FreeSpace;
    }

    /**
     * Checks if the inventory has freeSpace, and adds an Item to the ArrayList
     * inventory if there is not space. Returns a String with text explaining
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
    *removes Item from ArrayList inventory & and adds the items size back to freeSpace
     *returns a String with text explaining the outcome.
     */
    public void dropItem(Item item) {
        inventory.remove(item);
        freeSpace += item.getSize();
    }//m-addItem 
    
    public void emptyInventory(){
        inventory.clear();
    }

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
     * check if ArrayList inventory contains Item
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

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    
    
}//c-inventory
