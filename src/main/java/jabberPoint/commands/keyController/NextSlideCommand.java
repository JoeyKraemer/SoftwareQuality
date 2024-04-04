package jabberPoint.commands.keyController;

import jabberPoint.Presentation;
import jabberPoint.commands.Command;

public class NextSlideCommand extends Command {
    public NextSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.nextSlide();
    }
}
