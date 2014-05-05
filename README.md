TwitchCommanderBot
==================

A simple bot that can connect to twitch irc and read in commands and perform virtual keypresses.

Usage
=====

You can look in the TwitchTest project Main to see how to use it, but here is an overview.

- Create a bot

TwitchCommanderBot bot = new TwitchCommanderBot("<TwitchUserNameHere>");

- Add a command to the bot

bot.AddCommand("a", KeyEvent.VK_Z);

- Create the command task (This will use the TwitchCommanderBots GetNextCommand in it's run method)
CommandTask cmdTask = new CommandTask(bot);

- Connect the bot

try {
			bot.connect("199.9.250.229", 6667, "<oauth:>");
		} catch (IOException | IrcException e) {
			e.printStackTrace();
		}

- Create the timer for the command task

Timer timer = new Timer();
timer.schedule(cmdTask, 900, 900);

- Make the bot join the channel

bot.joinChannel(<ChannelName>);
