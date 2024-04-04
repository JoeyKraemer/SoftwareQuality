package JabberPoint.commands.menuController;

import JabberPoint.AboutBox;
import JabberPoint.Presentation;
import JabberPoint.commands.Command;

import java.awt.Frame;

public class ShowAboutCommand extends Command
{
    private Frame frame;
    public ShowAboutCommand(Presentation presentation, Frame frame)
    {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute()
    {
        AboutBox.show(frame);
    }
}
