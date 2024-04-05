package jabberpoint.controller.keycontroller;

import jabberpoint.Presentation;
import jabberpoint.controller.Command;

public class QuitCommand extends Command {
    public QuitCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
