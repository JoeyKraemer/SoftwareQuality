package jabberpoint.commands.keycontroller;

import jabberpoint.Presentation;
import jabberpoint.commands.Command;

public class PreviousSlideCommand extends Command {
    public PreviousSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.prevSlide();
    }
}
