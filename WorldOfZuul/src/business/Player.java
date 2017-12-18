package business;

class Player {

    private static Player player;
    private static Room currentRoom;
    private static String name;
    private static Inventory inventory;
    private static double score;

    /**
     * Player Contructor.
     * Creates an empty Invetory() for the player.
     */
    protected Player() {
        this.inventory = new Inventory();
    }

    /**
     * Getter for the current room of the player.
     * 
     * @return Room - of the player.
     */
    protected static Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Setter for the current room of the player.
     * 
     * @param currentRoom - of the player.
     */
    protected static void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    /**
     * Getter for inventory.
     * 
     * @return Inventory - object containing items in Inventory.
     */
    protected static Inventory getInventory() {
       return inventory;
    }

    /**
     * Setter for Inventory Item's
     * 
     * @param item - to be added to inventory.
     */
    protected static void addItemInventory(Item item) {
        inventory.addItem(item);
    }
    
    /**
     * Not yet supported.
     */
    protected static void dropAll(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Not yet supported.
     * 
     * @return score
     */
    protected static double getScore() {
        return score;
    }

    /**
     * Not yet supported.
     * 
     * @param score 
     */
    protected static void setScore(double score) {
        Player.score = score;
    }
    
    /**
     * Not yet supported.
     * 
     * @return
     */
    protected static String getName() {
        return name;
    }

    /**
     * Not yet supported.
     * 
     * @param name
     */
    protected static void setName(String name) {
        name = name;
    }
}
