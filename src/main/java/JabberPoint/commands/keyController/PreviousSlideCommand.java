package JabberPoint.commands.keyController;

import JabberPoint.Presentation;
import JabberPoint.commands.Command;

public class PreviousSlideCommand extends Command {
    public PreviousSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.prevSlide();
    }
}
