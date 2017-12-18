package business;

import java.util.ArrayList;

import dataLayer.DataFacede;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game {

    DataFacede data = new DataFacede();

    private ArrayList allObjects = new ArrayList();
    private ArrayList highscore;
    private Player player;
    private Parser parser;
    private Guard[] guards = new Guard[10];

    // Defines room variables.
    protected Room cell, southHall, hall, northHall, office, canteen, yard, workshop, bathroom, sewer, sewerExit, freedom;
    
    /**
     * Constructor for Game Class. At instantiation the rooms are created and a
     * parser for handling the command line input is instantiated. After
     * instantiation call .play() to start the game
     */
    public Game() 
    {
        parser = new Parser();
    }

    protected void loadRooms(ArrayList aList){
        allObjects = new ArrayList(aList);
        player = (Player)allObjects.get(0);
      
        // Instantiates room variables.
        cell = (Room)allObjects.get(1);
        southHall = (Room)allObjects.get(2);
        hall = (Room)allObjects.get(3);
        northHall = (Room)allObjects.get(4);
        office = (Room)allObjects.get(5);
        canteen = (Room)allObjects.get(6);
        yard = (Room)allObjects.get(7);
        workshop = (Room)allObjects.get(8);
        bathroom = (Room)allObjects.get(9);
        sewer = (Room)allObjects.get(10);
        sewerExit = (Room)allObjects.get(11);
        freedom = (Room)allObjects.get(12);
        Guard guard = (Guard)allObjects.get(13);
        guards[0] = guard;
    }
    
    /**
     * Creates room instantiations, sets exits in rooms and defines the starting
     * room.
     */
    protected void createRooms()
    {
        allObjects.add(player);

        // Instantiates room variables.
        cell = new Room("in your cell, the door to the hall is to the east");
        allObjects.add(cell);
        southHall = new Room("in the southern end of the hall, the hall keeps going north and the door to the bathroom is to the east");
        allObjects.add(southHall);
        hall = new Room("in the central part of the hall, the hall keeps going both south and north, the door the the yard is to the east");
        allObjects.add(hall);
        northHall = new Room("in the northern end of the hall, the hall keeps going south, you see the door to the correction officers office to the north \nand the door to the canteen to the east");
        allObjects.add(northHall);
        office = new Room("in the correction officers office, the exit is to the south");
        allObjects.add(office);
        canteen = new Room("in the big canteena, the exit to the hall is to the west");
        allObjects.add(canteen);
        yard = new Room("in the yard, the hall is west and you can see the workshop to the east");
        allObjects.add(yard);
        workshop = new Room("in the workshop, the exit is to the west");
        allObjects.add(workshop);
        bathroom = new Room("in the bathroom, the exit is to the west");
        allObjects.add(bathroom);
        sewer = new Room("in the sewers, the sewer keeps going to the west and the cell is back east");
        allObjects.add(sewer);
        sewerExit = new Room("in the sewers, the sewer keeps going to the west but you see an exit above you and back east is the sewer at your cell");
        allObjects.add(sewerExit);
        freedom = new Room("free!");
        allObjects.add(freedom);

        // Uses .setExit() method to define exits in rooms. 
        cell.setExit("east", southHall);

        southHall.setExit("west", cell);
        southHall.setExit("north", hall);
        southHall.setExit("east", bathroom);

        hall.setExit("south", southHall);
        hall.setExit("east", yard);
        hall.setExit("north", northHall);

        northHall.setExit("east", canteen);
        northHall.setExit("south", southHall);
        northHall.setExit("north", office);

        office.setExit("south", northHall);

        canteen.setExit("west", northHall);
        canteen.setExit("south", yard);

        yard.setExit("west", hall);
        yard.setExit("north", canteen);
        yard.setExit("south", bathroom);
        yard.setExit("east", workshop);

        workshop.setExit("west", yard);

        bathroom.setExit("west", southHall);
        bathroom.setExit("north", yard);

        sewer.setExit("east", cell);
        sewer.setExit("west", sewerExit);

        sewerExit.setExit("east", sewer);
        sewerExit.setExit("up", sewer);

        // Sets a room-variable to the membervariable currentRoom. Thus defining a starting room.
        player.setCurrentRoom(cell);

        // Add items to room.
        workshop.setItem(new Item("Hammer & Chisel", 0, 1));
        office.setItem(new Item("Key", 0, 1));
    }

    /**
     * Method to handle game loop and shut down. Initialization is handles by
     * the Game constructor itself.
     */
    public void play() {
        printWelcome();

        // Sets boolean variable finished to false to maintain the game loop until a shutdown is initiated from inside the loop, by setting the boolean to true.
        boolean finished = false;
        while (!finished) {
            // Inside the loop a command from the command line is received after being parsed by the Parser class instantiation saved in a membervariable.
            Command command = parser.getCommand();
            // The command is then processed by the processCommand method and returns a boolean to the variable finished.
            finished = processCommand(command);
            // if the command is to set finished = true the loop ends, else the loop will continue to run.
        }
        // After the loop, a shut down message is displayed.
        System.out.println("Thank you for playing. Good bye.");
    }

    /**
     * Prints a welcome message to the console.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Nevada Prison");
        System.out.println("Nevada Prison is a new, incredibly insecure prison so you want to break out.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }

    /**
     * Processes a command object by using the objects .getCommandWord() method
     * to retrieve the first word in the command supplied by the user. This
     * CommandWord dictates which operation is to be executed.
     *
     * @param command a Command Object.
     * @return boolean wantToQuit, if true the program shuts down.
     */
    private boolean processCommand(Command command) {
        // Starts by setting the return boolean to false. This is to ensure that the program won't accidently shut down.
        boolean wantToQuit = false;

        // The CommandWord is fetched from the Command object.
        CommandWord commandWord = command.getCommandWord();

        // Firstly a guard to check for a unknown CommandWord is applied. This is to give user feedback.
        // If this is outcommented nothing would happen when the user types an unknown command.
        // The call printHelp() is added to supply the user with a list of usable commands, 
        // because perhaps the user has forgotten that help is a useable command.
        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            printHelp();
            return false;
        }

        // an if/else block to apply function calls to the correct CommandWord.
        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } // if CommandWord == commandWord.QUIT, the wantToQuit variable is changed to true and the program will shut down.
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == commandWord.LOOK) {
            lookRoom();
        } else if (commandWord == commandWord.WAIT) {
//            moveGuard();
        } else if (commandWord == commandWord.INVENTORY) {
            player.getInventory().printInventory();
        }
        return wantToQuit;
    }

    /**
     * Prints a helping guide to the console, indicating which commands are
     * available at the current moment.
     */
    protected void printHelp() {
        System.out.println("You wander around the prison and");
        System.out.println("You want to find a way to break out.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * if commandWord == CommandWord.GO the private goRoom method is executed.
     * supplied with the Command object this method extracts the Secondword.
     * This is used to determine the direction to execute the goRoom method in.
     *
     * @param command
     */
    protected void goRoom(Command command) {
        // Null-point Guard to make sure the Command object has a SecondWord.
        // If the SecondWord is not defined in memory by a pointer, as soon as
        // the program tries to access the memory at the end of the undefined pointer
        // the program will crash if the Null-pointer exception isn't handed by a try/catch.
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        // Extracts the SecondWord from the Command object
        String direction = command.getSecondWord();

        // Sets nextRoom to the desired next room
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        // A hidden Null-pointer guard, wich display a message to the user, if there are no door.
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } // If there is a door, the currentRoom is set to nextRoom and a LongDescription af the now currentRoom is displayed to the user.
        else {
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
//            moveGuard();
        }
//        moveGuard();
    }

    // TODO - Unfinished method.
    protected void lookRoom() {
        System.out.println(player.getCurrentRoom().getLongDescription());
        if (player.getCurrentRoom().getItem() != null) {
            System.out.println("You can see a " + player.getCurrentRoom().getItem());
        }
    }

    // In order to quit, there can't be a second word.
    private boolean quit(Command command) {
        // If something is written in the console the program won't quit.
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    /**
     * savegame gets the list that it will save from here
     * @return true if it saved successfully
     */
    protected boolean saveGame() {
        return data.save(allObjects);
    }

    /**
     * Saves the highscore.
     * 
     * @return a boolean indicating succes of the save operation.
     */
    protected boolean saveHighscore() {
        highscore = (ArrayList) data.loadScore();
        return data.saveScore(highscore);
    }
    
    /**
     * Sort an ArrayList
     * 
     * @param highScore The ArrayList to be sorted.
     */
    private void sortHighScore(ArrayList highScore){
        boolean highSet = false;
        double temp = 0;
        double temp2;
        String name = "";
        String name2;
        for (int i = 1; i < 10; i = i+2) {
            if (highSet) {
                temp2 = (double)highScore.get(i);
                name2 = (String)highScore.get(i-1);
                highScore.set(i, temp);
                highScore.set(i-1, name);
                temp = temp2;
                name = name2;
            } else if ((double)highScore.get(i) > Player.getScore()) {
                temp = (double)highScore.get(i);
                name = (String)highScore.get(i-1);
                highScore.set(i, Player.getScore());
                highSet = true;
            }
        }
    }
}
