package JabberPoint.commands.keyController;

import JabberPoint.Presentation;
import JabberPoint.commands.Command;

public class NextSlideCommand extends Command {
    public NextSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.nextSlide();
    }
}
