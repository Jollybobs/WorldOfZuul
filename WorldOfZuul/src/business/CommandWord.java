package business;

/**
 * An Enum designed to guard the list of usable commandWords from things like spelling mistakes etc. when used in the code.
 * Furthermore many IDE's has the abilities to show a list of possible enums when using a method which has this enum aas an input argument.
 * This can not be done with a String, forcing the developer to look inside the method an backward-engineer the possibilities.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), LOOK("look"), INVENTORY ("inventory"), WAIT ("wait"), UNKNOWN("?");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}