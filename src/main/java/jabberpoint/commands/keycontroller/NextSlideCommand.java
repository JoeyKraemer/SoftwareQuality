package jabberpoint.commands.keycontroller;

import jabberpoint.Presentation;
import jabberpoint.commands.Command;

public class NextSlideCommand extends Command {
    public NextSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.nextSlide();
    }
}
