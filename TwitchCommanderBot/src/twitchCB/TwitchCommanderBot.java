package twitchCB;

import java.util.HashMap;
import java.util.Vector;
import org.jibble.pircbot.*;


public class TwitchCommanderBot extends PircBot {

	HashMap <String, Integer> commandMap;
	Vector <String> commandVector;
	Vector <String> displayVector; // maps to command vector
	
	public TwitchCommanderBot(String botName) 
	{
		commandMap = new HashMap <String, Integer>();
		commandVector = new Vector <String>();
		displayVector = new Vector <String>();
		this.setName(botName);
	}
	
	public void AddCommand(String commandString, int key)
	{
		commandMap.put(commandString.toLowerCase(), key);
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message) 
	{
		if(commandMap.get(message.toLowerCase()) != null)
		{
			commandVector.add(message.toLowerCase());
			displayVector.add(sender + " pressed: " + message.toLowerCase());
		}	
	}
	
	public Vector<String> GetNextCommand()
	{
		if(commandVector.size() > 0)
		{
			Vector<String> rValue = new Vector<String>();

			rValue.add(commandVector.remove(0));
			rValue.add(displayVector.remove(0));
		
			return rValue;
		}
		
		return null;
	}
	
	public int GetKeyForCommand(String command)
	{
		return commandMap.get(command);
	}
}
	

