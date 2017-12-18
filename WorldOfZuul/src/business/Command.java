package business;

/** 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Command
{
    private CommandWord commandWord;
    private String secondWord;

    /**
     * Create a command
     * 
     * @param commandWord function call.
     * @param secondWord input for function call.
     */
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * returns the function call.
     * 
     * @return CommandWord
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    /**
     * returns the finction input.
     * 
     * @return String.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * Checks if the commandword is known
     * 
     * @return boolean to indicate if command is known.
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * checks for input to command.
     * 
     * @return boolean to indicate if input is present.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}