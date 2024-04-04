package jabberPoint.commands.keyController;

import jabberPoint.Presentation;
import jabberPoint.commands.Command;

public class PreviousSlideCommand extends Command {
    public PreviousSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.prevSlide();
    }
}
