package botplay;

/**
 * A command consists of both the message given by whoever gave it
 * and the actual command that the bot needs to use for the virtual key press
 * Created by Nathan on 2/03/2015.
 */
public class Command {

    private String actualCommand;
    private String displayText;

    public String getActualCommand() {
        return actualCommand;
    }

    public String getDisplayText() {
        return displayText;
    }

    public Command(String actualCommand, String displayText) {
        this.actualCommand = actualCommand;
        this.displayText = displayText;
    }


}
