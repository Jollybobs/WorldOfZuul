package businesss;

public class Item {

    private String name;
    private int size;
    private final int itemID;

//CONSTRUCTOR 
    public Item(String name, int Size, int itemID) {
        this.name = name;
        this.size = Size;
        this.itemID = itemID;
    }

    public Item(int itemID) {
        this.itemID = itemID;
    }

    /**
     * returns the size(int) that the item will take up in the inventory
     */
    public int getSize() {
        return this.size;
    }

    /**
     * returns items name(String)
     */
    public String getName() {
        return this.name;
    }

    /**
     * return the items ID witch is used to find a specific item. itemID is
     * final and is defined when the constructor is called
     */
    public int getItemID() {
        return this.itemID;

        // c key
    }
}//c-Item

//C-KEY
class key extends Item {


    /**
     *
     * @param name
     * @param size
     * @param itemID
     */
    public key(String name, int size, int itemID) {
        super(name, size, itemID);
    }//key no args -constructor
}

class saw extends Item {


    public saw(String name, int size, int itemID) {
        super(name, size, itemID);
    }
}

class hammer_chisel extends Item {


    public hammer_chisel(String name, int size, int itemID) {
        super(name, size, itemID);
    }
}
