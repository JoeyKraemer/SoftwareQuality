package JabberPoint.commands.keyController;

import JabberPoint.AboutBox;
import JabberPoint.Presentation;
import JabberPoint.commands.Command;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AboutCommand extends Command
{
    private Frame parent;
    public AboutCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        AboutBox.show(parent);
    }
}
