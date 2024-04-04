package jabberPoint.commands.menuController;

import jabberPoint.Presentation;
import jabberPoint.commands.Command;

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
