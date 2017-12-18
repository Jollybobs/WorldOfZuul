package business;

public class Item {

    private String name;
//    private int size;
//    private final int itemID;

    /**
     * create an item.
     * 
     * @param name of item.
     * @param Size unused.
     * @param itemID unused.
     */
    public Item(String name, int Size, int itemID) {
        this.name = name;
    }

    /**
     * unsupported
     */
    public int getSize() {
        return 1;
    }

    /**
     * returns items name(String)
     */
    public String getName() {
        return this.name;
    }

    /**
     * unsupported
     * 
     * @return int 1.
     */
    public int getItemID() {
        return 1;
    }
}
