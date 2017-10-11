package com.framework.WorldOfZuul;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    private void createRooms()
    {
        Room cell, southHall, hall, northHall, office, canteen, yard, workshop, bathroom, sewer, sewerExit, freedom;
      
        cell = new Room("in your cell, the door to the hall is to the east");
        southHall = new Room("in the southern end of the hall, the hall keeps going north and the door to the bathroom is to the east");
        hall = new Room("in the central part of the hall, the hall keeps going both south and north, the door the the yard is to the east");
        northHall = new Room("in the northern end of the hall, the hall keeps going south, you see the door to the correction officers office to the north /n and the door to the canteen to the east");
        office = new Room("in the correction officers office, the exit is to the south");
        canteen = new Room("in the big canteena, the exit to the hall is to the west");
        yard = new Room("in the yard, the hall is west and you can see the workshop to the east");
        workshop = new Room("in the workshop, the exit is to the west");
        bathroom = new Room("in the bathroom, the exit is to the west");
        sewer = new Room("in the sewers, the sewer keeps going to the west and the cell is back east");
        sewerExit = new Room("in the sewers, the sewer keeps going to the west but you see an exit above you and back east is the sewer at your cell");
        freedom = new Room("free!");
        
        
        cell.setExit("east", southHall);

        southHall.setExit("west", cell);
        southHall.setExit("north", hall);
        southHall.setExit("east", bathroom);

        hall.setExit("south", southHall);
        hall.setExit("east", yard);
        hall.setExit("north", northHall);        

        northHall.setExit("east", canteen);
        northHall.setExit("south", southHall);

        office.setExit("south", northHall);
        
        canteen.setExit("west", northHall);
        canteen.setExit("south", yard);
        
        yard.setExit("west", hall);
        yard.setExit("north", canteen);
        yard.setExit("south", bathroom);
        
        workshop.setExit("west", yard);
        
        bathroom.setExit("west", southHall);
        bathroom.setExit("north", yard);
        
        sewer.setExit("east", cell);
        sewer.setExit("west", sewerExit);
        
        sewerExit.setExit("east", sewer);
        sewerExit.setExit("up", sewer);
        
        currentRoom = cell;
    }

    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Nevada Prison");
        System.out.println("Nevada Prison is a new, incredibly insecure prison so you want to break out.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You wander around the prison and");
        System.out.println("you want to find a way to break out.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
