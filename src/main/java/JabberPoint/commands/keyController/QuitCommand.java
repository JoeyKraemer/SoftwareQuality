package JabberPoint.commands.keyController;

import JabberPoint.Presentation;
import JabberPoint.commands.Command;

import java.awt.event.KeyEvent;

public class QuitCommand extends Command
{
    KeyEvent keyEvent;
    public QuitCommand(Presentation presentation,KeyEvent keyEvent)
    {
        super(presentation);
        this.keyEvent = keyEvent;
    }

    @Override
    public void execute()
    {
        switch (this.keyEvent.getKeyCode()) {
            case 'q':
            case 'Q':
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
