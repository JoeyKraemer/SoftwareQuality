package jabberPoint.commands.keyController;

import jabberPoint.Presentation;
import jabberPoint.commands.Command;

public class QuitCommand extends Command {
    public QuitCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
