package jabberpoint.controller.menucontroller;

import jabberpoint.presentation.Presentation;
import jabberpoint.controller.Command;

import java.awt.Frame;

/**
 * <p>This is the NewFileCommand, it's used in MenuController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class NewFileCommand extends Command {
    private Frame frame;

    public NewFileCommand(Presentation presentation, Frame frame) {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute() {
        this.presentation.clear();
        this.frame.repaint();
    }

}
