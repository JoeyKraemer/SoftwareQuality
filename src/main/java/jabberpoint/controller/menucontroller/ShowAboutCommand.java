package jabberpoint.controller.menucontroller;

import jabberpoint.AboutBox;
import jabberpoint.Presentation;
import jabberpoint.controller.Command;

import java.awt.Frame;

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
