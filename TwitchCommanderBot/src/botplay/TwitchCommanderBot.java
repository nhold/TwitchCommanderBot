package botplay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.jibble.pircbot.*;

/**
 * This bot will grab all messages and if the message matches a command
 * that you have added it will be placed into the command queue
 * @author Nathan Hold
 */
public class TwitchCommanderBot extends PircBot {

    public HashMap<String, Integer> getCommandMap() {
        return commandMap;
    }

    private HashMap<String, Integer> commandMap;

    private CommandQueue commandQueue;

    /**
     * Default constructor
     * @param botName The name of the IRC account.
     */
    public TwitchCommanderBot(String botName) {
        commandQueue = new CommandQueue();
        commandMap = new HashMap<String, Integer>();

        this.setName(botName);
    }

    public void AddCommand(String commandString, int key) {
        commandMap.put(commandString.toLowerCase(), key);
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        if (IsValidCommand(message)) {

            String actualCommand = message.toLowerCase();
            String displayText = sender + " pressed: " + message.toLowerCase();

            Command newCommand = new Command(actualCommand, displayText);

            commandQueue.add(newCommand);

        }
    }

    private boolean IsValidCommand(String message) {
        return commandMap.get(message.toLowerCase()) != null;
    }

    public Command GetNextCommand() {

        if (commandQueue.size() > 0) {
            return commandQueue.remove(0);
        }

        return null;
    }

    public int GetKeyForCommand(String command) {
        return commandMap.get(command);
    }


}


