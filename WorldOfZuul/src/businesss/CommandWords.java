package businesss;

import java.util.HashMap;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class CommandWords
{
    private HashMap<String, CommandWord> validCommands;

    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}