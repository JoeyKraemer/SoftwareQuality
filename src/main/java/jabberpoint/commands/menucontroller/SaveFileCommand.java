package jabberpoint.commands.menucontroller;

import jabberpoint.Accessor;
import jabberpoint.Presentation;
import jabberpoint.XMLAccessor;
import jabberpoint.commands.Command;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.JOptionPane;

public class SaveFileCommand extends Command {
    private Frame frame;

    public SaveFileCommand(Presentation presentation, Frame frame) {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute() {
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.saveFile(this.presentation, "dump.xml");
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(this.frame, "IO Exception: " + exc,
                    "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
