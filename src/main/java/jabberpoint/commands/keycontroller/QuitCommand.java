package jabberpoint.commands.keycontroller;

import jabberpoint.Presentation;
import jabberpoint.commands.Command;

public class QuitCommand extends Command {
    public QuitCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
