package jabberpoint.controller.menucontroller;

import jabberpoint.Accessor;
import jabberpoint.Presentation;
import jabberpoint.XMLAccessor;
import jabberpoint.controller.Command;


import javax.swing.JOptionPane;
import java.awt.Frame;
import java.io.IOException;

/**
 * <p>This is the OpenFileCommand, it's used in MenuController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class OpenFileCommand extends Command {
    private Frame frame;

    public OpenFileCommand(Presentation presentation, Frame frame) {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute() {
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
