package botplay;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.TimerTask;
import java.util.Vector;

/**
 *  When a command task is given to a bot it 
 * @author Nathan
 *
 */
public class CommandTask extends TimerTask {

	TwitchCommanderBot commanderBot;
	Robot virtualKeyboard;

    /**
     * @param bot
     * @throws AWTException
     */
    public CommandTask(TwitchCommanderBot bot) throws AWTException
	{
		commanderBot = bot;
		virtualKeyboard = new Robot();
	}
	
	public void run() {
		Vector <String> r = commanderBot.GetNextCommand();
		if(r != null)
		{
			System.out.println(r.get(1));
			virtualKeyboard.keyPress(commanderBot.GetKeyForCommand(r.firstElement()));
			virtualKeyboard.keyRelease(commanderBot.GetKeyForCommand(r.firstElement()));
		}
	}

}
