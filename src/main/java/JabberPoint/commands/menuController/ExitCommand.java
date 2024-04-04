package JabberPoint.commands.menuController;

import JabberPoint.Presentation;
import JabberPoint.commands.Command;

public class ExitCommand extends Command
{
    public ExitCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        this.presentation.exit(0);
    }
}
