package jabberpoint.controller.menucontroller;

import jabberpoint.Presentation;
import jabberpoint.controller.Command;

import java.awt.Frame;

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
