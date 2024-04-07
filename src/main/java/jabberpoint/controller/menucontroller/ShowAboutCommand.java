package jabberpoint.controller.menucontroller;

import jabberpoint.AboutBox;
import jabberpoint.Presentation;
import jabberpoint.controller.Command;

import java.awt.Frame;

/**
 * <p>This is the ShowAboutCommand, it's used in MenuController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class ShowAboutCommand extends Command {
    private Frame frame;

    public ShowAboutCommand(Presentation presentation, Frame frame) {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute() {
        AboutBox.show(frame);
    }
}
