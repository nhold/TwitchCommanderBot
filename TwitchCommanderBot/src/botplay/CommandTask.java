package botplay;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.TimerTask;
import java.util.Vector;

/**
 *  A command task is used to schedule how often each command is called by the bot, so if you
 *  limit it to the input lag put into your game each command that someone types will get through.
 * @see java.util.Timer
 * @author Nathan Hold
 *
 */
public class CommandTask extends TimerTask {

	TwitchCommanderBot commanderBot;
	Robot virtualKeyboard;

    /**
     * @param bot The bot that this command task is linked to.
     * @throws AWTException
     */
    public CommandTask(TwitchCommanderBot bot) throws AWTException
	{
		commanderBot = bot;
		virtualKeyboard = new Robot();
	}
	
	public void run() {
		Command comm = commanderBot.GetNextCommand();

		if(comm != null)
		{
			System.out.println(comm.getDisplayText());
			virtualKeyboard.keyPress(commanderBot.GetKeyForCommand(comm.getActualCommand()));
			virtualKeyboard.keyRelease(commanderBot.GetKeyForCommand(comm.getActualCommand()));
		}
	}

}
