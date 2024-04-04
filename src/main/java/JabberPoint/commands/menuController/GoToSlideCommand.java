package JabberPoint.commands.menuController;

import JabberPoint.Presentation;
import JabberPoint.commands.Command;

import javax.swing.JOptionPane;

public class GoToSlideCommand extends Command
{
    public GoToSlideCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        String pageNumberStr = JOptionPane.showInputDialog((Object)"Page number?");
        int pageNumber = Integer.parseInt(pageNumberStr);
        this.presentation.setSlideNumber(pageNumber - 1);
    }
}
