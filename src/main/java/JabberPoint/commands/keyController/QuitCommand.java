package JabberPoint.commands.keyController;

import JabberPoint.Presentation;
import JabberPoint.commands.Command;

import java.awt.event.KeyEvent;

public class QuitCommand extends Command {
    public QuitCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
