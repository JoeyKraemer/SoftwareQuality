package JabberPoint.commands.keyController;

import JabberPoint.Accessor;
import JabberPoint.Presentation;
import JabberPoint.XMLAccessor;
import JabberPoint.commands.Command;


import javax.swing.JOptionPane;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class OpenFileCommand extends Command
{
    private Frame frame;
    public OpenFileCommand(Presentation presentation,Frame frame)
    {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute()
    {
        this.presentation.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.loadFile(this.presentation, "test.xml");
            this.presentation.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(this.frame, "IO Exception: " + exc, "Load Error", JOptionPane.ERROR_MESSAGE);
        }
        this.frame.repaint();
    }
}
