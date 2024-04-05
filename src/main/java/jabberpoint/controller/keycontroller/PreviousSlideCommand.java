package jabberpoint.controller.keycontroller;

import jabberpoint.Presentation;
import jabberpoint.controller.Command;

public class PreviousSlideCommand extends Command {
    public PreviousSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.prevSlide();
    }
}
